package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array_store implements IRInstruction {
    private String array_name;
    private String idx;
    private String load_var;

    public Array_store(String[] args) {
        this.array_name = args[0];
        this.idx = args[1];
        this.load_var = args[2];
    }

    public String opcode() {
        return "array_store";
    }

    public List<String> args() {
        return Arrays.asList(this.array_name, this.idx, this.load_var);
    }

    @Override
    public Set<String> useSet() {
        // TODO fill
        return new HashSet<>();
    }

    @Override
    public Set<String> defSet() {
        // TODO Auto-generated method stub
        return new HashSet<>();
    } 
}
