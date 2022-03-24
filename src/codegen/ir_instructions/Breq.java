package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Breq extends Branch implements IRInstruction {
    public Breq(String[] args) {
        super(args);
    }

    public String opcode() {
        return "breq";
    } 
}
