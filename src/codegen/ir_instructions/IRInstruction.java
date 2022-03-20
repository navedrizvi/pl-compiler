package codegen.ir_instructions;
import java.util.List;

public interface IRInstruction {
    public String opcode();
    public List<String> args();

    // TODO figure out other properties (registers, temp variables)
    // public Set<String> use();
    // public Set<String> def();

    default String debug() {
        return this.opcode() + ": " + String.join(", ", this.args());
    }
}
