package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Mult extends Binop implements IRInstruction {
    public Mult(String[] args) {
        super(args);
    }

    public String opcode() {
        return "mult";
    } 
}
