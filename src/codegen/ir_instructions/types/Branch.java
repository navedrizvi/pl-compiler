package codegen.ir_instructions.types;

import java.util.Arrays;
import java.util.List;

abstract public class Branch {
    protected String left;
    protected String right;
    protected String label;

    public Branch(String[] args) {
        this.left = args[0];
        this.right = args[1];
        this.label = args[2];
    }

    public List<String> args() {
        return Arrays.asList(this.left, this.right, this.label);
    } 
}
