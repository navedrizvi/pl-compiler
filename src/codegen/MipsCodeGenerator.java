package codegen;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;
import common.SubroutineSymbol;
import common.Symbol;
import common.SymbolTable;

public class MipsCodeGenerator {
    private List<MipsInstruction> mipsOutput = new ArrayList<>();

    String functionName;
    List<String> intList;
    List<String> floatList;
    List<String> staticIntList;
    List<String> staticFloatList;
    int maxArgs;
    // keeping track of offsets of various groups in the stack frame
    Map<String, Integer> stackFrame = new HashMap<>();
    Map<String, RegisterType> argToType = new HashMap<>();
    Map<String, RegisterType> locToType = new HashMap<>();
    List<String> functionArgs;

    final String STACK_POINTER = "$sp";
    final String RETURN_ADDRESS = "$ra";
    final String FUNCTION_RETURN_VALUE_0 = "$v0";
    final String FUNCTION_RETURN_VALUE_1 = "$v1";

    final String FLOAT_FUNCTION_RETURN_VALUE_0 = "$f0";
    final String FLOAT_FUNCTION_RETURN_VALUE_1 = "$f1";
    final String FUNCTION_RETURN_VALUE_2 = "$f2";
    final String FUNCTION_RETURN_VALUE_3 = "$f3";
    final String PRINT_INTEGER_ARG = "$a0";
    final String PRINT_FLOAT_ARG = "$f12";
    final String PRINT_STRING_ARG = "$a0";
    final String ZERO = "$zero";
    final String[] argRegisters = {"$a0", "$a1", "$a2", "$a3"};
    final String[] floatArgRegisters = {"$f12", "$f13", "$f14", "$15"};
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
    // Will be used by intra-block and briggs to keep track of register assigned
    // to var. For intra-block, it will be initialized per-block.
    Map<String, String> varToRegister;

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
    Stack<String> freeReserveFloatRegisters;
    Set<String> usedSaveFloatRegisters;
    Set<String> usedTempFloatRegisters;
    Set<String> usedFnArgsFloatRegisters;
    Set<String> usedReserveFloatRegisters;
    SymbolTable symbolTable;
    String currentRegisterAllocationAlgorithm;

    public MipsCodeGenerator(IRInstruction[] instructions, FunctionBlock functionBlock, SymbolTable symbolTable, int limit) {
//        limit of 0 is when no limit arg is provided (so 0 is no limit)
        this.instructions = instructions;
        this.symbolTable = symbolTable;

        this.freeSaveRegisters = getSaveRegisters(limit);
        this.freeTempRegisters = getTempRegisters(limit);
        this.freeSaveFloatRegisters = getSaveFloatRegisters(limit);
        this.freeTempFloatRegisters = getTempFloatRegisters(limit);

        this.intList = Arrays.asList(functionBlock.getIntList());
        this.floatList = Arrays.asList(functionBlock.getFloatList());
        this.staticIntList = functionBlock.getStaticIntList();
        this.staticFloatList = functionBlock.getStaticFloatList();

        this.functionName = functionBlock.getFunctionName();
        this.functionArgs = functionBlock.getFunctionArgs();
        this.globalFunctionToArgs = functionBlock.getGlobalFunctionToArgs();
        this.maxArgs = Math.max(functionBlock.getMaxArgs(), 4);

        this.freeReserveRegisters = new Stack<>();
        this.freeReserveFloatRegisters = new Stack<>();
        this.freeFnArgsFloatRegisters = new Stack<>();
        this.freeReserveRegisters.addAll(Arrays.asList("$fp", "$gp", "$v1", "$t8", "$t9"));
        this.freeReserveFloatRegisters.addAll(Arrays.asList("$f3", "$f2", "$f1"));
        this.freeFnArgsFloatRegisters.addAll(Arrays.asList("$f15", "$f14", "$f13", "$f12"));

        this.usedSaveRegisters = new HashSet<>();
        this.usedTempRegisters = new HashSet<>();
        this.usedReserveRegisters = new HashSet<>();
        this.usedSaveFloatRegisters = new HashSet<>();
        this.usedTempFloatRegisters = new HashSet<>();
        this.usedFnArgsFloatRegisters = new HashSet<>();
        this.usedReserveFloatRegisters = new HashSet<>();
    }

    private Stack<String> getSaveRegisters(int limit) {
        // pass @limit as 0 to get all registers
        Stack<String> s = new Stack<>();
        List<String> l = Arrays.asList("$s7", "$s6", "$s5", "$s4", "$s3", "$s2", "$s1", "$s0");
        if (limit >= l.size() || limit==0) {
            s.addAll(l);
        }
        else {
            Collections.reverse(l);
            s.addAll(l.subList(0, limit));
        }
        return s;
    }

    private Stack<String> getTempRegisters(int limit) {
        // pass @limit as 0 to get all registers
        Stack<String> s = new Stack<>();
        List<String> l = Arrays.asList("$t7", "$t6", "$t5", "$t4", "$t3", "$t2", "$t1", "$t0");
        if (limit >= l.size() || limit==0) {
            s.addAll(l);
        }
        else {
            Collections.reverse(l);
            s.addAll(l.subList(0, limit));
        }
        return s;
    }

