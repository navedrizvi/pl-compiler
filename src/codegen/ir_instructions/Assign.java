package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> useSet() {
        // TODO0 fill useSet
        return new HashSet<>();
    }

    @Override
    public Set<String> defSet() {
        return new HashSet<>(Arrays.asList(this.left));
    }    
}
