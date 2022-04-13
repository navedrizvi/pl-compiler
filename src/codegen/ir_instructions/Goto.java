package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Goto implements IRInstruction {
    private String instruction;

    public String getInstruction() {
        return instruction;
    }
    public String getLabel() {
        return label;
    }

    private String label;
    public Goto(String instruction, String[] args) {
        this.label = args[0];
        this.instruction = instruction;
    }

    public String opcode() {
        return "goto";
    }

    public List<String> args() {
        return Arrays.asList(this.label);
    }
}
