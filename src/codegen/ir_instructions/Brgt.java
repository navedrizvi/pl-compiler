package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brgt extends Branch implements IRInstruction {
    public Brgt(String[] args) {
        super(args);
    }

    public String opcode() {
        return "brgt";
    } 
}
