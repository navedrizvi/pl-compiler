package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Return implements IRInstruction {
    private String return_var;
    private String instruction;

    public String getInstruction() {
        return instruction;
    }
    public Return(String instruction, String[] args) {
        this.return_var = args[0];
        this.instruction = instruction;
    }

    public String opcode() {
        return "return";
    }

    public List<String> args() {
        return Arrays.asList(this.return_var);
    }

    public String getReturn_var() {
        return return_var;
    }
}
