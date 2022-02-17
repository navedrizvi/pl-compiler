
public class DefinedTypeArraySymbol extends DefinedTypeSymbol {

    private int dimension;

    public DefinedTypeArraySymbol(String name, String type, Scope scope, String builtInType, int dimension) {
        super(name, type, scope, builtInType);
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + super.getBuiltInType() + "[" + dimension + "]" + ">";
    }
}
