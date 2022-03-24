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
        MipsCodeGenerator naiveMips = new MipsCodeGenerator(this, this.functionName, this.intList, this.floatList, naiveInstrs);
        List<MipsInstruction> out = naiveMips.generateMipsInstructions();
        return out;
    }

    private List<InstrRegallocTuple> doNaiveRegisterAllocation() {
        ArrayList<InstrRegallocTuple> instrs = new ArrayList<>();
        for (IRInstruction instr : this.instructions) {
            ArrayList<IRInstruction> storeInstrs = new ArrayList<>();
            HashMap<String, String> usedRegisters = new HashMap<>();
            int regIdx = 0;
            for (String e : instr.useSet()) {
                String[] loadArgs = new String[]{MipsCodeGenerator.saveRegisters.get(regIdx), e};
                instrs.add(new InstrRegallocTuple(new Load(loadArgs), null));
                usedRegisters.put(e, MipsCodeGenerator.saveRegisters.get(regIdx));
                regIdx++;
            }
            for (String e : instr.defSet()) {
                String[] storeArgs = new String[]{e, MipsCodeGenerator.saveRegisters.get(regIdx)};
                storeInstrs.add(new Store(storeArgs));
                usedRegisters.put(e, MipsCodeGenerator.saveRegisters.get(regIdx));
                regIdx++;
            }
            instrs.add(new InstrRegallocTuple(instr.allocateRegisters(usedRegisters), usedRegisters));
            for (IRInstruction storeInstr : storeInstrs) {
                instrs.add(new InstrRegallocTuple(storeInstr, null));
            }
        }
        return instrs;
    }
}
