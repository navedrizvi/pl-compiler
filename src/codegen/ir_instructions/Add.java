package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Add extends Binop implements IRInstruction {
    public Add(String[] args) {
        super(args);
    }

    public String opcode() {
        return "add";
    }
}
