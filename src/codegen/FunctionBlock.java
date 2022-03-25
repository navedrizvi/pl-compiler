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
    private String[] intList;
    private String[] floatList;
    private IRInstruction[] instructions;

    private static final int WORD_SIZE = 4;

    public FunctionBlock(String functionName, String returnType, LinkedHashMap<String, String> functionArgs, String[] intList, String[] floatList, IRInstruction[] instructions) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.functionArgs = functionArgs;
        this.intList = intList;
        this.floatList = floatList;
        this.instructions = instructions;
    }

    public List<MipsInstruction> getNaiveMips() {
//        List<InstrRegallocTuple> naiveInstrs = this.doNaiveRegisterAllocation();
        HashMap<String, RegAllocTuple> naiveRegisterAllocation = this.doNaiveRegisterAllocation();
        MipsCodeGenerator naiveMips = new MipsCodeGenerator(instructions, this.functionName, this.intList, this.floatList, naiveRegisterAllocation);
        List<MipsInstruction> out = naiveMips.generateMipsInstructions();
        return out;
    }

    private HashMap<String, RegAllocTuple> doNaiveRegisterAllocation() {
        HashMap<String, RegAllocTuple> varToMemoryOffSet = new HashMap<>();
        // Handling ints first
        int index = 0;
        for (String intVar: intList) {
            varToMemoryOffSet.put(intVar, new RegAllocTuple(intVar, null, index * 4));
            index++;
        }
        return varToMemoryOffSet;
    }

//    private List<InstrRegallocTuple> doNaiveRegisterAllocation() {
//        ArrayList<InstrRegallocTuple> instrs = new ArrayList<>();
//        for (IRInstruction instr : this.instructions) {
//            ArrayList<IRInstruction> storeInstrs = new ArrayList<>();
//            HashMap<String, String> usedRegisters = new HashMap<>();
//            int regIdx = 0;
//            for (String e : instr.useSet()) {
//                String[] loadArgs = new String[]{MipsCodeGenerator.saveRegisters.get(regIdx), e};
//                instrs.add(new InstrRegallocTuple(new Load(loadArgs), null));
//                usedRegisters.put(e, MipsCodeGenerator.saveRegisters.get(regIdx));
//                regIdx++;
//            }
//            for (String e : instr.defSet()) {
//                String[] storeArgs = new String[]{e, MipsCodeGenerator.saveRegisters.get(regIdx)};
//                storeInstrs.add(new Store(storeArgs));
//                usedRegisters.put(e, MipsCodeGenerator.saveRegisters.get(regIdx));
//                regIdx++;
//            }
//            instrs.add(new InstrRegallocTuple(instr.allocateRegisters(usedRegisters), usedRegisters));
//            for (IRInstruction storeInstr : storeInstrs) {
//                instrs.add(new InstrRegallocTuple(storeInstr, null));
//            }
//        }
//        return instrs;
//    }
}
