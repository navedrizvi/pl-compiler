package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Goto implements IRInstruction {
    private String label;
    public Goto(String[] args) {
        this.label = args[0];
    }

    public String opcode() {
        return "goto";
    }

    public List<String> args() {
        return Arrays.asList(this.label);
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
