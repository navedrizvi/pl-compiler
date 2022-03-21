package codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import codegen.ir_instructions.IRInstruction;
import codegen.ir_instructions.Load;
import codegen.ir_instructions.Store;
import codegen.mips_instructions.MipsInstruction;

public class FunctionBlock {
    private String functionName;
    private String returnType;
    private LinkedHashMap<String, String> functionArgs;
    private String[] intList;
    private String[] floatList;
    private IRInstruction[] instructions;

    public FunctionBlock(String functionName, String returnType, LinkedHashMap<String, String> functionArgs, String[] intList, String[] floatList, IRInstruction[] instructions) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.functionArgs = functionArgs;
        this.intList = intList;
        this.floatList = floatList;
        this.instructions = instructions;
    }

    public List<MipsInstruction> getNaiveMips() {
        List<InstrRegallocTuple> naiveInstrs = this.doNaiveRegisterAllocation();
        MIPSCodeGenerator naiveMips = new MIPSCodeGenerator(this.functionName, this.intList, this.floatList, this, naiveInstrs);
        List<MipsInstruction> out = naiveMips.generateMipsInstructions();
        return out;
    }

    private List<InstrRegallocTuple> doNaiveRegisterAllocation() {
        // TODO make sure these are ok to use
    }
}
