package codegen.ir_instructions;

import java.util.Arrays;
import java.util.List;

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
}
