package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Add extends Binop implements IRInstruction {

    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    public Add(String instruction, String[] args) {
        super(args);
        this.instruction = instruction;
    }

    public String opcode() {
        return "add";
    }
}
