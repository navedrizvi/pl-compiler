package codegen.ir_instructions;
import codegen.ir_instructions.types.Binop;

public class Sub extends Binop implements IRInstruction {
    public Sub(String[] args) {
        super(args);
    }

    public String opcode() {
        return "sub";
    } 
}
