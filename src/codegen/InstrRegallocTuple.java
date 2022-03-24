package codegen;

import java.util.HashMap;

import codegen.ir_instructions.IRInstruction;

public class InstrRegallocTuple {
    public IRInstruction irInstruction;
    public HashMap<String, String> varToRegister;

    public InstrRegallocTuple(IRInstruction irInstruction, HashMap<String, String> varToRegister) {
        this.irInstruction = irInstruction;
        this.varToRegister = varToRegister;
    }
}
