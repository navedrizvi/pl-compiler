package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brleq extends Branch implements IRInstruction {
    public Brleq(String[] args) {
        super(args);
    }

    public String opcode() {
        return "brleq";
    } 
}
