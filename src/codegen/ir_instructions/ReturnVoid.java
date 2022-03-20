package codegen.ir_instructions;

import java.util.ArrayList;
import java.util.List;

public class ReturnVoid implements IRInstruction {
    public ReturnVoid() {
    }

    public String opcode() {
        return "return";
    }

    public List<String> args() {
        return new ArrayList<>();
    }    
}
