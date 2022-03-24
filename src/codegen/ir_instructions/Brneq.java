package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brneq extends Branch implements IRInstruction {
    public Brneq(String[] args) {
        super(args);
    }

    public String opcode() {
        return "brneq";
    } 
}
