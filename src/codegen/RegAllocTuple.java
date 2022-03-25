package codegen;

import java.util.HashMap;

import codegen.ir_instructions.IRInstruction;

public class RegAllocTuple {
    public String variable;

    public String getVariable() {
        return variable;
    }

    public String getRegister() {
        return register;
    }

    public String getMemoryOffset() {
        return memoryOffset;
    }

    public String register;
    public String memoryOffset;

    public RegAllocTuple(String variable, String register, String memoryOffset) {
        this.variable = variable;
        this.register = register;
        this.memoryOffset = memoryOffset;
    }
}
