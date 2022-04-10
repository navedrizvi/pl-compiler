import common.Symbol;

public class DefinedTypeArraySymbol extends DefinedTypeSymbol {

    private int dimension;

    public DefinedTypeArraySymbol(String name, String type, Symbol.Scope scope, String builtInType, int dimension) {
        super(name, type, scope, builtInType);
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public String toFormattedString() {
        return super.getName() + ", " + super.getType() + ", " + "array" + "[" + dimension + "], " + super.getBaseType();
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + super.getBaseType() + "[" + dimension + "]" + ">";
    }
}
