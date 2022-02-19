package symbol;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubroutineSymbol extends Symbol {

    private String returnType; // is null for procedures
    private Map<String, String> args = new LinkedHashMap<>();
    private static String type = "func";

    // @args maps arg name to arg type
    public SubroutineSymbol(String name, Scope scope, Map<String, String> args, String returnType) {
        super(name, type, scope);
        this.args = args;
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public String toFormattedString() {
        return super.getName() + ", " + super.getType() + ", " + returnType + ". arguments: " + this.args.toString();
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + args + " " + returnType + ">";
    }
}
