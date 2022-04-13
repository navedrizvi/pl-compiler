package codegen.ir_instructions;

import codegen.ir_instructions.types.Branch;

public class Brleq extends Branch implements IRInstruction {
    private String instruction;

    public String getInstruction() {
        return instruction;
    }
    public Brleq(String instruction, String[] args) {
        super(args);
        this.instruction = instruction;
    }

    public String opcode() {
        return "brleq";
    } 
}
