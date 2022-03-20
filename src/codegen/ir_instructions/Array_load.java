package codegen.ir_instructions;

import java.util.Arrays;
import java.util.List;

public class Array_load implements IRInstruction {
    private String store_var;
    private String array_name;
    private String idx;

    public Array_load(String[] args) {
        this.store_var = args[0];
        this.array_name = args[1];
        this.idx = args[2];
    }

    public List<String> args() {
        return Arrays.asList(this.store_var, this.array_name, this.idx);
    }

    public String opcode() {
        return "array_load";
    } 
}
