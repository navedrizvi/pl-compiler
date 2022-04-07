package codegen;

import java.util.*;

import codegen.ir_instructions.IRInstruction;
import codegen.ir_instructions.Load;
import codegen.ir_instructions.Store;
import codegen.mips_instructions.MipsInstruction;
import common.SymbolTable;

public class FunctionBlock {
    private String functionName;
    private String returnType;
    // todo can use tuple instead
    private List<String> functionArgs;
    private List<String> staticIntList;
    private List<String> staticFloatList;
    private String[] intList;
    private String[] floatList;
    private IRInstruction[] instructions;
    private int maxArgs;
    private List<String> varIntFloatList;
    private SymbolTable symbolTable;

    private Map<String, List<String>> globalFunctionToArgs;

    public FunctionBlock(
            String functionName, String returnType, List<String> functionArgs, List<String> staticIntList,
            List<String> staticFloatList, String[] intList, String[] floatList, IRInstruction[] instructions,
            int maxArgs, List<String> varIntFloatList, SymbolTable symbolTable
    ) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.functionArgs = functionArgs;
        this.intList = intList;
        this.floatList = floatList;
        this.instructions = instructions;
        this.staticIntList = staticIntList;
        this.staticFloatList = staticFloatList;
        this.maxArgs = maxArgs;
        this.symbolTable = symbolTable;
        this.varIntFloatList = varIntFloatList;
    }

    public void setGlobalFunctionToArgs(Map<String, List<String>> functionToArgs) {
        this.globalFunctionToArgs = functionToArgs;
    }

    public Map<String, List<String>> getGlobalFunctionToArgs() {
        return globalFunctionToArgs;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<String> getFunctionArgs() {
        return functionArgs;
    }

    public List<String> getStaticIntList() {
        return staticIntList;
    }

    public List<String> getStaticFloatList() {
        return staticFloatList;
    }

    public String[] getIntList() {
        return intList;
    }

    public String[] getFloatList() {
        return floatList;
    }

    public int getMaxArgs() {
        return maxArgs;
    }

    public List<MipsInstruction> getNaiveMips() {
        HashMap<String, RegAllocTuple> naiveRegisterAllocation = this.doNaiveRegisterAllocation();
        MipsCodeGenerator naiveMips = new MipsCodeGenerator(instructions, this, naiveRegisterAllocation, symbolTable);
        List<MipsInstruction> out = naiveMips.generateMipsInstructions();
        return out;
    }

    // private static boolean elemInArray(String elem, String[] array) {
    //     return Arrays.stream(array).anyMatch(elem::equals);
    // }

    // private HashMap<String, RegAllocTuple> doNaiveRegisterAllocation2() {
    //     HashMap<String, RegAllocTuple> varToMemoryOffSet = new HashMap<>();
    //     // Handling ints first
    //     int offset = 0;
    //     // TODO 2 needed for proper float regalloc? 
    //     for (String var: varIntFloatList) {
    //         System.out.println("abye");
    //         System.out.println(var);
    //         // int array
    //         if (var.endsWith("]")) {
    //             int size = Integer.parseInt(var.substring(var.indexOf("[") + 1, var.indexOf("]")));
    //             String var2 = var.substring(0, var.indexOf("["));
    //             varToMemoryOffSet.put(var2, new RegAllocTuple(var2, null, Integer.toString(offset), size));
    //             offset += size * 4;
    //         }
    //         else {
    //             var = var.replace(",", "");
    //             var = var.trim();
    //             varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), null));
    //             offset += 4;
    //         }
    //     }
    //     return varToMemoryOffSet;
    // }
    // TODO10 keep looking at the hashmaps
    private HashMap<String, RegAllocTuple> doNaiveRegisterAllocation() {
        HashMap<String, RegAllocTuple> varToMemoryOffSet = new HashMap<>();
        // Handling ints first
        int offset = 0;
        for (String intVar: intList) {
            // int array
            if (intVar.endsWith("]")) {
                int size = Integer.parseInt(intVar.substring(intVar.indexOf("[") + 1, intVar.indexOf("]")));
                String var = intVar.substring(0, intVar.indexOf("["));
                varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), size));
                offset += size * 4;
            }
            else {
                intVar = intVar.replace(",", "");
                intVar = intVar.trim();
                varToMemoryOffSet.put(intVar, new RegAllocTuple(intVar, null, Integer.toString(offset), null));
                offset += 4;
            }
        }
        // TODO1 remove temp
        for (String intVar: floatList) {
            System.out.println("abye");
            System.out.println(intVar);
            // int array
            if (intVar.endsWith("]")) {
                int size = Integer.parseInt(intVar.substring(intVar.indexOf("[") + 1, intVar.indexOf("]")));
                String var = intVar.substring(0, intVar.indexOf("["));
                varToMemoryOffSet.put(var, new RegAllocTuple(var, null, Integer.toString(offset), size));
                offset += size * 4;
            }
            else {
                intVar = intVar.replace(",", "");
                intVar = intVar.trim();
                System.out.println("!!!!!!!!!!!!!!!!!1");
                System.out.println(intVar);
                System.out.println(offset);
                System.out.println("!!!!!!!!!!!!!!!!!1");
                varToMemoryOffSet.put(intVar, new RegAllocTuple(intVar, null, Integer.toString(offset), null));
                offset += 4;
            }
        }
        return varToMemoryOffSet;
    }
}
