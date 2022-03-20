package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brlt extends Branch implements IRInstruction {
    public Brlt(String[] args) {
        super(args);
    }

    public String opcode() {
        return "brlt";
    } 
}
