package codegen;

import java.util.*;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;
import common.Symbol;
import common.SymbolTable;

public class MipsCodeGenerator {
    public List<MipsInstruction> mipsOutput = new ArrayList<>();

    String functionName;
    List<String> intList;
    List<String> floatList;
    List<String> staticIntList;
    List<String> staticFloatList;
    int maxArgs;
    // keeping track of offsets of various groups in the stack frame
    Map<String, Integer> stackFrame = new HashMap<>();
    List<String> functionArgs;

    final String STACK_POINTER = "$sp";
    final String RETURN_ADDRESS = "$ra";
    final String FUNCTION_RETURN_VALUE_0 = "$v0";
    final String FUNCTION_RETURN_VALUE_1 = "$v1";
    final String PRINT_INTEGER_ARG = "$a0";
    final String PRINT_FLOAT_ARG = "$f12";
    final String PRINT_STRING_ARG = "$a0";
    final String ZERO = "$zero";
    final String[] argRegisters = {"$a0", "$a1", "$a2", "$a3"};
    IRInstruction[] instructions;
    HashMap<String, RegAllocTuple> registerAllocation;
    Stack<String> freeSaveRegisters;
    Stack<String> freeTempRegisters;
    Stack<String> freeReserveRegisters;
    Set<String> usedSaveRegisters;
    Set<String> usedTempRegisters;
    Set<String> usedReserveRegisters;
    String returnValueIndex = null;
    int stackFrameSize = 0;
    private Map<String, List<String>> globalFunctionToArgs;

    /*
    Floating-point Registers
    $f0 - $f3 Function return values
    $f4 - $f11, $f16 - $f19 Temporary registers
    $f12 - $f15 Arguments to functions
    $f20 - $f31 Saved registers
    */

    final String FUNCTION_FLOAT_RETURN_VALUE_0 = "$f0";
    final String FUNCTION_FLOAT_RETURN_VALUE_1 = "$f1";
    final String FUNCTION_FLOAT_RETURN_VALUE_2 = "$f2";
    final String FUNCTION_FLOAT_RETURN_VALUE_3 = "$f3";
    Stack<String> freeTempFloatRegisters;
    Stack<String> freeSaveFloatRegisters;
    Stack<String> freeFnArgsFloatRegisters;
    Set<String> usedSaveFloatRegisters;
    Set<String> usedTempFloatRegisters;
    Set<String> usedFnArgsFloatRegisters;
    SymbolTable symbolTable;

