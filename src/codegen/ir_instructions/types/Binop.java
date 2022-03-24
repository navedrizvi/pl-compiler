package codegen.ir_instructions.types;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Binop {
    protected String left;
    protected String right;
    protected String temp;

    public Binop(String[] args) {
        this.left = args[0];
        this.right = args[1];
        this.temp = args[2];
    }

    public List<String> args() {
        return Arrays.asList(this.left, this.right, this.temp);
    }

    public Set<String> useSet() {
        HashSet<String> uses = new HashSet<>();
        // TODO fill
        return uses;
    }

    public Set<String> defSet() {
        return new HashSet<>(Arrays.asList(this.temp));
    }
}
