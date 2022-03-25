package codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;

public class MipsCodeGenerator {
    public List<MipsInstruction> mipsOutput = new ArrayList<>();

    String functionName;
    private int stackPointer = 0;
    private int stackSize = 0;
    String[] intList;
    String[] floatList;

    // TODO use registers carefully to meet limit requirement
    public static List<String> saveRegisters = Arrays.asList("$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "s7");
    public static List<String> tempRegisters = Arrays.asList("$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$t8", "$t9");
    final String STACK_POINTER = "$sp";
    final String RETURN_ADDRESS = "$ra";
    final String FUNCTION_RETURN_VALUE_0 = "$v0";
    final String FUNCTION_RETURN_VALUE_1 = "$v1";
    IRInstruction[] instructions;
    HashSet<String> intSet;
    HashSet<String> floatSet;
    HashMap<String, String> arraySet;
    HashMap<String, Integer> _variableLocations;
    HashMap<String, RegAllocTuple> registerAllocation;

    public MipsCodeGenerator(IRInstruction[] instructions, String functionName, String[] intList, String[] floatList, HashMap<String, RegAllocTuple> registerAllocation) {
//    public MipsCodeGenerator(FunctionBlock functionBlock, String functionName, String[] intList, String[] floatList, List<InstrRegallocTuple> instructions) {
        this.instructions = instructions;
        this.intList = intList;
        this.floatList = floatList;
        this.stackPointer = 0;
        this.stackSize = 0;
        this.functionName = functionName;
        this.intSet = new HashSet<String>();
        this.floatSet = new HashSet<String>();
        this.arraySet = new HashMap<String, String>();
        this.registerAllocation = registerAllocation;
    }

    private static boolean isRegister(String var) {
        return var.charAt(0) == '$';
    }

    public void emit(MipsInstruction instr) {
        this.mipsOutput.add(instr);
        stackPointer += 1;
    }

    private int getSpaceForLocalVariablesFromRegAlloc(HashMap<String, RegAllocTuple> registerAllocation) {
        int stackSpace = 0;
        for (String var: registerAllocation.keySet()) {
            Integer memoryOffSet = registerAllocation.get(var).getMemoryOffset();
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
                String arg1 = args.get(0);
                String arg2 = args.get(1);
                if(!isRegister(arg2)) {
                    arg2 = tempRegisters.get(0);
                    this.emit(new li(arg1, arg2));
                }
                if(!isRegister(arg1)) {
                    arg1 = tempRegisters.get(2);
                    this.emit(new li(arg1, arg2));
                }
                MipsInstruction instr = new and(args.get(2), arg1, arg2);
                this.emit(instr);
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
                Call ir = (Call) instruction;
                if (ir.getFunction_name().equals("printi")) {
                    emit(new li(FUNCTION_RETURN_VALUE_0, "1"));
                    emit(new lw("$t1", registerAllocation.get(ir.args().get(1)).getMemoryOffset().toString() + "($sp)"));
                    emit(new move("$a0", "$t1"));
                    emit(new syscall());

//                    li $v0, 4       # you can call it your way as well with addi
//                    la $a0, newline       # load address of the string
//                            syscall
                    emit(new li(FUNCTION_RETURN_VALUE_0, "4"));
                    emit(new la("$a0", "newline"));
                    emit(new syscall());
                }

            }
            else if (instruction instanceof Callr) {

            }
            else if (instruction instanceof Div) {

            }
            else if (instruction instanceof Goto) {

            }
            else if (instruction instanceof Label) {
                this.emit(new label(args.get(0)));
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
                this.emit(new li("$t0", instruction.args().get(1)));
                this.emit(new sw("$t0", registerAllocation.get(instruction.args().get(0)).getMemoryOffset().toString() + "($sp)"));
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
