package codegen.ir_instructions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Label implements IRInstruction {
    private String name;
    public Label(String[] args) {
        this.name = args[0];
    }

    public String opcode() {
        return "label";
    } 

    public List<String> params() {
        return Arrays.asList(this.name);
    }

    @Override
    public List<String> args() {
        return Arrays.asList(this.name);
    }

}
