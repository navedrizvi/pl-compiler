package codegen.mips_instructions;

import java.util.List;

public interface MipsInstruction {
    public List<String> args();
    default String opcode() {
        return this.getClass().getSimpleName();
    }
    default String asString() {
        if (this.opcode().equals("label")) {
            return this.args().get(0) + ":";
        }

        if (this.args() != null) {
            return this.opcode() + " " + String.join(", ", this.args());
        }

        return this.opcode();
    }
}
