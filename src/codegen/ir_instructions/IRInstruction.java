package codegen.ir_instructions;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IRInstruction {
    // todo use reflection to get classname as opcode, less bloat
    public String opcode();

    public List<String> args();

    // TODO1 fill use and def sets
//    public Set<String> useSet();
//    public Set<String> defSet();

    default String asString() {
        return this.opcode() + ": " + String.join(", ", this.args());
    }

    default IRInstruction allocateRegisters(HashMap<String, String> varToRegister) {
        for (int i = 0; i < this.args().size(); i++) {
            String param = this.args().get(i);
            if (varToRegister.containsKey(param)) {
                this.args().set(i, varToRegister.get(param));
            }
        }
        String[] args = this.args().toArray(new String[this.args().size()]);
        return new Array_load(args);
    }
}