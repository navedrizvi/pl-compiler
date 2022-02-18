
public abstract class Symbol {

    /* Symbols to include:
        - variables
        - defined types
        - defined types for array
        - subroutine
        - there might be others

     */

    enum Scope {
        GLOBAL,
        SUBROUTINE,
        LET
    }

    // Might define an enum for type later. There is confusion around
    // defined types
    //    enum Type {
    //        INT,
    //        FLOAT
    //    }

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
