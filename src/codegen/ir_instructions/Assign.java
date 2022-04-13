package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assign implements IRInstruction {
    private String left;
    private String right;
    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    public Assign(String instruction, String[] args) {
        this.left = args[0];
        this.right = args[1];
        this.instruction = instruction;
    }

    public String opcode() {
        return "assign";
    }

    public List<String> args() {
        return Arrays.asList(this.left, this.right);
    }


}
