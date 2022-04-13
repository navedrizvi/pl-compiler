package codegen.ir_instructions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnVoid implements IRInstruction {
    private String instruction;

    public String getInstruction() {
        return instruction;
    }
    public ReturnVoid(String instruction) {
        this.instruction = instruction;
    }

    public String opcode() {
        return "return";
    }

    public List<String> args() {
        return new ArrayList<>();
    }
}
