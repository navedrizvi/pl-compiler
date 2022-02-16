
public class SubroutineSymbol extends Symbol {

    private String returnType;

    public SubroutineSymbol(String name, String type, Scope scope, String returnType) {
        super(name, type, scope);
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }
}