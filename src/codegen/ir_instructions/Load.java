package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Load implements IRInstruction {
    private String target;
    private String source;

    public Load(String[] args) {
        // "load, r1, x"
        this.source = args[1];
        this.target = args[0];
    }

    public String opcode() {
        return "load";
    }

    public List<String> args() {
        return Arrays.asList(this.target, this.source);
    }
}
