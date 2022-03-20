package codegen.ir_instructions;

import java.util.Arrays;
import java.util.List;

public class Return implements IRInstruction {
    private String return_var;
    public Return(String[] args) {
        this.return_var = args[0];
    }

    public String opcode() {
        return "return";
    }

    public List<String> args() {
        return Arrays.asList(this.return_var);
    }    
}
