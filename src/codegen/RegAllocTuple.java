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

    public Integer getMemoryOffset() {
        return memoryOffset;
    }

    public String register;
    public Integer memoryOffset;

    public RegAllocTuple(String variable, String register, Integer memoryOffset) {
        this.variable = variable;
        this.register = register;
        this.memoryOffset = memoryOffset;
    }
}
