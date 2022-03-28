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
    // todo can use tuple instead
    public LinkedHashMap<String, String> functionArgs;
    private List<String> staticIntList;
    private List<String> staticFloatList;
    private String[] intList;
    private String[] floatList;
    private IRInstruction[] instructions;

    private static final int WORD_SIZE = 4;

    public FunctionBlock(String functionName, String returnType, LinkedHashMap<String, String> functionArgs, List<String> staticIntList, List<String> staticFloatList, String[] intList, String[] floatList, IRInstruction[] instructions) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.functionArgs = functionArgs;
        this.intList = intList;
        this.floatList = floatList;
        this.instructions = instructions;
        this.staticIntList = staticIntList;
        this.staticFloatList = staticFloatList;
    }

    public List<MipsInstruction> getNaiveMips() {
        HashMap<String, RegAllocTuple> naiveRegisterAllocation = this.doNaiveRegisterAllocation();
        MipsCodeGenerator naiveMips = new MipsCodeGenerator(instructions, this.functionName, staticIntList, staticFloatList,this.intList, this.floatList, naiveRegisterAllocation);
        List<MipsInstruction> out = naiveMips.generateMipsInstructions();
        return out;
    }

    private HashMap<String, RegAllocTuple> doNaiveRegisterAllocation() {
        HashMap<String, RegAllocTuple> varToMemoryOffSet = new HashMap<>();
        // Handling ints first
        int index = 0;
        int offset = 0;
        for (String intVar: intList) {
            // int array
            if (intVar.endsWith("]")) {
                int size = Integer.parseInt(intVar.substring(intVar.indexOf("[") + 1, intVar.indexOf("]")));
                String var = intVar.substring(0, intVar.indexOf("["));
                System.out.println(var + "(array): " + offset);
                varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), size));
                offset += size * 4;
            }
            else {
                System.out.println(intVar + ": " + offset);
                varToMemoryOffSet.put(intVar, new RegAllocTuple(intVar, null, Integer.toString(offset), null));
                offset += 4;
            }
            index++;

        }
        return varToMemoryOffSet;
    }
}
