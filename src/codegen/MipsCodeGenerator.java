package codegen;

import java.util.*;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;

public class MipsCodeGenerator {
    public List<MipsInstruction> mipsOutput = new ArrayList<>();

    String functionName;
    private int stackPointer = 0;
    private int stackSize = 0;
    List<String> intList;
    List<String> floatList;
    List<String> staticIntList;
    List<String> staticFloatList;

    // TODO use registers carefully to meet limit requirement
//    ArrayList<String> temp = Arrays.asList("$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "s7");
    //public static List<String> tempRegisters = Arrays.asList("$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$t8", "$t9");

    final String STACK_POINTER = "$sp";
    final String RETURN_ADDRESS = "$ra";
    final String FUNCTION_RETURN_VALUE_0 = "$v0";
    final String FUNCTION_RETURN_VALUE_1 = "$v1";
    final String PRINT_INTEGER_ARG = "$a0";
    final String PRINT_FLOAT_ARG = "$f12";
    final String PRINT_STRING_ARG = "$a0";
    IRInstruction[] instructions;
    HashSet<String> intSet;
    HashSet<String> floatSet;
    HashMap<String, String> arraySet;
    HashMap<String, Integer> _variableLocations;
    HashMap<String, RegAllocTuple> registerAllocation;
    Stack<String> freeSaveRegisters;
    Stack<String> freeTempRegisters;
    Stack<String> freeReserveRegisters;
    Set<String> usedSaveRegisters;
    Set<String> usedTempRegisters;
    Set<String> usedReserveRegisters;

    public MipsCodeGenerator(IRInstruction[] instructions, String functionName, List<String> staticIntList, List<String> staticFloatList, String[] intList, String[] floatList, HashMap<String, RegAllocTuple> registerAllocation) {
//    public MipsCodeGenerator(FunctionBlock functionBlock, String functionName, String[] intList, String[] floatList, List<InstrRegallocTuple> instructions) {
        this.instructions = instructions;
        this.intList = Arrays.asList(intList);
        this.floatList = Arrays.asList(floatList);
        this.stackPointer = 0;
        this.stackSize = 0;
        this.functionName = functionName;
        this.intSet = new HashSet<String>();
        this.floatSet = new HashSet<String>();
        this.arraySet = new HashMap<String, String>();
        this.registerAllocation = registerAllocation;
        this.freeSaveRegisters = new Stack<>();
        this.freeSaveRegisters.addAll(Arrays.asList("$s7", "$s6", "$s5", "$s4", "$s3", "$s2", "$s1", "s0"));
        this.freeTempRegisters = new Stack<>();
        this.freeTempRegisters.addAll(Arrays.asList("$t7", "$t6", "$t5", "$t4", "$t3", "$t2", "$t1", "$t0"));
        this.freeReserveRegisters = new Stack<>();
        this.freeReserveRegisters.addAll(Arrays.asList("$t8", "$t9", "$v1", "$gp", "$fp"));
        this.usedSaveRegisters = new HashSet<>();
        this.usedTempRegisters = new HashSet<>();
        this.usedReserveRegisters = new HashSet<>();
        this.staticIntList = staticIntList;
        this.staticFloatList = staticFloatList;
    }

    private static boolean isRegister(String var) {
        return var.charAt(0) == '$';
    }

    public void emit(MipsInstruction instr) {
        System.out.println(instr.asString());
        this.mipsOutput.add(instr);
        stackPointer += 1;
    }

    private int getSpaceForLocalVariablesFromRegAlloc(HashMap<String, RegAllocTuple> registerAllocation) {
        int stackSpace = 0;
        for (String var: registerAllocation.keySet()) {
            Integer memoryOffSet = Integer.parseInt(registerAllocation.get(var).getMemoryOffset());
            if (memoryOffSet != null) {
                stackSpace += memoryOffSet;
            }
        }
        return stackSpace;
    }

