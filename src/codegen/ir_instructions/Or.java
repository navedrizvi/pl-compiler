package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Or extends Binop implements IRInstruction {
    public Or(String[] args) {
        super(args);
    }

    public String opcode() {
        return "or";
    } 
}
