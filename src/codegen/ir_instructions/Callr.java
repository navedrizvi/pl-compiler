package codegen.ir_instructions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Callr implements IRInstruction {
    private String store_var;
    private String function_name;
    private String[] function_args;

    public Callr(String[] args) {
        this.store_var = args[0];
        this.function_name = args[1];
        this.function_args = Arrays.copyOfRange(args, 2, args.length);
    }

    public String opcode() {
        return "callr";
    }

    @Override
    public List<String> args() {
        ArrayList<String> params = new ArrayList<>();
        params.add(this.store_var);
        params.add(this.function_name);
        for (String arg : this.function_args) {
            params.add(arg);
        }
        return params;
    } 
}