    public List<MipsInstruction> generateMipsInstructions() {
        //List<MipsInstruction> out = new ArrayList<>();
        // For now assuming only main function. I think we should follow call convention for all functions
        this.emit(new functionName(functionName));
        int spaceForLocalVariables = getSpaceForLocalVariablesFromRegAlloc(registerAllocation);
        this.emit(new comment("# start of prologue"));
        this.emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(-1 * spaceForLocalVariables)));
        this.emit(new comment("# end of prologue"));

        for (IRInstruction instruction: this.instructions) {
            List<String> args = instruction.args();
            if (instruction instanceof Add) {
                handleAdd((Add) instruction);
            }
            else if (instruction instanceof And) {

            }
            else if (instruction instanceof Array_load) {

            }
            else if (instruction instanceof Array_store) {

            }
            else if (instruction instanceof Breq) {

            }
            else if (instruction instanceof Brgeq) {

            }
            else if (instruction instanceof Brgt) {

            }
            else if (instruction instanceof Brleq) {

            }
            else if (instruction instanceof Brlt) {

            }
            else if (instruction instanceof Brneq) {

            }
            else if (instruction instanceof Call) {
                handleCall((Call) instruction);
            }
            else if (instruction instanceof Callr) {

            }
            else if (instruction instanceof Div) {

            }
            else if (instruction instanceof Goto) {

            }
            else if (instruction instanceof Label) {

            }
            else if (instruction instanceof Mult) {

            }
            else if (instruction instanceof Or) {

            }
            else if (instruction instanceof Sub) {

            }
            else if (instruction instanceof ReturnVoid) {

            }
            else if (instruction instanceof Return) {

            }
            else if (instruction instanceof AssignArray) {

            }
            // assign, a, b
            else if (instruction instanceof Assign) {
                handleAssign((Assign) instruction);
            }
            else {
                throw new UnsupportedOperationException("IR to mips not supported: " + instruction.opcode());
            }
        }
        this.emit(new comment("# start of epilogue"));
        this.emit(new addiu(STACK_POINTER, STACK_POINTER, Integer.toString(spaceForLocalVariables)));
        this.emit(new comment("# end of epilogue"));

        // Return 0
        this.emit(new li(FUNCTION_RETURN_VALUE_0, "0"));
        this.emit(new jr(RETURN_ADDRESS));

        return this.mipsOutput;
    }

    // c = a + b
    // a, b can be values
    // a, b can be int or float
    // c is a variable; can be int or float
    private void handleAdd(Add instruction) {
        System.out.println(instruction.asString());
        System.out.println(instruction.args());
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

        // c = a + b
        emit(new add(register_c, register_a, register_b));
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
        // b
        String register = getRegister(false);
        emit(getLoadCommand(register, b));

        // a
        String register_a = getRegister(false);
        emit(getStoreCommand(register, a));

        addBackRegister(register);

        // left variable is static int
//        if (staticIntList.contains(a)) {
//            String register = getRegister(false);
//            emit(new li(register, instruction.args().get(1)));
//            emit(new sw(register, a));
//            addBackRegister(register);
//        }
//        // left variable is local variable/function argument
//        else {
//            String register = getRegister(false);
//            emit(new li(register, instruction.args().get(1)));
//            emit(new sw(register, registerAllocation.get(instruction.args().get(0)).getMemoryOffset() + "(" + STACK_POINTER + ")"));
//            addBackRegister(register);
//        }
    }

    private void handleCall(Call instruction) {
//        System.out.println(instruction.asString());
//        System.out.println(instruction.args());
        if (instruction.getFunction_name().equals("printi")) {
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
            return;
        }

        if (instruction.getFunction_name().equals("exit")) {
            emit(new li(FUNCTION_RETURN_VALUE_0, "17"));
            emit(new li(PRINT_INTEGER_ARG, instruction.args().get(1)));
            emit(new syscall());

            addNewLine();
            return;
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
        // int static variable
        if (staticIntList.contains(operand)) {
            cmd = new lw(register, operand);
        }
        // int local variable
        else if (intList.contains(operand)) {
            cmd = new lw(register, registerAllocation.get(operand).getMemoryOffset() + "(" + STACK_POINTER + ")");
        }
        // int value
        else {
            cmd = new li(register, operand);
        }
        System.out.println("getLoadCommand: " + register + " " + " " + operand + " " + cmd);
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

    /////
    static abstract class MipsBinOp implements MipsInstruction {
        // TODO fix names
        protected String target;
        protected String left;
        protected String right;

        public MipsBinOp(String target, String right, String left) {
            this.left = left;
            this.right = right;
            this.target = target;
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

    static class subiu extends MipsBinOp {
        public subiu(String left, String right, String temp) {
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
    }

    static class or extends MipsBinOp {
        public or(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class mult extends MipsBinOp {
        public mult(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class mflo extends MipsBinOp {
        public mflo(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class div extends MipsBinOp {
        public div(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class beq extends MipsBranch {
        public beq(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class blez extends MipsBranch {
        public blez(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bgez extends MipsBranch {
        public bgez(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bgltz extends MipsBranch {
        public bgltz(String left, String right, String temp) {
            super(left, right, temp);
        }
    }

    static class bgtz extends MipsBranch {
        public bgtz(String left, String right, String temp) {
            super(left, right, temp);
        }
    }
}
