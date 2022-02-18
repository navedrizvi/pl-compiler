import java.util.LinkedHashMap;
import java.util.Map;

public class SubroutineSymbol extends Symbol {

    private String returnType;
    private Map<String, String> args = new LinkedHashMap<>();

    public SubroutineSymbol(String name, String type, Scope scope, Map<String, String> args, String returnType) {
        super(name, type, scope);
        this.args = args;
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public String toFormattedString() {
        return super.getName() + ", " + super.getType() + ", " + returnType;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + args + " " + returnType + ">";
    }
}