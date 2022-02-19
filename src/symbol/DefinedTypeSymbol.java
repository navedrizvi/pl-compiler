package symbol;
public class DefinedTypeSymbol extends Symbol {

    private String baseType;
    private String type;

    public String getType() {
        return type;
    }

    public DefinedTypeSymbol(String name, String type, Scope scope, String baseType) {
        super(name, scope);
        this.baseType = baseType;
        this.type = type;
    }

    public String getBaseType() {
        return baseType;
    }

    public String toFormattedString() {
        return super.getName() + ", " + getType() + ", " + baseType;
    }

    public String toString() {
        return "<" + super.getName() + " " + getType() + " " + super.getScope() + " " + baseType + ">";
    }
}
