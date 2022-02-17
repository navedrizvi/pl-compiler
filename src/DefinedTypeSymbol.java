
public class DefinedTypeSymbol extends Symbol {

    private String builtInType;

    public DefinedTypeSymbol(String name, String type, Scope scope, String builtInType) {
        super(name, type, scope);
        this.builtInType = builtInType;
    }

    public String getBuiltInType() {
        return builtInType;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + builtInType + ">";
    }
}
