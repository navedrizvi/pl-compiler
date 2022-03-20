package codegen.ir_instructions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Call implements IRInstruction {
    private String function_name;
    private String[] function_args;

    public Call(String[] args) {
        this.function_name = args[0];
        this.function_args = Arrays.copyOfRange(args, 1, args.length);
    }

    public String opcode() {
        return "call";
    }

    @Override
    public List<String> args() {
        ArrayList<String> params = new ArrayList<>();
        params.add(this.function_name);
        for (String arg : this.function_args) {
            params.add(arg);
        }
        return params;
    } 
}
