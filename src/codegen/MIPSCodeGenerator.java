package codegen;

import java.util.ArrayList;
import java.util.List;

import codegen.mips_instructions.MipsInstruction;

public class MIPSCodeGenerator {
    private int stackPointer = 0;
    private int framePointer = 0;
    private int stackSize = 0;
    String[] intList;
    String[] floatList;
    List<String> mipsOutput = new ArrayList<>();

    public MIPSCodeGenerator(String functionName, String[] intList, String[] floatList, FunctionBlock functionBlock, List<InstrRegallocTuple> instructions) {
        this.intList = intList;
        this.floatList = floatList;
        this.stackPointer = 0;
        this.framePointer = 0;
        this.stackSize = 0;
        // this.function_name = function_name;
        // this.text = new ArrayList<>();
        // this.ints = new HashSet<String>();
        // this.floats = new HashSet<String>();
        // this.arrays = new HashMap<String, String>();
        // this.variable_locations = this.variable_locations(func, instructions);
        // this.initialize_vars(ints, floats);
    } 

    public void emit(String instruction) {
        this.mipsOutput.add(instruction);
        // TODO update sp and fp
    }

    //TODO2 make this work, pattern match
    public List<MipsInstruction> generateMipsInstructions() {
        List<MipsInstruction> out = new ArrayList<>();
        // TODO
        return out;
    }
}
