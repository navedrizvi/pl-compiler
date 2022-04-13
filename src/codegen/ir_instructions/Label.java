package codegen.ir_instructions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Label implements IRInstruction {
    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    private String name;
    public String getName() {
        return name;
    }
    public Label(String instruction, String[] args) {
        this.name = args[0];
        this.instruction = instruction;
    }

    public String opcode() {
        return "label";
    } 

    @Override
    public List<String> args() {
        return Arrays.asList(this.name);
    }

}
