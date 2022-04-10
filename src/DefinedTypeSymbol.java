import common.Symbol;

public class DefinedTypeSymbol extends Symbol {

    private String baseType;

    public DefinedTypeSymbol(String name, String type, Scope scope, String baseType) {
        super(name, type, scope);
        this.baseType = baseType;
    }

    public String getBaseType() {
        return baseType;
    }

    public String toFormattedString() {
        return super.getName() + ", " + super.getType() + ", " + baseType;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + baseType + ">";
    }
}
