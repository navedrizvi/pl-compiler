package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Div extends Binop implements IRInstruction {
    public Div(String[] args) {
        super(args);
    }

    public String opcode() {
        return "div";
    } 
}
