package codegen;

import java.util.HashMap;

import codegen.ir_instructions.IRInstruction;

public class RegAllocTuple {
    private String variable;

    public String getVariable() {
        return variable;
    }

    public String getRegister() {
        return register;
    }

    public String getMemoryOffset() {
        return memoryOffset;
    }

    public Integer getArraySize() {
        return arraySize;
    }

    private String register;
    private String memoryOffset;
    private Integer arraySize;

    public RegAllocTuple(String variable, String register, String memoryOffset, Integer arraySize) {
        this.variable = variable;
        this.register = register;
        this.memoryOffset = memoryOffset;
        this.arraySize = arraySize;
    }
}
