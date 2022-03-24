package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Store implements IRInstruction {
    private String target;
    private String source;

    public Store(String[] args) {
        this.source = args[0];
        this.target = args[1];
    }

    public String opcode() {
        return "store";
    }

    public List<String> args() {
        return Arrays.asList(this.target, this.source);
    }

    @Override
    public Set<String> useSet() {
        return new HashSet<String>();
    }

    @Override
    public Set<String> defSet() {
        return new HashSet<String>();
    }    
}
