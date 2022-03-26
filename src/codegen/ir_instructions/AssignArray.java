package codegen.ir_instructions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AssignArray implements IRInstruction {
    private String arr_name;
    private int arr_size;
    private String arr_var;

    public AssignArray(String[] args) {
        this.arr_name = args[0];
        this.arr_size = Integer.parseInt(args[1]);
        this.arr_var = args[2];
    }

    public String opcode() {
        return "assign";
    }

    @Override
    public List<String> args() {
        return Arrays.asList(this.arr_name, Integer.toString(this.arr_size), this.arr_var);
    }
}