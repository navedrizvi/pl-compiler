import java.util.ArrayList;
import java.util.List;

public class BasicBlock {

    private List<String> instructions;
    private List<Integer> instructionIndexes;
    private int index;
    private String funcName;

    public BasicBlock(List<String> instructions, List<Integer> instructionIndexes, int index, String funcName) {
        this.instructions = instructions;
        this.instructionIndexes = instructionIndexes;
        this.index = index;
        this.funcName = funcName;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public List<Integer> getInstructionIndexes() {
        return instructionIndexes;
    }

    public String getLeader() {
        return instructions.get(0);
    }

    public String getLastInstruction() {
        return instructions.get(instructions.size() - 1);
    }

    public String toNodeLabel() {
        StringBuilder buf = new StringBuilder();
        buf.append(toString() + "\\n");
        for (String instruction : instructions) {
            buf.append(instruction + "\\n");
        }
        return toString() +  " [label = \"" + buf.toString() + "\"]";
    }

    public String toString() {
        return funcName + "_B" + index;
    }
}
