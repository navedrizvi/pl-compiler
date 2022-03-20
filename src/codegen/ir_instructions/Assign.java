package codegen.ir_instructions;

import java.util.Arrays;
import java.util.List;

public class Assign implements IRInstruction {
    private String left;
    private String right;

    public Assign(String[] args) {
        this.left = args[0];
        this.right = args[1];
    }

    public String opcode() {
        return "assign";
    }

    public List<String> args() {
        return Arrays.asList(this.left, this.right);
    }    
}
