package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class And extends Binop implements IRInstruction {
    public And(String[] args) {
        super(args);
    }

    public String opcode() {
        return "and";
    } 
}
