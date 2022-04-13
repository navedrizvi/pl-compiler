package codegen.ir_instructions;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IRInstruction {
    // todo use reflection to get classname as opcode, less bloat
    String opcode();

    List<String> args();

    String getInstruction();

    default String asString() {
        return this.opcode() + ": " + String.join(", ", this.args());
    }

}