    private Stack<String> getSaveFloatRegisters(int limit) {
        // pass @limit as 0 to get all registers
        Stack<String> s = new Stack<>();
        List<String> l = Arrays.asList("$f31", "$f30", "$f29", "$f28", "$f27", "$f26", "$f25", "$f24", "$f23", "$f22", "$f21", "$f20");
        if (limit >= l.size() || limit==0) {
            s.addAll(l);
        }
        else {
            Collections.reverse(l);
            s.addAll(l.subList(0, limit));
        }
        return s;
    }

    private Stack<String> getTempFloatRegisters(int limit) {
        // pass @limit as 0 to get all registers
        Stack<String> s = new Stack<>();
        List<String> l = Arrays.asList("$f19", "$f18", "$f17", "$f16", "$f11", "$f10", "$f9", "$f8", "$f7", "$f6", "$f5", "$f4");
        if (limit >= l.size() || limit==0) {
            s.addAll(l);
        }
        else {
            Collections.reverse(l);
            s.addAll(l.subList(0, limit));
        }
        return s;
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

    boolean checkIsFloat(String a) {
        if (isFloat(a)) {
            return true;
        }
        Symbol b = this.symbolTable.lookUpMangledName(a);

        boolean isf;
        if (b == null) {
            isf = false;
        }
        else {
            isf = b.getType().equals("float");
        }
        return isf;
    }

    private void calculateLocalVariableOffsets() {
        HashMap<String, RegAllocTuple> varToMemoryOffSet = new HashMap<>();
        // TODO0
        // Handling ints first
        int offset = 0;
        for (String intVar: intList) {
            // int array
            if (intVar.endsWith("]")) {
                int size = Integer.parseInt(intVar.substring(intVar.indexOf("[") + 1, intVar.indexOf("]")));
                String var = intVar.substring(0, intVar.indexOf("["));
                varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), size));
                offset += size * 4;
            }
            else {
                intVar = intVar.replace(",", "");
                intVar = intVar.trim();
                varToMemoryOffSet.put(intVar, new RegAllocTuple(intVar, null, Integer.toString(offset), null));
                offset += 4;
            }
        }

        for (String floatVar: floatList) {
            if (floatVar.endsWith("]")) {
                int size = Integer.parseInt(floatVar.substring(floatVar.indexOf("[") + 1, floatVar.indexOf("]")));
                String var = floatVar.substring(0, floatVar.indexOf("["));
                varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), size));
                offset += size * 4;
            }
            else {
                floatVar = floatVar.replace(",", "");
                floatVar = floatVar.trim();
                varToMemoryOffSet.put(floatVar, new RegAllocTuple(floatVar, null, Integer.toString(offset), null));
                offset += 4;
            }
        }
        this.registerAllocation = varToMemoryOffSet;
    }

    private void emit(MipsInstruction instr) {
        if (instr == null)
            return;
        this.mipsOutput.add(instr);
    }

    private int getSpaceForStackFrame(HashMap<String, RegAllocTuple> registerAllocation) {
        int stackSize = 0;
        int max = 0;

        // function call with max number of arguments
        stackFrame.put("funcArgs", 0);
        stackSize += maxArgs * 4;

        // save registers - for now lets allocate for all save registers

        // TODO1 change these freeSaveRegisters to freeFloatSaveRegisters
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

    public List<MipsInstruction> generateMipsInstructionsForNaive() {
        currentRegisterAllocationAlgorithm = "naive";
        varToRegister = new HashMap<>();
        calculateLocalVariableOffsets();
        addPrologue();

        handleIRInstructionsForNaive();

        return this.mipsOutput;
    }

    public List<MipsInstruction> generateMipsInstructionsForIntraBlock(Map<BasicBlock, Map<String, Integer>> sortedHistogramByCountDesc) {
        currentRegisterAllocationAlgorithm = "intraBlock";
        calculateLocalVariableOffsets();
        addPrologue();

        // For each block, we will load/store as many registers as early as possible (on the boundaries),
        // rest will be loaded/stored from memory per use.
        for(Map.Entry<BasicBlock, Map<String, Integer>> entry: sortedHistogramByCountDesc.entrySet()) {
            BasicBlock block = entry.getKey();
            Map<String, Integer> histogram = entry.getValue();
            varToRegister = getVarToRegister(histogram);

            boolean exited = handleIRInstructionsForIntraBlock(block);

            // Store eligible registers back into memory
            if (!exited)
                storeRegistersAtBlockExit();

            for (Map.Entry<String, String> entry1: varToRegister.entrySet()) {
                addBackRegister(entry1.getValue());
            }
        }

        return this.mipsOutput;
    }

    public List<MipsInstruction> generateMipsInstructionsForBriggs(InterferenceGraph interferenceGraph) {
        currentRegisterAllocationAlgorithm = "briggs";
        varToRegister = new HashMap<>();
        colourIG(interferenceGraph);
        System.out.println(functionName  + ": " + interferenceGraph.edges);
        System.out.println(functionName  + ": " + varToRegister);

        calculateLocalVariableOffsets();
        addPrologue();

        handleIRInstructionsForNaive();
        return this.mipsOutput;
    }

    private void colourIG(InterferenceGraph interferenceGraph) {
        InterferenceGraph clonedIG = interferenceGraph.clone();
        Stack<String> intStack = new Stack<>();
        Stack<String> floatStack = new Stack<>();
        Integer intK = freeSaveRegisters.size() + freeTempRegisters.size();
        Integer floatK = freeSaveFloatRegisters.size() + freeTempFloatRegisters.size();

        // first take care of all nodes with degree < k
        for (String node : interferenceGraph.getNodes()) {
            if (intList.contains(node)) {
                if (clonedIG.getNodeDegree(node) < intK) {
                    intStack.push(node);
                }
            }

            if (floatList.contains(node)) {
                if (clonedIG.getNodeDegree(node) < floatK) {
                    floatStack.push(node);
                }
            }

            clonedIG.removeNode(node);
        }

        // now we have a graph with nodes that all have degree >= k
        if (!clonedIG.isEmpty()) {
            while (true) {
                // choose node with least spill cost - current algorithm: random
                String selected = ((new ArrayList<>(clonedIG.getNodes())).get((new Random()).nextInt(clonedIG.getNodes().size())));
                if (floatList.contains(selected)) {
                    floatStack.push(selected);
                }
                else {
                    intStack.push(selected);
                }
                clonedIG.removeNode(selected);
                if (clonedIG.isEmpty())
                    break;
            }
        }

        if (!intStack.isEmpty())
            colour(intStack, interferenceGraph, freeSaveRegisters, freeTempRegisters);

        if (!floatStack.isEmpty())
            colour(floatStack, interferenceGraph, freeSaveFloatRegisters, freeTempFloatRegisters);

        // remove registers used for briggs so that they dont get over-written by load/store operaitons
        for (String register : varToRegister.values()) {
            if (freeSaveRegisters.contains(register))
                freeSaveRegisters.remove(register);

            if (freeTempRegisters.contains(register))
                freeTempRegisters.remove(register);

            if (freeSaveFloatRegisters.contains(register))
                freeSaveFloatRegisters.remove(register);

            if (freeTempFloatRegisters.contains(register))
                freeTempFloatRegisters.remove(register);
        }
    }

    private void colour(Stack<String> stack, InterferenceGraph graph, List<String> saveRegisters, List<String> tempRegisters) {
        Set<String> colours = new HashSet<>(Stream.of(saveRegisters, tempRegisters).flatMap(Collection::stream).collect(Collectors.toList()));
        while (!stack.isEmpty()) {
            String node = stack.pop();
            Set<String> usedColours = new HashSet<>();
            Set<String> edges = graph.getEdges(node);
            if (edges != null) {
                for (String edge : edges) {
                    if (varToRegister.containsKey(edge)) {
                        usedColours.add(varToRegister.get(edge));
                    }
                }
            }
            Set<String> availableColours = new HashSet<>(colours);
            availableColours.removeAll(usedColours);
            // spill to memory since no satisfying colour found.
            if (availableColours.isEmpty())
                continue;

            // Remove first option from list of available colours
            String colour = (new ArrayList<>(availableColours)).remove(0);
            varToRegister.put(node, colour);
        }

    }

    private void loadRegistersAtBlockEntry() {
        for (Map.Entry<String, String> entry1: varToRegister.entrySet()) {
            String variable = entry1.getKey();
            String register = entry1.getValue();
            if (staticIntList.contains(variable) || staticFloatList.contains(variable)) {
                emit(new lw(register, variable));
            }
            // int local variable
            else {
                emit(new lw(register, registerAllocation.get(variable).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            }
        }
    }

    private void storeRegistersAtBlockExit() {
        for (Map.Entry<String, String> entry1: varToRegister.entrySet()) {
            String variable = entry1.getKey();
            String register = entry1.getValue();
            if (staticIntList.contains(variable) || staticFloatList.contains(variable)) {
                emit(new sw(register, variable));
            }
            else {
                emit(new sw(register, registerAllocation.get(variable).getMemoryOffset() + "(" + STACK_POINTER + ")"));
            }
        }
    }

    private Map<String, String> getVarToRegister(Map<String, Integer> histogram) {
        Map<String, String> result = new HashMap<>();
        for(String variable: histogram.keySet()) {
            // variable is an int
            if (intList.contains(variable) || staticIntList.contains(variable)) {
                // first assign save registers
                if (!freeSaveRegisters.isEmpty()) {
                    String register = getRegister(true);
                    result.put(variable, register);
                }
                // then assign temp registers
                else if (!freeTempRegisters.isEmpty()) {
                    String register = getRegister(false);
                    result.put(variable, register);
                }
                // Else, no more registers and we will need to load/store from memory per use.
            }
            // variable is a float
            else {
                // first assign save registers
                if (!freeSaveFloatRegisters.isEmpty()) {
                    String register = getRegister(true, true);
                    result.put(variable, register);
                }
                // then assign temp registers
                else if (!freeTempFloatRegisters.isEmpty()) {
                    String register = getRegister(false, true);
                    result.put(variable, register);
                }
                // Else, no more registers and we will need to load/store from memory per use.
            }
        }
        return result;
    }

    private void handleIRInstructionsForNaive() {
        for (IRInstruction instruction: this.instructions) {
            handleInstruction(instruction);
        }
    }

    private boolean isBranchOrReturn(String instruction) {
        Set<String> ops = new HashSet<>();
        ops.addAll(Arrays.asList("return", "goto", "breq", "brneq", "brlt", "brgt", "brleq", "brgeq"));
        String op = instruction.split(",")[0].trim();
        if (ops.contains(op))
            return true;
        return false;
    }

    private boolean isLabel(String instruction) {
        return instruction.startsWith("_L") && instruction.endsWith(":");
    }

    private boolean handleIRInstructionsForIntraBlock(BasicBlock block) {
        boolean exited = false;
        List<String> blockInstructions = block.getInstructions();

        for (int i = 0; i < blockInstructions.size(); i++) {
            IRInstruction instruction = instructions[block.getInstructionIndexes().get(i)];
            if (blockInstructions.contains(instruction.getInstruction())) {
                if (instruction.getInstruction().equals(block.getLastInstruction()) && isBranchOrReturn(instruction.getInstruction())) {
                    // Store eligible registers back into memory
                    storeRegistersAtBlockExit();
                    exited = true;
                }
                if (instruction.getInstruction().equals(block.getLeader()) && !isLabel(instruction.getInstruction())) {
                    loadRegistersAtBlockEntry();
                }
                handleInstruction(instruction);
            }
        }
        return exited;
    }

    private void handleInstruction(IRInstruction instruction) {
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
            // only for intra-block
            if (!varToRegister.isEmpty() && currentRegisterAllocationAlgorithm.equals("intraBlock")) {
                loadRegistersAtBlockEntry();
            }
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
            handleReturnVoid((ReturnVoid) instruction);
        }
        else if (instruction instanceof Return) {
            handleReturn((Return) instruction);
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


    private void storeSaveRegisters() {
        int saveRegisterOffset = stackFrame.get("saveRegisters");
        int i = saveRegisterOffset;

        // $s0 to $s7
        List<String> temp = new ArrayList<>(freeSaveRegisters);
        Collections.reverse(temp);
        // $f20 to $f31
        List<String> tempFloat = new ArrayList<>(freeSaveFloatRegisters);

        /// TODO1 needed?
        // int float_idx = 0;
        // int int_idx = 0;
        // for (SubroutineSymbol.Tuple param: params) {
        //     if (param.type.equals("float")) {
        //         emit(new sw(tempFloat.get(float_idx), i + "(" + STACK_POINTER + ")"));
        //         float_idx += 1;
        //     }
        //     else {
        //         emit(new sw(temp.get(int_idx), i + "(" + STACK_POINTER + ")"));
        //         int_idx += 1;
        //     }
        //     i += 4;
        // }
        // System.out.println(fn.getParameters());
        // for (String register: temp) {
        //     emit(new sw(register, i + "(" + STACK_POINTER + ")"));
        //     i += 4;
        // }

        int i2=0;
        for (String register: tempFloat) {
            // addrIsFloat(idx)
            emit(new sw(register, i + "(" + STACK_POINTER + ")"));
            addToFloatMap(i + "(" + STACK_POINTER + ")", RegisterType.Float);
            i += 4;
            if (i2==7) {
                break;
            }
            i2+=1;
        }
    }

    private void loadSaveRegisters() {
        int saveRegisterOffset = stackFrame.get("saveRegisters");
        int i = saveRegisterOffset;
        List<String> temp = new ArrayList<>(freeSaveRegisters);
        // $f20 to $f31
        List<String> tempFloat = new ArrayList<>(freeSaveFloatRegisters);

        Collections.reverse(temp);
        // $s0 to $s7
        // for (String register: temp) {
        //     emit(new lw(register, i + "(" + STACK_POINTER + ")"));
        //     i+= 4;
        // }
        int i2=0;
        for (String register: tempFloat) {
            emit(new lw(register, i + "(" + STACK_POINTER + ")"));
            i += 4;
            if (i2==7) {
                break;
            }
            i2+=1;
        }
    }

    private void handleReturnVoid(ReturnVoid instruction) {
        addEpilogue();
    }

    private void handleReturn(Return instruction) {
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

        addEpilogue();
    }

    private void addPrologue() {
        emit(new functionName(functionName));
        emit(new comment("# start of prologue"));
        // space for stack frame
        stackFrameSize = getSpaceForStackFrame(registerAllocation);
        emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(-1 * stackFrameSize)));

        // TODO1 fix this
        storeCallerFunctionArgs();
        // TODO1 fix this
        storeSaveRegisters();
        emit(new sw(RETURN_ADDRESS, stackFrame.get("returnAddress") + "(" + STACK_POINTER + ")"));
        emit(new comment("# end of prologue"));
    }

    private void addEpilogue() {
        emit(new comment("# start of epilogue"));
        // restore save registers
        // TODO1 fix this
        loadSaveRegisters();
        // restore return address
        emit(new lw(RETURN_ADDRESS, stackFrame.get("returnAddress") + "(" + STACK_POINTER + ")"));
        emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(stackFrameSize)));
        emit(new comment("# end of epilogue"));

        emit(new jr(RETURN_ADDRESS));
    }

    private void handleCompOp(String a, String b, String label, String op) {
        boolean addBackA = false;
        boolean addBackB = false;

        // a
        String register_a;
        if (varToRegister.containsKey(a)) {
            register_a = varToRegister.get(a);
        }
        else {
            addBackA = true;
            register_a = getRegister(false, addrIsFloat3(a));
        }
        emit(getLoadCommand(register_a, a));

        // b
        String register_b;
        if (varToRegister.containsKey(b)) {
            register_b = varToRegister.get(b);
        }
        else {
            addBackB = true;
            register_b = getRegister(false, addrIsFloat3(a));
        }
        emit(getLoadCommand(register_b, b));

        if (op.equals("beq"))
            emit(new beq(register_a, register_b, label));
        if (op.equals("bne"))
            emit(new bne(register_a, register_b, label));
        if (op.equals("blt"))
            emit(new blt(register_a, register_b, label));
        if (op.equals("ble"))
            emit(new ble(register_a, register_b, label));
        if (op.equals("bgt"))
            emit(new bgt(register_a, register_b, label));
        if (op.equals("bge"))
            emit(new bge(register_a, register_b, label));

        if (addBackB)
            addBackRegister(register_b);
        if (addBackA)
            addBackRegister(register_a);
    }

    private void handleBreq(Breq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "beq");
    }

    private void handleBrneq(Brneq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "bne");
    }

    private void handleBrlt(Brlt instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "blt");
    }

    private void handleBrleq(Brleq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "ble");
    }

    private void handleBrgt(Brgt instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "bgt");
    }

    private void handleBrgeq(Brgeq instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String label = instruction.args().get(2);
        handleCompOp(a, b, label, "bge");
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
            String registerValue = getRegister(false);
            emit(new lw(registerValue, indexOffset + "(" + STACK_POINTER + ")"));
            emit(getStoreCommand(registerValue, var));

            addBackRegister(registerValue);

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
            String registerValue = getRegister(false);
            emit(getLoadCommand(registerValue, value));

            emit(new sw(registerValue, indexOffset + "(" + STACK_POINTER + ")"));

            addBackRegister(registerValue);
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

        // only ints
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            if (addrIsFloat3(b)) {
                handleFloatBinOp(c, a, b, "add");
            }
            else {
                handleIntBinOp(c, a, b, "add");
            }
        }
        // Contains floats
        else {
            handleFloatBinOp(c, a, b, "add");
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

        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            if (addrIsFloat3(b)) {
                handleFloatBinOp(c, a, b, "sub");
            }
            else {
                // only ints
                handleIntBinOp(c, a, b, "sub");
            }
        }
        // Contains floats
        else {
            handleFloatBinOp(c, a, b, "sub");
        }
    }

    // c = a * b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleMult(Mult instruction) {
        System.out.println("int mult");
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        // only ints
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            handleIntBinOp(c, a, b, "mul");
        }
        // Contains floats
        else {
            handleFloatBinOp(c, a, b, "mul");
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

        // only ints
        // if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c) && !addrIsFloat2(b)) {
        if (!checkIsFloat(a) && !checkIsFloat(b) && !checkIsFloat(c)) {
            if (addrIsFloat3(b)) {
                handleFloatBinOp(c, a, b, "div");
            }
            else {
                handleIntBinOp(c, a, b, "div");
            }
        }
        // Contains floats
        else {
            handleFloatBinOp(c, a, b, "div");
        }
    }

    private void handleFloatBinOp(String c, String a, String b, String op) {
        // TODO0001 : needs to get set 
        String register_a = "";
        String register_b = "";
        String register_c = "";
        boolean addBackA = false;
        boolean addBackB = false;
        boolean addBackC = false;
        boolean aWasCasted = false;
        boolean bWasCasted = false;

        if (floatList.contains(a)) {
            register_a = getRegister(false, true);
        }
        if (floatList.contains(b)) {
            register_b = getRegister(false, true);
        }
        if (floatList.contains(c)) {
            register_c = getRegister(false, true);
        }

        if (checkIsFloat(c)) {
            if (varToRegister.containsKey(c)) {
                register_c = varToRegister.get(c);
            }
            else {
                addBackC = true;
                register_c = getRegister(false, true);
            }
            if (!checkIsFloat(a)) {
                register_a = emitFloatCastInstrs(a);
                if (!isInt(a)) {
                    emit(getStoreCommand(register_a, a));
                    aWasCasted = true;
                }
            }
            else {
                if (varToRegister.containsKey(a)) {
                    register_a = varToRegister.get(a);
                }
                else {
                    addBackA = true;
                    register_a = getRegister(false, true);
                }
            }
            if (!checkIsFloat(b)) {
                register_b = emitFloatCastInstrs(b);
                if (!isInt(b)) {
                    emit(getStoreCommand(register_b, b));
                    bWasCasted = true;
                }
            }
            else {
                if (varToRegister.containsKey(b)) {
                    register_b = varToRegister.get(b);
                }
                else {
                    addBackB = true;
                    register_b = getRegister(false, true);
                }
            }
        }
        else if (checkIsFloat(a)) {
            if (varToRegister.containsKey(a)) {
                register_a = varToRegister.get(a);
            }
            else {
                addBackA = true;
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
                if (varToRegister.containsKey(b)) {
                    register_b = varToRegister.get(b);
                }
                else {
                    addBackB = true;
                    register_b = getRegister(false, true);
                }
            }
            if (!checkIsFloat(c)) {
                register_c = emitFloatCastInstrs(c);
                if (!isInt(c))
                    emit(getStoreCommand(register_c, c));
            }
            else {
                if (varToRegister.containsKey(c)) {
                    register_c = varToRegister.get(c);
                }
                else {
                    addBackC = true;
                    register_c = getRegister(false, true);
                }
            }
        }
        else if (checkIsFloat(b)) {
            if (varToRegister.containsKey(b)) {
                register_b = varToRegister.get(b);
            }
            else {
                addBackB = true;
                register_b = getRegister(false, true);
            }
            if (!checkIsFloat(a)) {
                register_a = emitFloatCastInstrs(a);
                if (!isInt(a)) {
                    emit(getStoreCommand(register_a, a));
                    aWasCasted = true;
                }
            }
            else {
                if (varToRegister.containsKey(a)) {
                    register_a = varToRegister.get(a);
                }
                else {
                    addBackA = true;
                    register_a = getRegister(false, true);
                }
            }
            if (!checkIsFloat(c)) {
                register_c = emitFloatCastInstrs(c);
                if (!isInt(c))
                    emit(getStoreCommand(register_c, c));
            }
            else {
                if (varToRegister.containsKey(c)) {
                    register_c = varToRegister.get(c);
                }
                else {
                    addBackC = true;
                    register_c = getRegister(false, true);
                }
            }
        }

        emit(getLoadCommand(register_a, a));
        emit(getLoadCommand(register_b, b));
        emit(getLoadCommand(register_c, c));

        if (op.equals("add")) {
            emit(new add(register_c, register_a, register_b));
        }
        if (op.equals("sub")) {
            emit(new sub(register_c, register_a, register_b));
        }
        if (op.equals("mul")) {
            emit(new mul(register_c, register_a, register_b));
        }
        if (op.equals("div")) {
            emit(new div(register_c, register_a, register_b));
        }
        emit(getStoreCommand(register_c, c));

        if (addBackC)
            addBackRegister(register_c);
        if (addBackB)
            addBackRegister(register_b);
        if (addBackA)
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

    private void handleIntBinOp(String c, String a, String b, String op) {
        System.out.println("in handleIntBinOp: " + a + " " + " " + b + " " + c + " " + op);
        String register_a;
        String register_b ;
        String register_c;
        boolean addBackA = false;
        boolean addBackB = false;
        boolean addBackC = false;

        // a
        if (varToRegister.containsKey(a)) {
            register_a = varToRegister.get(a);
        }
        else {
            addBackA = true;
            register_a = getRegister(false);
        }
        System.out.println("register a");
        emit(getLoadCommand(register_a, a));

        // b
        if (varToRegister.containsKey(b)) {
            register_b = varToRegister.get(b);
        }
        else {
            addBackB = true;
            register_b = getRegister(false);
        }
        System.out.println("register b");
        emit(getLoadCommand(register_b, b));

        // c
        if (varToRegister.containsKey(c)) {
            register_c = varToRegister.get(c);
        }
        else {
            addBackC = true;
            register_c = getRegister(false);
        }
        System.out.println("register c");
        if (!(register_c.equals(register_b) || register_c.equals(register_a)))
            emit(getLoadCommand(register_c, c));


        if (op.equals("add")) {
            emit(new add(register_c, register_a, register_b));
        }
        if (op.equals("sub")) {
            emit(new sub(register_c, register_a, register_b));
        }
        if (op.equals("mul")) {
            emit(new mul(register_c, register_a, register_b));
        }
        if (op.equals("div")) {
            emit(new div(register_c, register_a, register_b));
        }
        if (op.equals("and")) {
            emit(new and(register_c, register_a, register_b));
        }
        if (op.equals("or")) {
            emit(new or(register_c, register_a, register_b));
        }
        emit(getStoreCommand(register_c, c));

        if (addBackC)
            addBackRegister(register_c);
        if (addBackB)
            addBackRegister(register_b);
        if (addBackA)
            addBackRegister(register_a);
    }

    // c = a & b
    // a, b can be values
    // a, b can be only be int
    // c is a variable; can be only int
    private void handleAnd(And instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        handleIntBinOp(c, a, b, "and");
    }

    // c = a | b
    // a, b can be values
    // a, b can be only be int
    // c is a variable; can be only int
    private void handleOr(Or instruction) {
        String a = instruction.args().get(0);
        String b = instruction.args().get(1);
        String c = instruction.args().get(2);

        handleIntBinOp(c, a, b, "or");
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

            if (aOrBIsFloat) {
//                String register = getRegister(false, aOrBIsFloat);
                String register;
                boolean addBack = false;
                if (varToRegister.containsKey(b)) {
                    register = varToRegister.get(b);
                }
                else {
                    addBack = true;
                    register = getRegister(false, aOrBIsFloat);
                }
                if (!checkIsFloat(b)) {
                    String floatTemp = emitFloatCastInstrs(b);
                    emit(getStoreCommand(floatTemp, a));
                    addBackRegister(floatTemp);
                }
                else {
                    emit(getLoadCommand(register, b));
                    emit(getStoreCommand(register, a));
                }
                if (addBack)
                    addBackRegister(register);
            }
            else {
                // b
                /// TODO0000
                String register;
                boolean addBack = false;
                if (varToRegister.containsKey(b)) {
                    register = varToRegister.get(b);
                }
                else {
                    addBack = true;
                    if (registerAllocation.get(b) !=null ) {
                        String loc = registerAllocation.get(b).getMemoryOffset() + "(" + STACK_POINTER + ")";
                        if (argToType.containsKey(loc)) {
                            register = getRegister(false, addrIsFloat2(loc));
                        }
                        else {
                            register = getRegister(false);//, addrIsFloat2(loc));
                        }
                    }
                    else {
                        register = getRegister(false);
                    }
                }
                emit(getLoadCommand(register, b));

                // a
                emit(getStoreCommand(register, a));

                if (addBack)
                    addBackRegister(register);
            }
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
            // store registers to stack before function call
            if (!varToRegister.isEmpty()) {
                storeRegistersAtBlockExit();
            }
            emit(new jal(instruction.getFunction_name()));
            // load registers from stack after function call
            if(!varToRegister.isEmpty()) {
                loadRegistersAtBlockEntry();
            }
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
            // TODO no addback?
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
                if (symbolTable.lookUpMangledName(arg) == null) {
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
            String register = varToRegister.get(arg);
            if (register != null) {
                emit(new move(PRINT_INTEGER_ARG, register));
            }
            else {
                register = getRegister(false);
                emit(new lw(register, registerAllocation.get(arg).getMemoryOffset() + "(" + STACK_POINTER + ")"));
                emit(new move(PRINT_INTEGER_ARG, register));
                addBackRegister(register);
            }
        }
        else if (staticIntList.contains(arg)) {
            if (varToRegister.containsKey(arg)) {
                emit(new move(PRINT_INTEGER_ARG, varToRegister.get(arg)));
            }
            else {
                emit(new lw(PRINT_INTEGER_ARG, arg));
            }
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
            String b = instruction.getFunction_args()[0];
            String temp0 = getRegister(false);
            String temp1 = getRegister(false);
            emit(getLoadCommand(temp0, b));
            emit(new sltu(temp1, "$zero", temp0));
            emit(new xori(temp1, temp1, "1"));
            emit(getStoreCommand(temp1, b));
            addBackRegister(temp0);
            addBackRegister(temp1);
        }
        else {
            loadCalleeFunctionArgs(instruction.getFunction_name(), instruction.getFunction_args());
            // Intra-block - update static variables from registers before function call.
            if (!varToRegister.isEmpty()) {
                storeRegistersAtBlockExit();
            }
            emit(new jal(instruction.getFunction_name()));
            if(!varToRegister.isEmpty()) {
                loadRegistersAtBlockEntry();
            }
            String a = instruction.args().get(0);
            emit(getStoreCommand(FUNCTION_RETURN_VALUE_0, a));
        }
    }

    private boolean addrIsFloat(int idx) {
        SubroutineSymbol fn = (SubroutineSymbol) symbolTable.lookUp(functionName);
        SubroutineSymbol.CustomArrayList params = fn.getParameters();
        if (params.get(idx).type.equals("float")) {
            return true;
        }
        return false;
    }

    private boolean addrIsFloat2(String addr) {
        // SubroutineSymbol fn = (SubroutineSymbol) symbolTable.lookUp(functionName);
        // SubroutineSymbol.CustomArrayList params = fn.getParameters();

        // String addr2 = registerAllocation.get(addr).getMemoryOffset() + "(" + STACK_POINTER + ")";
        // System.out.println(addr);
        // if (argToType.get(addr) == RegisterType.Float) {
        //     return true;
        // }
        // return false;
        // return addrIsFloat(nFnArg);
        System.out.println(argToType.keySet());
        if (argToType.containsKey("60($sp)")) {
            System.out.println(argToType.get("60($sp)"));
        }
        if (argToType.get(addr) == RegisterType.Float) {
            return true;
        }
        return false;
    }

    private boolean addrIsFloat3(String addr) {
        // SubroutineSymbol fn = (SubroutineSymbol) symbolTable.lookUp(functionName);
        // SubroutineSymbol.CustomArrayList params = fn.getParameters();

        // String addr2 = registerAllocation.get(addr).getMemoryOffset() + "(" + STACK_POINTER + ")";
        // System.out.println(addr);
        // if (argToType.get(addr) == RegisterType.Float) {
        //     return true;
        // }
        // return false;
        // return addrIsFloat(nFnArg);
        return floatList.contains(addr);
    }

    private void addToFloatMap(String key, RegisterType type) {
        argToType.put(key, type);
    }

    private void storeCallerFunctionArgs() {
        if (functionArgs.isEmpty())
            return;

        int numOfArgs = functionArgs.size();
        for (int i = 0; i < numOfArgs; i++) {
            if (i < 4) {
                // TODO2 needed?
                if (checkIsFloat(functionArgs.get(i))) {
                    emit(new sw(floatArgRegisters[i], registerAllocation.get(functionArgs.get(i)).getMemoryOffset() + "(" + STACK_POINTER + ")"));
                }
                else {
                    String addr = registerAllocation.get(functionArgs.get(i)).getMemoryOffset() + "(" + STACK_POINTER + ")";
                    if (addrIsFloat(i)) {
                        emit(new sw(floatArgRegisters[i], addr));
                        addToFloatMap(addr, RegisterType.Float);
                    }
                    else {
                        emit(new sw(argRegisters[i], addr));
                        // addToTypeMap(addr, RegisterType.Any);
                    }
                }
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
    enum RegisterType {
        Float,
        Any
    }
    private void loadCalleeFunctionArgs(String calleeFunction, String[] args) {
        List<String> calleeFunctionArgs = globalFunctionToArgs.get(calleeFunction);
        if (calleeFunctionArgs.isEmpty())
            return;
        int numOfArgs = calleeFunctionArgs.size();
        int argsOffset = stackFrame.get("funcArgs");
        for (int i = 0; i < numOfArgs; i++) {
            if (i < 4) {
                if (checkIsFloat(args[i])) {
                    emit(getLoadCommand(floatArgRegisters[i], args[i]));
                }
                else {
                    emit(getLoadCommand(argRegisters[i]+"OPOPOPO", args[i]));
                }
            }
            else {
                String register = getRegister(false, checkIsFloat(args[i]));
                emit(getLoadCommand(register +"chuchuchu", args[i]));
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
        System.out.println("getLoadCommand :" + register + " " + operand + " " + varToRegister.get(operand));
        if (varToRegister.containsKey(operand)) {
            if (!varToRegister.get(operand).equals(register)) {
                cmd = new move(register, varToRegister.get(operand));
            }
        }
        // int/float static variable
        else if (staticIntList.contains(operand) || staticFloatList.contains(operand)) {
            cmd = new lw(register, operand);
        }
        else if (intList.contains(operand) || floatList.contains(operand)) {
            String fullStackTrace = Arrays.toString(Thread.currentThread().getStackTrace()).replace( ',', '\n' );
            cmd = new lw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
        }
        else if (symbolTable.lookUpMangledName(operand)!=null) {
            cmd = new lw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
        }
        else {
            cmd = new li(register, operand);
        }
        return cmd;
    }

    private MipsInstruction getStoreCommand(String register, String operand) {
        if (varToRegister.containsKey(operand)) {
            if(!varToRegister.get(operand).equals(register))
                return new move(varToRegister.get(operand), register);
        }
        if (staticIntList.contains(operand)) {
            return new sw(register, operand);
        }
        // if (isInt(operand)||isFloat(operand)) {
        //     return new sw(register, operand);
        // }

        if (register.startsWith("$f")) {
            String loc = registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")";
            addToFloatMap(loc, RegisterType.Float);
            // locToType.put(loc, Re)
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
            // now look at reserved registers
            if (freeReserveRegisters.isEmpty())
                throw new UnsupportedOperationException("No more registers.");
            temp = freeReserveRegisters.pop();
            usedReserveRegisters.add(temp);
            return temp;
        }

        if (!freeSaveRegisters.isEmpty()) {
            temp = freeSaveRegisters.pop();
            usedSaveRegisters.add(temp);
            return temp;
        }
        // TODO1 add handling freesfloatsave

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

        if (usedReserveRegisters.contains(register)) {
            usedReserveRegisters.remove(register);
            freeReserveRegisters.push(register);
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

    static class sltu implements MipsInstruction {
        String one;
        String two;
        String three;
        public sltu(String one, String two, String three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.one, this.two, this.three);
        }
    }

    static class xori implements MipsInstruction {
        String one;
        String two;
        String three;
        public xori(String one, String two, String three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.one, this.two, this.three);
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
