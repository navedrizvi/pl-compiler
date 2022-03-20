package codegen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import codegen.ir_instructions.IRInstruction;
import codegen.mips_instructions.MipsInstruction;

public class FunctionBlock {
    private String function_name;
    private String return_type;
    private LinkedHashMap<String, String> function_args;
    private String[] int_list;
    private String[] float_list;
    private IRInstruction[] instructions;

    public FunctionBlock(String function_name, String return_type, LinkedHashMap<String, String> function_args, String[] int_list, String[] float_list, IRInstruction[] instructions) {
        this.function_name = function_name;
        this.return_type = return_type;
        this.function_args = function_args;
        this.int_list = int_list;
        this.float_list = float_list;
        this.instructions = instructions;
    }

    public List<MipsInstruction> getNaiveMips() {
        // TODO do naive allocation here
        List<MipsInstruction> out = new ArrayList<>(); 

        return out;
    }
    
}
