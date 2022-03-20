package codegen.ir_instructions;

import java.util.Arrays;
import java.util.List;

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
}
