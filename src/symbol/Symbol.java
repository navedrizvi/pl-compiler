package symbol;

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

    // Might define an enum for type later. There is confusion around
    // defined types
    //    enum Type {
    //        INT,
    //        FLOAT
    //    }

    private String name;
    private Scope scope;

    public Symbol(String name, Scope scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public Scope getScope() {
        return scope;
    }

    public String toFormattedString() {
        return name;
    }

    public String toString() {
        return "<" + name + " " + scope + ">";
    }
}
