package codegen.mips_instructions;

import java.util.List;

public interface MipsInstruction {
    public List<String> args();
    default String opcode() {
        return this.getClass().getSimpleName();
    }
    default String asString() {
        return this.opcode() + " " + String.join(", ", this.args());
    } 
}
