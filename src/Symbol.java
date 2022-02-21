public abstract class Symbol {

    /* Symbols to include:
        - variables
        - defined types
        - defined types for array
        - subroutine
        - there might be others

     */

    public enum Scope {
        GLOBAL,
        SUBROUTINE,
        LET
    }

    private String name;
    private String type;
    private Scope scope;

    public Symbol(String name, String type, Scope scope) {
        this.name = name;
        this.type = type;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Scope getScope() {
        return scope;
    }

    public String toFormattedString() {
        return name + ", " + type;
    }

    public String toString() {
        return "<" + name + " " + type + " " + scope + ">";
    }
}
