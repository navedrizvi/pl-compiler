package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brgeq extends Branch implements IRInstruction {
    public Brgeq(String[] args) {
        super(args);
    }

    public String opcode() {
        return "brgeq";
    } 
}
