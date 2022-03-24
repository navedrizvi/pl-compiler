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

    public static List<String> saveRegisters = Arrays.asList("$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "s7");
    public static List<String> tempRegisters = Arrays.asList("$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$t8", "$t9");
    List<InstrRegallocTuple> instructions;
    HashSet<String> intSet;
    HashSet<String> floatSet;
    HashMap<String, String> arraySet;
    HashMap<String, Integer> _variableLocations;

    public MipsCodeGenerator(FunctionBlock functionBlock, String functionName, String[] intList, String[] floatList, List<InstrRegallocTuple> instructions) {
        this.instructions = instructions;
        this.intList = intList;
        this.floatList = floatList;
        this.stackPointer = 0;
        this.stackSize = 0;
        this.functionName = functionName;
        this.intSet = new HashSet<String>();
        this.floatSet = new HashSet<String>();
        this.arraySet = new HashMap<String, String>();
    }

    private static boolean isRegister(String var) {
        return var.charAt(0) == '$';
    }

    public void emit(MipsInstruction instr) {
        this.mipsOutput.add(instr);
        // Todo update sp
    }

    public List<MipsInstruction> generateMipsInstructions() {
        List<MipsInstruction> out = new ArrayList<>();

        for (InstrRegallocTuple instruction: this.instructions) {
            List<String> args = instruction.irInstruction.args();
            if (instruction.irInstruction instanceof Add) {
                String arg1 = args.get(0);
                String arg2 = args.get(1);
                if(!isRegister(arg2)) {
                    // TODO use temporaries carefully to meet limit requirement
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
            else if (instruction.irInstruction instanceof And) {

            }
            else if (instruction.irInstruction instanceof Array_load) {

            }
            else if (instruction.irInstruction instanceof Array_store) {

            }
            else if (instruction.irInstruction instanceof Breq) {

            }
            else if (instruction.irInstruction instanceof Brgeq) {

            }
            else if (instruction.irInstruction instanceof Brgt) {

            }
            else if (instruction.irInstruction instanceof Brleq) {

            }
            else if (instruction.irInstruction instanceof Brlt) {

            }
            else if (instruction.irInstruction instanceof Brneq) {

            }
            else if (instruction.irInstruction instanceof Call) {

            }
            else if (instruction.irInstruction instanceof Callr) {

            }
            else if (instruction.irInstruction instanceof Div) {

            }
            else if (instruction.irInstruction instanceof Goto) {

            }
            else if (instruction.irInstruction instanceof Label) {
                this.emit(new label(args.get(0)));
            }
            else if (instruction.irInstruction instanceof Mult) {

            }
            else if (instruction.irInstruction instanceof Or) {

            }
            else if (instruction.irInstruction instanceof Sub) {

            }
            else if (instruction.irInstruction instanceof ReturnVoid) {

            }
            else if (instruction.irInstruction instanceof Return) {

            }
            else if (instruction.irInstruction instanceof AssignArray) {

            }
            else if (instruction.irInstruction instanceof Assign) {

            }
            else {
                throw new UnsupportedOperationException("IR to mips not supported: " + instruction.irInstruction.opcode());
            }

        }
        return out;
    }



    //** */ Static classes
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
            this.immediate = immediate;
        }
        @Override
        public List<String> args() {
            return Arrays.asList(this.immediate);
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