    public MipsCodeGenerator(IRInstruction[] instructions, FunctionBlock functionBlock, HashMap<String, RegAllocTuple> registerAllocation, SymbolTable symbolTable) {
        this.instructions = instructions;
        this.intList = Arrays.asList(functionBlock.getIntList());
        this.floatList = Arrays.asList(functionBlock.getIntList());
        this.functionName = functionBlock.getFunctionName();
        this.registerAllocation = registerAllocation;
        this.freeSaveRegisters = new Stack<>();
        this.freeSaveRegisters.addAll(Arrays.asList("$s7", "$s6", "$s5", "$s4", "$s3", "$s2", "$s1", "$s0"));
        this.freeTempRegisters = new Stack<>();
        this.freeTempRegisters.addAll(Arrays.asList("$t7", "$t6", "$t5", "$t4", "$t3", "$t2", "$t1", "$t0"));
        this.freeReserveRegisters = new Stack<>();
        this.freeReserveRegisters.addAll(Arrays.asList("$t8", "$t9", "$v1", "$gp", "$fp"));
        this.usedSaveRegisters = new HashSet<>();
        this.usedTempRegisters = new HashSet<>();
        this.usedReserveRegisters = new HashSet<>();
        this.staticIntList = functionBlock.getStaticIntList();
        this.staticFloatList = functionBlock.getStaticFloatList();
        this.maxArgs = Math.max(functionBlock.getMaxArgs(), 4);
        this.functionArgs = functionBlock.getFunctionArgs();
        this.globalFunctionToArgs = functionBlock.getGlobalFunctionToArgs();

        this.freeSaveFloatRegisters = new Stack<>();
        this.freeSaveFloatRegisters.addAll(Arrays.asList("$f31", "$f30", "$f29", "$f28", "$f27", "$f26", "$f25", "$f24", "$f23", "$f22", "$f21", "$f20"));
        this.freeTempFloatRegisters = new Stack<>();
        this.freeTempFloatRegisters.addAll(Arrays.asList("$f19", "$f18", "$f17", "$f16", "$f11", "$f10", "$f9", "$f8", "$f7", "$f6", "$f5", "$f4"));
        this.freeFnArgsFloatRegisters = new Stack<>();
        this.freeFnArgsFloatRegisters.addAll(Arrays.asList("$f15", "$f14", "$f13"));
        this.usedSaveFloatRegisters = new HashSet<>();
        this.usedTempFloatRegisters = new HashSet<>();
        this.usedFnArgsFloatRegisters = new HashSet<>();

        this.symbolTable = symbolTable;
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return !isInt(s);
        } catch (NumberFormatException e){
            return false;
        }
    }

    // TODO1 fix - safe?
    private static String getUnmangledName(String st) {
        return st.replaceAll("_[0-9]+_", "");
    }

    boolean checkIsFloat(String a) {
        String name = getUnmangledName(a);
        Symbol b = this.symbolTable.lookUp(name);

        boolean isf;
        if (b==null) {
            isf = isFloat(a);
        }
        else {
            isf = b.getType().equals("float");
        }
        return isf;
    }

    public void emit(MipsInstruction instr) {
        this.mipsOutput.add(instr);
    }

    private int getSpaceForStackFrame(HashMap<String, RegAllocTuple> registerAllocation) {
        int stackSize = 0;
        int max = 0;

        // function call with max number of arguments
        stackFrame.put("funcArgs", 0);
        stackSize += maxArgs * 4;

        // save registers - for now lets allocate for all save registers
        stackFrame.put("saveRegisters", stackSize);
        stackSize += freeSaveRegisters.size() * 4;

        // $ra - return address
        stackFrame.put("returnAddress", stackSize);
        stackSize += 4;

        // space for local variables
        stackFrame.put("localStorage", stackSize);
        for (String var: registerAllocation.keySet()) {
            Integer memoryOffSet = Integer.parseInt(registerAllocation.get(var).getMemoryOffset());
            if (memoryOffSet != null && memoryOffSet > max) {
                max = memoryOffSet;
            }
        }

        // adjust offsets for register allocation
        for (String variable: registerAllocation.keySet()) {
            RegAllocTuple regAlloc = registerAllocation.get(variable);
            int currentOffset = Integer.parseInt(regAlloc.getMemoryOffset());
            regAlloc.setMemoryOffset(Integer.toString((currentOffset + stackSize)));
            registerAllocation.put(variable, regAlloc);
        }

        // we know that arrays will never come at the end of list of variables so we need to only add 4 to accommodate
        // stack allocation space for the last variable.
        stackSize += max + 4;

        return stackSize;
    }

    public List<MipsInstruction> generateMipsInstructions() {
        // For now assuming only main function. I think we should follow call convention for all functions
        emit(new functionName(functionName));
        emit(new comment("# start of prologue"));
        // space for stack frame
        stackFrameSize = getSpaceForStackFrame(registerAllocation);
        emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(-1 * stackFrameSize)));
        storeCallerFunctionArgs();
        storeSaveRegisters();
        emit(new sw(RETURN_ADDRESS, stackFrame.get("returnAddress") + "(" + STACK_POINTER + ")"));
        emit(new comment("# end of prologue"));

        for (IRInstruction instruction: this.instructions) {
            if (instruction instanceof Add) {
                handleAdd((Add) instruction);
            }
            else if (instruction instanceof And) {
                handleAnd((And) instruction);
            }
            // a := arr[index]
            else if (instruction instanceof Array_load) {
                handleArrayLoad((Array_load) instruction);
            }
            // arr[index] := a
            else if (instruction instanceof Array_store) {
                handleArrayStore((Array_store) instruction);
            }
            else if (instruction instanceof Breq) {
                handleBreq((Breq) instruction);
            }
            else if (instruction instanceof Brgeq) {
                handleBrgeq((Brgeq) instruction);
            }
            else if (instruction instanceof Brgt) {
                handleBrgt((Brgt) instruction);
            }
            else if (instruction instanceof Brleq) {
                handleBrleq((Brleq) instruction);
            }
            else if (instruction instanceof Brlt) {
                handleBrlt((Brlt) instruction);
            }
            else if (instruction instanceof Brneq) {
                handleBrneq((Brneq) instruction);
            }
            else if (instruction instanceof Call) {
                handleCall((Call) instruction);
            }
            else if (instruction instanceof Callr) {
                handleCallr((Callr) instruction);
            }
            else if (instruction instanceof Div) {
                handleDiv((Div) instruction);
            }
            else if (instruction instanceof Goto) {
                emit(new j(((Goto) instruction).getLabel()));
            }
            else if (instruction instanceof Label) {
                emit(new label(((Label) instruction).getName()));
            }
            else if (instruction instanceof Mult) {
                handleMult((Mult) instruction);
            }
            else if (instruction instanceof Or) {
                handleOr((Or) instruction);
            }
            else if (instruction instanceof Sub) {
                handleSub((Sub) instruction);
            }
            else if (instruction instanceof ReturnVoid) {
                // TODO: might need to do opposite of storeCallerFunctionArgs
                emit(new comment("# start of epilogue"));
                // restore save registers
                loadSaveRegisters();
                // restore return address
                emit(new lw(RETURN_ADDRESS, stackFrame.get("returnAddress") + "(" + STACK_POINTER + ")"));
                emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(stackFrameSize)));
                emit(new comment("# end of epilogue"));


                emit(new jr(RETURN_ADDRESS));
            }
            else if (instruction instanceof Return) {
                String returnValue = ((Return) instruction).getReturn_var();
                // return value is a variable, else return value is a var
                if (registerAllocation.get(returnValue) != null) {
                    returnValueIndex = registerAllocation.get(returnValue).getMemoryOffset();
                }
                // return value is a value

                if (functionName.equals("main")) {
                    // main - return 0
                    emit(new li(FUNCTION_RETURN_VALUE_0, "0"));
                }
                // function with non-void return value
                else if (returnValueIndex != null) {
                    emit(new lw(FUNCTION_RETURN_VALUE_0, returnValueIndex + "(" + STACK_POINTER + ")"));
                }
                else {
                    emit(new li(FUNCTION_RETURN_VALUE_0, returnValue));
                }

                // TODO: might need to do opposite of storeCallerFunctionArgs
                emit(new comment("# start of epilogue"));
                // restore save registers
                loadSaveRegisters();
                // restore return address
                emit(new lw(RETURN_ADDRESS, stackFrame.get("returnAddress") + "(" + STACK_POINTER + ")"));
                emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(stackFrameSize)));
                emit(new comment("# end of epilogue"));

                emit(new jr(RETURN_ADDRESS));
            }
            // assign, arr, size, default_value
            else if (instruction instanceof AssignArray) {
                handleAssignArray((AssignArray) instruction);
            }
            // assign, a, b
            else if (instruction instanceof Assign) {
                handleAssign((Assign) instruction);
            }
            else {
                throw new UnsupportedOperationException("IR to mips not supported: " + instruction.opcode());
            }
        }

        return this.mipsOutput;
    }

    private void storeSaveRegisters() {
        int saveRegisterOffset = stackFrame.get("saveRegisters");
        int i = saveRegisterOffset;
        List<String> temp = new ArrayList<>(freeSaveRegisters);
        Collections.reverse(temp);
        // $s0 to $s7
        for (String register: temp) {
            emit(new sw(register, i + "(" + STACK_POINTER + ")"));
            i += 4;
        }
    }

    private void loadSaveRegisters() {
        int saveRegisterOffset = stackFrame.get("saveRegisters");
        int i = saveRegisterOffset;
        List<String> temp = new ArrayList<>(freeSaveRegisters);
        Collections.reverse(temp);
        // $s0 to $s7
        for (String register: temp) {
            emit(new lw(register, i + "(" + STACK_POINTER + ")"));
            i+= 4;
        }
    }

    private void handleBrneq(Brneq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a != b
        emit(new bne(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleBrlt(Brlt instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a < b
        emit(new blt(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleBrleq(Brleq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a <= b
        emit(new ble(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleBrgt(Brgt instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a > b
        emit(new bgt(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleBrgeq(Brgeq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a >= b
        emit(new bge(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleBreq(Breq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));


        // c = a == b
        emit(new beq(register_a, register_b, label));

        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    private void handleArrayLoad(Array_load instruction) {
        String var = instruction.args().get(0);
        String arrayVar = instruction.args().get(1);
        String index = instruction.args().get(2);

        if (registerAllocation.get(arrayVar) == null) {
            handleArrayLoadStatic(var, arrayVar, index);
        } else {
            handleArrayLoadLocal(var, arrayVar, index);
        }
    }

    private void handleArrayLoadStatic(String var, String arrayVar, String index) {
        // index is an integer value
        try {
            String registerArrayVar = getRegister(false);
            emit(new la(registerArrayVar, arrayVar));

            int indexOffSet = Integer.parseInt(index) * 4;
            // addi $t0, $t0, $t1
            emit(new addi(registerArrayVar, registerArrayVar, Integer.toString(indexOffSet)));

            String registerVar = getRegister(false);
            emit(new lw(registerVar, "(" + registerArrayVar + ")"));
            emit(getStoreCommand(registerVar, var));

            addBackRegister(registerVar);
            addBackRegister(registerArrayVar);
        }
        // index is a variable
        catch (NumberFormatException e){
            // arrayVar
            String registerArrayVar = getRegister(false);
            emit(new la(registerArrayVar, arrayVar));

            // index variable - stored in $t1
            String registerIndex = getRegister(false);
            emit(getLoadCommand(registerIndex, index));

            String registerTemp = getRegister(false);
            emit(new li(registerTemp, "4"));

            emit(new mul(registerTemp, registerIndex, registerTemp));

            // addu $t0, $t0, $t1
            emit(new addu(registerArrayVar, registerArrayVar, registerTemp));

            String registerVar = getRegister(false);
            emit(new lw(registerVar, "(" + registerArrayVar + ")"));
            emit(getStoreCommand(registerVar, var));

            addBackRegister(registerTemp);
            addBackRegister(registerIndex);
            addBackRegister(registerVar);
            addBackRegister(registerArrayVar);
        }
    }

    private void handleArrayLoadLocal(String var, String arrayVar, String index) {
        // index is an integer value
        try {
            int indexOffset = Integer.parseInt(registerAllocation.get(arrayVar).getMemoryOffset()) + Integer.parseInt(index) * 4;
            // value
            String register_var = getRegister(false);
            emit(new lw(register_var, indexOffset + "(" + STACK_POINTER + ")"));
            emit(getStoreCommand(register_var, var));

            addBackRegister(register_var);
        }
        // index is a variable
        catch (NumberFormatException e){

            // register pointer
            String registerPointer = getRegister(false);
            // move $t0, $sp
            emit(new move(registerPointer, STACK_POINTER));
            // addiu $t0, $t0, <base offset of array>
            emit(new addiu(registerPointer, registerPointer, registerAllocation.get(arrayVar).getMemoryOffset()));

            // index variable - stored in $t1
            String registerIndex = getRegister(false);
            emit(getLoadCommand(registerIndex, index));

            String registerTemp = getRegister(false);
            emit(new li(registerTemp, "4"));

            emit(new mul(registerTemp, registerIndex, registerTemp));

            // addu $t0, $t0, $t1
            emit(new addu(registerPointer, registerPointer, registerTemp));

            String register_var = getRegister(false);
            emit(new lw(register_var,  "0(" + registerPointer + ")"));
            emit(getStoreCommand(register_var, var));

            addBackRegister(register_var);
            addBackRegister(registerTemp);
            addBackRegister(registerIndex);
            addBackRegister(registerPointer);
        }
    }

    private void handleArrayStore(Array_store instruction) {
        String arrayVar = instruction.args().get(0);
        String index = instruction.args().get(1);
        String value = instruction.args().get(2);

        if (registerAllocation.get(arrayVar) == null) {
            handleArrayStoreStatic(arrayVar, index, value);
        } else {
            handleArrayStoreLocal(arrayVar, index, value);
        }
    }

    private void handleArrayStoreStatic(String arrayVar, String index, String value) {
        // index is an integer value
        try {
            // arrayVar
            String registerArrayVar = getRegister(false);
            emit(new la(registerArrayVar, arrayVar));

            // value
            String registerValue = getRegister(false);
            emit(getLoadCommand(registerValue, value));

            int indexOffSet = Integer.parseInt(index) * 4;

            // addi $t0, $t0, $t1
            emit(new addi(registerArrayVar, registerArrayVar, Integer.toString(indexOffSet)));

            emit(new sw(registerValue,  "(" + registerArrayVar + ")"));

            addBackRegister(registerArrayVar);
            addBackRegister(registerValue);
        }
        // index is a variable
        catch (NumberFormatException e){
            // arrayVar
            String registerArrayVar = getRegister(false);
            emit(new la(registerArrayVar, arrayVar));

            // value
            String registerValue = getRegister(false);
            emit(getLoadCommand(registerValue, value));

            // index variable - stored in $t1
            String registerIndex = getRegister(false);
            emit(getLoadCommand(registerIndex, index));

            String registerTemp = getRegister(false);
            emit(new li(registerTemp, "4"));

            emit(new mul(registerTemp, registerIndex, registerTemp));

            // addu $t0, $t0, $t1
            emit(new addu(registerArrayVar, registerArrayVar, registerTemp));

            emit(new sw(registerValue,  "(" + registerArrayVar + ")"));

            addBackRegister(registerTemp);
            addBackRegister(registerIndex);
            addBackRegister(registerValue);
            addBackRegister(registerArrayVar);
        }
    }

    private void handleArrayStoreLocal(String arrayVar, String index, String value) {
        // index is an integer value
        try {
            int indexOffset = Integer.parseInt(registerAllocation.get(arrayVar).getMemoryOffset()) + Integer.parseInt(index) * 4;
            // value
            String register_value = getRegister(false);
            emit(getLoadCommand(register_value, value));

            emit(new sw(register_value, indexOffset + "(" + STACK_POINTER + ")"));

            addBackRegister(register_value);
        }
        // index is a variable
        catch (NumberFormatException e){

            // register pointer
            String registerPointer = getRegister(false);
            // move $t0, $sp
            emit(new move(registerPointer, STACK_POINTER));
            // addiu $t0, $t0, <base offset of array>
            emit(new addiu(registerPointer, registerPointer, registerAllocation.get(arrayVar).getMemoryOffset()));

            // index variable - stored in $t1
            String registerIndex = getRegister(false);
            emit(getLoadCommand(registerIndex, index));

            String registerTemp = getRegister(false);
            emit(new li(registerTemp, "4"));

            emit(new mul(registerTemp, registerIndex, registerTemp));

            // addu $t0, $t0, $t1
            emit(new addu(registerPointer, registerPointer, registerTemp));

            // value
            String registerValue = getRegister(false);
            emit(getLoadCommand(registerValue, value));

            // store value in index of array
            emit(new sw(registerValue, "0(" + registerPointer + ")"));

            addBackRegister(registerValue);
            addBackRegister(registerTemp);
            addBackRegister(registerIndex);
            addBackRegister(registerPointer);
        }
    }

    private void handleAssignArray(AssignArray instruction) {
        String arrayVar = instruction.args().get(0);
        int size = Integer.parseInt(instruction.args().get(1));
        String defaultValue = instruction.args().get(2);

        if (registerAllocation.get(arrayVar) == null) {
            handleAssignArrayStatic(arrayVar, size, defaultValue);
        }
        else {
            handleAssignArrayLocal(arrayVar, size, defaultValue);
        }
    }

    private void handleAssignArrayLocal(String arrayVar, int size, String defaultValue) {
        String register = getRegister(false);
        emit(new li(register, defaultValue));
        int indexOffset = 0;
        for(int i = 0; i < size; i++) {
            indexOffset = Integer.parseInt(registerAllocation.get(arrayVar).getMemoryOffset()) + i * 4;
            emit(new sw(register, indexOffset + "(" + STACK_POINTER + ")"));
        }

        addBackRegister(register);
    }

    private void handleAssignArrayStatic(String arrayVar, int size, String defaultValue) {
        String registerDefaultValue = getRegister(false);
        emit(new li(registerDefaultValue, defaultValue));

        String registerArrayVar = getRegister(false);
        emit (new la(registerArrayVar, arrayVar));
        int indexOffset = 4;
        emit(new sw(registerDefaultValue,  "(" + registerArrayVar + ")"));
        for(int i = 1; i < size; i++) {
            // addi $t0, $t0, $t1
            emit(new addi(registerArrayVar, registerArrayVar, Integer.toString(indexOffset)));
            emit(new sw(registerDefaultValue,  "(" + registerArrayVar + ")"));
        }

        addBackRegister(registerArrayVar);
        addBackRegister(registerDefaultValue);
    }

    // c = a + b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleAdd(Add instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        String register_a="";
        String register_b="";
        String register_c="";
        boolean aWasCasted = false;
        boolean bWasCasted = false;
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            register_a = getRegister(false);
            register_b = getRegister(false);
            register_c = getRegister(false);
        }
        else {
            if (checkIsFloat(c)) {
                register_c = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
            }
            else if (checkIsFloat(a)) {
                register_a = getRegister(false, true);
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
            else if (checkIsFloat(b)) {
                register_b = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
        }
        emit(getLoadCommand(register_a, a));
        emit(getLoadCommand(register_b, b));
        emit(getLoadCommand(register_c, c));

        // c = a + b
        emit(new add(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);

        // Un-cast
        if (aWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_a, a));
            emit(new cvt_w_s(register_a, register_a));
            emit(new mtc1(temp, register_a));
            emit(getStoreCommand(temp, a));
            addBackRegister(temp);
        }
        if (bWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_b, b));
            emit(new cvt_w_s(register_b, register_b));
            emit(new mtc1(temp, register_b));
            emit(getStoreCommand(temp, b));
            addBackRegister(temp);
        }
    }

    // c = a - b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleSub(Sub instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        String register_a="";
        String register_b="";
        String register_c="";
        boolean aWasCasted = false;
        boolean bWasCasted = false;
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            register_a = getRegister(false);
            register_b = getRegister(false);
            register_c = getRegister(false);
        }
        else {
            if (checkIsFloat(c)) {
                register_c = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
            }
            else if (checkIsFloat(a)) {
                register_a = getRegister(false, true);
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
            else if (checkIsFloat(b)) {
                register_b = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
        }
        emit(getLoadCommand(register_a, a));
        emit(getLoadCommand(register_b, b));
        emit(getLoadCommand(register_c, c));

        // c = a - b
        emit(new sub(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);

        // Un-cast
        if (aWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_a, a));
            emit(new cvt_w_s(register_a, register_a));
            emit(new mtc1(temp, register_a));
            emit(getStoreCommand(temp, a));
            addBackRegister(temp);
        }
        if (bWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_b, b));
            emit(new cvt_w_s(register_b, register_b));
            emit(new mtc1(temp, register_b));
            emit(getStoreCommand(temp, b));
            addBackRegister(temp);
        }
    }

    // c = a * b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleMult(Mult instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        String register_a="";
        String register_b="";
        String register_c="";
        boolean aWasCasted = false;
        boolean bWasCasted = false;
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            register_a = getRegister(false);
            register_b = getRegister(false);
            register_c = getRegister(false);
        }
        else {
            if (checkIsFloat(c)) {
                register_c = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
            }
            else if (checkIsFloat(a)) {
                register_a = getRegister(false, true);
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
            else if (checkIsFloat(b)) {
                register_b = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
        }
        emit(getLoadCommand(register_a, a));
        emit(getLoadCommand(register_b, b));
        emit(getLoadCommand(register_c, c));

        // c = a * b
        emit(new mul(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);

        // Un-cast
        if (aWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_a, a));
            emit(new cvt_w_s(register_a, register_a));
            emit(new mtc1(temp, register_a));
            emit(getStoreCommand(temp, a));
            addBackRegister(temp);
        }
        if (bWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_b, b));
            emit(new cvt_w_s(register_b, register_b));
            emit(new mtc1(temp, register_b));
            emit(getStoreCommand(temp, b));
            addBackRegister(temp);
        }
    }

    // c = a / b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleDiv(Div instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        String register_a="";
        String register_b="";
        String register_c="";
        boolean aWasCasted = false;
        boolean bWasCasted = false;
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            register_a = getRegister(false);
            register_b = getRegister(false);
            register_c = getRegister(false);
        }
        else {
            if (checkIsFloat(c)) {
                register_c = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
            }
            else if (checkIsFloat(a)) {
                register_a = getRegister(false, true);
                if (!checkIsFloat(b)) {
                    register_b = emitFloatCastInstrs(b);
                    if (!isInt(b)) {
                        emit(getStoreCommand(register_b, b));
                        bWasCasted = true;
                    }
                }
                else {
                    register_b = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
            else if (checkIsFloat(b)) {
                register_b = getRegister(false, true);
                if (!checkIsFloat(a)) {
                    register_a = emitFloatCastInstrs(a);
                    if (!isInt(a)) {
                        emit(getStoreCommand(register_a, a));
                        aWasCasted = true;
                    }
                }
                else {
                    register_a = getRegister(false, true);
                }
                if (!checkIsFloat(c)) {
                    register_c = emitFloatCastInstrs(c);
                    if (!isInt(c))
                        emit(getStoreCommand(register_c, c));
                }
                else {
                    register_c = getRegister(false, true);
                }
            }
        }
        emit(getLoadCommand(register_a, a));
        emit(getLoadCommand(register_b, b));
        emit(getLoadCommand(register_c, c));

        // c = a / b
        emit(new div(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);

        // Un-cast
        if (aWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_a, a));
            emit(new cvt_w_s(register_a, register_a));
            emit(new mtc1(temp, register_a));
            emit(getStoreCommand(temp, a));
            addBackRegister(temp);
        }
        if (bWasCasted) {
            String temp = getRegister(false);
            emit(getLoadCommand(register_b, b));
            emit(new cvt_w_s(register_b, register_b));
            emit(new mtc1(temp, register_b));
            emit(getStoreCommand(temp, b));
            addBackRegister(temp);
        }
    }

    // c = a & b
    // a, b can be values
    // a, b can be only be int
    // c is a variable; can be only int
    private void handleAnd(And instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));

        // c
        String register_c = getRegister(false);
        emit(getLoadCommand(register_c, c));

        // c = a & b
        emit(new and(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    // c = a | b
    // a, b can be values
    // a, b can be only be int
    // c is a variable; can be only int
    private void handleOr(Or instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        // a
        String register_a = getRegister(false);
        emit(getLoadCommand(register_a, a));

        // b
        String register_b = getRegister(false);
        emit(getLoadCommand(register_b, b));

        // c
        String register_c = getRegister(false);
        emit(getLoadCommand(register_c, c));

        // c = a | b
        emit(new or(register_c, register_a, register_b));
        emit(getStoreCommand(register_c, c));

        addBackRegister(register_c);
        addBackRegister(register_b);
        addBackRegister(register_a);
    }

    // assign a, b
    // "b" can be literal value or variable
    // "b" can be int or float
    // "a" will be a variable and can be int/float
    private void handleAssign(Assign instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        // local int array assignment
        if (registerAllocation.get(a) != null && registerAllocation.get(a).getArraySize() != null && registerAllocation.get(b) != null && registerAllocation.get(b).getArraySize() != null) {
            int size = registerAllocation.get(a).getArraySize();
            String register_b = getRegister(false);
            int indexOffsetA = 0;
            int indexOffsetB = 0;
            for(int i = 0; i < size; i++) {
                indexOffsetA = Integer.parseInt(registerAllocation.get(a).getMemoryOffset()) + i * 4;
                indexOffsetB = Integer.parseInt(registerAllocation.get(b).getMemoryOffset()) + i * 4;
                emit(new lw(register_b, indexOffsetB + "(" + STACK_POINTER + ")"));
                emit(new sw(register_b, indexOffsetA + "(" + STACK_POINTER + ")"));
            }

            addBackRegister(register_b);
        }
        // static int array assignment
        else if (staticArraySize(a) != -1) {
            // RHS array is a static array
            if (registerAllocation.get(b) == null) {
                int size = staticArraySize(a);
                String registerA = getRegister(false);
                String registerB = getRegister(false);
                emit(new la(registerA, a));
                emit(new la(registerB, b));
                int indexOffset = 4;
                String register = getRegister(false);
                emit(new lw(register, "(" + registerB + ")"));
                emit(new sw(register, "(" + registerA + ")"));
                for (int i = 1; i < size; i++) {
                    // addi $t0, $t0, $t1
                    emit(new addi(registerB, registerB, Integer.toString(indexOffset)));
                    emit(new addi(registerA, registerA, Integer.toString(indexOffset)));
                    emit(new lw(register, "(" + registerB + ")"));
                    emit(new sw(register, "(" + registerA + ")"));
                }
                addBackRegister(register);
                addBackRegister(registerB);
                addBackRegister(registerA);
            }
            // RHS is a local array
            else {
                // a - static
                int size = staticArraySize(a);
                String registerA = getRegister(false);
                emit(new la(registerA, a));

                // b - local
                String registerB = getRegister(false);

                int indexOffsetA = 4;
                int indexOffsetB = Integer.parseInt(registerAllocation.get(b).getMemoryOffset());

                // first index
                emit(new lw(registerB, indexOffsetB + "(" + STACK_POINTER + ")"));
                emit(new sw(registerB, "(" + registerA + ")"));

                for (int i = 1; i < size; i++) {
                    indexOffsetB = Integer.parseInt(registerAllocation.get(b).getMemoryOffset()) + i * 4;
                    emit(new lw(registerB, indexOffsetB + "(" + STACK_POINTER + ")"));
                    emit(new addi(registerA, registerA, Integer.toString(indexOffsetA)));
                    emit(new sw(registerB, "(" + registerA + ")"));
                }

                addBackRegister(registerB);
                addBackRegister(registerA);
            }
        }
        else {
            boolean aOrBIsFloat = checkIsFloat(a) || checkIsFloat(b);
            String register = getRegister(false, aOrBIsFloat);
            if (aOrBIsFloat) {
                if (!checkIsFloat(b)) {
                    String floatTemp = emitFloatCastInstrs(b);
                    emit(getStoreCommand(floatTemp, a));
                    addBackRegister(floatTemp);
                }
                else {
                    emit(getLoadCommand(register, b));
                    emit(getStoreCommand(register, a));
                }
            }
            else {
                emit(getLoadCommand(register, b));
                emit(getStoreCommand(register, a));
            }
            addBackRegister(register);
        }
    }

    /* Returns name of float register */ 
    private String emitFloatCastInstrs(String operand) {
        String floatTemp = getRegister(false, true);
        if (!isFloat(operand)) {
            // Cast arg to float
            String temp = getRegister(false);
            emit(getLoadCommand(temp, operand));
            emit(new mtc1(temp, floatTemp));
            emit(new cvt_s_w(floatTemp, floatTemp));
            addBackRegister(temp);
        }
        else {
            emit(getLoadCommand(floatTemp, operand));
        }
        return floatTemp;
    }

    private int staticArraySize(String a) {
        for (String intVar : staticIntList) {
            int isArray = intVar.indexOf("[");
            if (isArray == -1)
                continue;
            String varName = intVar.substring(0, intVar.indexOf("["));
            if (varName.equals(a)) {
                return Integer.parseInt(intVar.substring(intVar.indexOf("[") + 1, intVar.indexOf("]")));
            }
        }
        return -1;
    }

    private void handleCall(Call instruction) {
        if (instruction.getFunction_name().equals("printi")) {
            handlePrinti(instruction);
        }
        else if (instruction.getFunction_name().equals("printf")) {
            handlePrintf(instruction);
        }
        else if (instruction.getFunction_name().equals("exit")) {
            handleExit(instruction);
        }
        else {
            loadCalleeFunctionArgs(instruction.getFunction_name(), instruction.getFunction_args());
            emit(new jal(instruction.getFunction_name()));
        }
    }

    private void handlePrintf(Call instruction) {
        emit(new li(FUNCTION_RETURN_VALUE_0, "2"));
        String arg = instruction.args().get(1);
        // printing a integer local variable
        if (intList.contains(arg)) {
            String register = getRegister(false);
            emit(new lw(register, registerAllocation.get(arg).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            emit(new move(PRINT_INTEGER_ARG, register));
            addBackRegister(register);
        }
        else if (floatList.contains(arg)) {
            String register = getRegister(false, true);
            emit(new lw(register, registerAllocation.get(arg).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            emit(new move(PRINT_FLOAT_ARG, register));
            addBackRegister(register);                
        }
        else if (staticIntList.contains(arg)) {
            emit(new lw(PRINT_INTEGER_ARG, arg));
        }
        else if (staticFloatList.contains(arg)) {
            emit(new lw(PRINT_FLOAT_ARG, arg));
        }
        else {
            if (!checkIsFloat(arg)) {
                String floatTemp = emitFloatCastInstrs(arg);
                emit(new move(PRINT_FLOAT_ARG, floatTemp));
                addBackRegister(floatTemp);
            }
            else {
                //TODO1 - unsafe
                if (symbolTable.lookUp(getUnmangledName(arg)) == null) {
                    emit(new li(PRINT_FLOAT_ARG, arg));
                }
                else {
                    emit(new lw(PRINT_FLOAT_ARG, registerAllocation.get(arg).getMemoryOffset() + "(" + STACK_POINTER + ")"));
                }
            }
        }
        emit(new syscall());
        addNewLine();
    }

    private void handlePrinti(Call instruction) {
        emit(new li(FUNCTION_RETURN_VALUE_0, "1"));
        String arg = instruction.args().get(1);
        // printing a integer local variable
        if (intList.contains(arg)) {
            String register = getRegister(false);
            emit(new lw(register, registerAllocation.get(arg).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            emit(new move(PRINT_INTEGER_ARG, register));
            addBackRegister(register);
        }
        else if (staticIntList.contains(arg)) {
            emit(new lw(PRINT_INTEGER_ARG, arg));
        }
        // printing an integer value
        else {
            emit(new li(PRINT_INTEGER_ARG, arg));
        }
        emit(new syscall());

        addNewLine();
    }

    private void handleExit(Call instruction) {
        emit(new li(FUNCTION_RETURN_VALUE_0, "17"));
        emit(new li(PRINT_INTEGER_ARG, instruction.args().get(1)));
        emit(new syscall());

        addNewLine();
    }

    // a = func(...)
    private void handleCallr(Callr instruction) {
        // a = not(b)
        if (instruction.getFunction_name().equals("not")) {
            // TODO1: add inline logic for not function
        }
        else {
            loadCalleeFunctionArgs(instruction.getFunction_name(), instruction.getFunction_args());
            emit(new jal(instruction.getFunction_name()));
            String a = instruction.args().get(0);
            emit(getStoreCommand(FUNCTION_RETURN_VALUE_0, a));
        }
    }

    private void storeCallerFunctionArgs() {
        if (functionArgs.isEmpty())
            return;

        int numOfArgs = functionArgs.size();
        for (int i = 0; i < numOfArgs; i++) {
            if (i < 4) {
                System.out.println(functionArgs.get(i));
                for (String name: registerAllocation.keySet()) {
                    String key = name.toString();
                    String value = registerAllocation.get(name).toString();
                    System.out.println(key + " " + value);
                }
                emit(new sw(argRegisters[i], registerAllocation.get(functionArgs.get(i)).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            }
            else {
                String register = getRegister(false);
                int temp = stackFrameSize + i * 4;
                emit(new lw(register, temp + "(" + STACK_POINTER + ")"));
                emit(new sw(register, registerAllocation.get(functionArgs.get(i)).getMemoryOffset() + "(" + STACK_POINTER + ")"));
                addBackRegister(register);
            }
        }
    }

    // TODO: implement as part of epilogue as opposite to storeCallerFunctionArgs
    private void loadCallerFunctionArgs() {

    }

    private void loadCalleeFunctionArgs(String calleeFunction, String[] args) {
        List<String> calleeFunctionArgs = globalFunctionToArgs.get(calleeFunction);
        if (calleeFunctionArgs.isEmpty())
            return;
        int numOfArgs = calleeFunctionArgs.size();
        int argsOffset = stackFrame.get("funcArgs");
        for (int i = 0; i < numOfArgs; i++) {
            if (i < 4) {
                emit(getLoadCommand(argRegisters[i], args[i]));
            }
            else {
                String register = getRegister(false);
                emit(getLoadCommand(register, args[i]));
                int offset = argsOffset + i * 4;
                emit(new sw(register, offset + "(" + STACK_POINTER + ")"));
                addBackRegister(register);
            }
        }
    }

    private void addNewLine() {
        emit(new li(FUNCTION_RETURN_VALUE_0, "4"));
        emit(new la(PRINT_STRING_ARG, "newline"));
        emit(new syscall());
    }

    // Helper function that will return right load command to emit
    // Currently implementing for ints. Can extend to floats or handle floats in a separate function.
    private MipsInstruction getLoadCommand(String register, String operand) {
        MipsInstruction cmd = null;
        if (staticIntList.contains(operand) || staticFloatList.contains(operand)) {
            cmd = new lw(register, operand);
        }
        else if (intList.contains(operand) || floatList.contains(operand)) {
            cmd = new lw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
        }
        else if (symbolTable.lookUp(getUnmangledName(operand))!=null) {
            cmd = new lw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
        }
        else {
            cmd = new li(register, operand);
        }
        return cmd;
    }

    private MipsInstruction getStoreCommand(String register, String operand) {
        if (staticIntList.contains(operand)) {
            return new sw(register, operand);
        }
        return new sw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
    }

    private String getRegister(boolean requireSave) {
        String temp;
        if (requireSave) {
            if (freeSaveRegisters.isEmpty()) {
                throw new UnsupportedOperationException("No more save registers.");
            }
            temp = freeSaveRegisters.pop();
            usedSaveRegisters.add(temp);
            return temp;
        }
        if (freeTempRegisters.isEmpty() && freeSaveRegisters.isEmpty()) {
            throw new UnsupportedOperationException("No more registers.");
        }
        if (freeTempRegisters.isEmpty()) {
            temp = freeSaveRegisters.pop();
            usedSaveRegisters.add(temp);
            return temp;
        }

        temp = freeTempRegisters.pop();
        usedTempRegisters.add(temp);
        return temp;
    }

    private String getRegister(boolean requireSave, boolean isFloat) {
        String temp;
        if (!isFloat) {
            if (requireSave) {
                if (freeSaveRegisters.isEmpty()) {
                    throw new UnsupportedOperationException("No more save registers.");
                }
                temp = freeSaveRegisters.pop();
                usedSaveRegisters.add(temp);
                return temp;
            }
            if (freeTempRegisters.isEmpty() && freeSaveRegisters.isEmpty()) {
                throw new UnsupportedOperationException("No more registers.");
            }
            if (freeTempRegisters.isEmpty()) {
                temp = freeSaveRegisters.pop();
                usedSaveRegisters.add(temp);
                return temp;
            }

            temp = freeTempRegisters.pop();
            usedTempRegisters.add(temp);
            return temp;
        }
        else {
            if (requireSave) {
                if (freeSaveFloatRegisters.isEmpty()) {
                    throw new UnsupportedOperationException("No more save float registers.");
                }
                temp = freeSaveFloatRegisters.pop();
                usedSaveFloatRegisters.add(temp);
                return temp;
            }
            if (freeTempFloatRegisters.isEmpty() && freeSaveFloatRegisters.isEmpty()) {
                throw new UnsupportedOperationException("No more float registers.");
            }
            if (freeTempFloatRegisters.isEmpty()) {
                temp = freeSaveFloatRegisters.pop();
                usedSaveFloatRegisters.add(temp);
                return temp;
            }
            temp = freeTempFloatRegisters.pop();
            usedTempFloatRegisters.add(temp);
            return temp;
        }
    }

    private void addBackRegister(String register) {
        if (register.startsWith("$t")) {
            if (usedTempRegisters.contains(register)) {
                usedTempRegisters.remove(register);
                freeTempRegisters.push(register);
            }
        }
        if (register.startsWith("$s")) {
            if (usedSaveRegisters.contains(register)) {
                usedSaveRegisters.remove(register);
                freeSaveRegisters.push(register);
            }
        }
        if (register.startsWith("$f")) {
            if (usedSaveFloatRegisters.contains(register)) {
                usedSaveFloatRegisters.remove(register);
                freeSaveFloatRegisters.push(register);
            }
        }
    }

    //** */ Static classes
    static class functionName implements MipsInstruction {
        private String name;
        public functionName(String name) {
            this.name = name;
        }

        @Override
        public List<String> args() {
            return null;
        }

        public String asString() {
            return name + ":";
        }
    }
    static class comment implements  MipsInstruction {
        String comment;
        public comment(String comment) {
            this.comment = comment;
        }

        @Override
        public List<String> args() {
            return null;
        }

        public String asString() {
            return comment;
        }

    }
    static class sw implements MipsInstruction {
        String register;
        String location;
        public sw(String register, String location) {
            this.register = register;
            this.location = location;
        }
        public String asString() {
            if (register.startsWith("$f")) {
                return "s.s" + " " + String.join(", ", this.args());
            }
            return "sw" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.register, this.location);
        }
    }

    static class lw implements MipsInstruction {
        String register;
        String location;
        public lw(String register, String location) {
            this.register = register;
            this.location = location;
        }
        public String asString() {
            if (register.startsWith("$f")) {
                return "l.s" + " " + String.join(", ", this.args());
            }
            return "lw" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.register, this.location);
        }
    }

    static class li implements MipsInstruction {
        String register;
        String immediate;
        public li(String register, String immediate) {
            this.register = register;
            this.immediate = immediate;
        }
        public String asString() {
            if (register.startsWith("$f")) {
                String immediate2 = this.immediate;
                if (isInt(this.immediate)) {
                    immediate2 += ".0";
                }
                return "li.s" + " " + this.register + ", " + immediate2;
            }
            return "li" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.immediate);
        }
    }

    static class mtc1 implements MipsInstruction {
        String register;
        String immediate;
        public mtc1(String register, String immediate) {
            this.register = register;
            this.immediate = immediate;
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.immediate);
        }
    }

    static class mfc1 implements MipsInstruction {
        String register;
        String immediate;
        public mfc1(String register, String immediate) {
            this.register = register;
            this.immediate = immediate;
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.immediate);
        }
    }

    static class cvt_s_w implements MipsInstruction {
        String register;
        String immediate;
        public cvt_s_w(String register, String immediate) {
            this.register = register;
            this.immediate = immediate;
        }
        public String asString() {
            return "cvt.s.w" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.immediate);
        }
    }

    static class cvt_w_s implements MipsInstruction {
        String register;
        String immediate;
        public cvt_w_s(String register, String immediate) {
            this.register = register;
            this.immediate = immediate;
        }
        public String asString() {
            return "cvt.w.s" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.immediate);
        }
    }

    static class la implements MipsInstruction {
        String register;
        String label;
        public la(String register, String label) {
            this.register = register;
            this.label = label;
        }
        @Override
        public List<String> args() {
            return Arrays.asList( this.register,this.label);
        }
    }

    static class move implements MipsInstruction {
        String destination;
        String source;
        public move(String destination, String source) {
            this.destination = destination;
            this.source = source;
        }
        public String asString() {
            if (destination.startsWith("$f") && source.startsWith("$f")) {
                return "mov.s" + " " + String.join(", ", this.args());
            }
            return "move" + " " + String.join(", ", this.args());
        }
        @Override
        public List<String> args() {
            return Arrays.asList(destination, source);
        }
    }

    static class jal implements MipsInstruction {
        private String label;
        public jal(String label) {
            this.label = label;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.label);
        }
    }

    static class j implements MipsInstruction {
        private String label;
        public j(String label) {
            this.label = label;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.label);
        }
    }

    static class jr implements MipsInstruction {
        String register;
        public jr(String register) {
            this.register = register;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.register);
        }
    }

    static class label implements MipsInstruction {
        private String name;
        public label(String name) {
            this.name = name;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.name);
        }
    }

    static class syscall implements MipsInstruction {
        public syscall() {
        }
        @Override
        public List<String> args() {
            return null;
        }
    }

    static abstract class MipsBinOp implements MipsInstruction {
        protected String target;
        protected String right;
        protected String left;

        public MipsBinOp(String target, String right, String left) {
            this.target = target;
            this.right = right;
            this.left = left;
        }

        @Override
        public List<String> args() {
            return Arrays.asList(this.target, this.right, this.left);
        }
    }

    static abstract class MipsBranch implements MipsInstruction {
        // TODO fix names (correct action preserves param order in raw)
        protected String target;
        protected String left;
        protected String right;

        public MipsBranch(String target, String right, String left) {
            this.left = left;
            this.right = right;
            this.target = target;
        }

        @Override
        public List<String> args() {
            return Arrays.asList(this.target, this.right, this.left);
        }
    }
    static class add extends MipsBinOp {
        public add(String one, String two, String three) {
            super(one, two, three);
        }
        public String asString() {
            if (this.left.startsWith("$f") || this.right.startsWith("$f") || this.target.startsWith("$f")) {
                return "add.s" + " " + String.join(", ", this.args());
            }
            return "add" + " " + String.join(", ", this.args());
        }
    }

    static class addi extends MipsBinOp {
        public addi(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class addiu extends MipsBinOp {
        public addiu(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class addu extends MipsBinOp {
        public addu(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class and extends MipsBinOp {
        public and(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class sub extends MipsBinOp {
        public sub(String left, String right, String temp) {
            super(left, right, temp);
        }
        public String asString() {
            if (this.left.startsWith("$f") || this.right.startsWith("$f") || this.target.startsWith("$f")) {
                return "sub.s" + " " + String.join(", ", this.args());
            }
            return "sub" + " " + String.join(", ", this.args());
        }
    }

    static class or extends MipsBinOp {
        public or(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class mul extends MipsBinOp {
        public mul(String left, String right, String temp) {
            super(left, right, temp);
        }
        public String asString() {
            if (this.left.startsWith("$f") || this.right.startsWith("$f") || this.target.startsWith("$f")) {
                return "mul.s" + " " + String.join(", ", this.args());
            }
            return "mul" + " " + String.join(", ", this.args());
        }
    }

    static class div extends MipsBinOp {
        public div(String left, String right, String temp) {
            super(left, right, temp);
        }
        public String asString() {
            if (this.left.startsWith("$f") || this.right.startsWith("$f") || this.target.startsWith("$f")) {
                return "div.s" + " " + String.join(", ", this.args());
            }
            return "div" + " " + String.join(", ", this.args());
        }
    }

    static class beq extends MipsBranch {
        public beq(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bne extends MipsBranch {
        public bne(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class blt extends MipsBranch {
        public blt(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class ble extends MipsBranch {
        public ble(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bgt extends MipsBranch {
        public bgt(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bge extends MipsBranch {
        public bge(String left, String right, String temp) {
            super(left, right, temp);
        }
    }
}
