package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brneq extends Branch implements IRInstruction {
    private String instruction;

    public String getInstruction() {
        return instruction;
    }
    public Brneq(String instruction, String[] args) {
        super(args);
        this.instruction = instruction;
    }

    public String opcode() {
        return "brneq";
    } 
}
