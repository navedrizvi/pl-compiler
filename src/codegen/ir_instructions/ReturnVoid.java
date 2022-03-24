package codegen.ir_instructions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnVoid implements IRInstruction {
    public ReturnVoid() {
    }

    public String opcode() {
        return "return";
    }

    public List<String> args() {
        return new ArrayList<>();
    }

    @Override
    public Set<String> useSet() {
        return new HashSet<String>();
    }

    @Override
    public Set<String> defSet() {
        return new HashSet<String>();
    }    
}
