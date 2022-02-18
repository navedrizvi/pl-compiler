import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Symbol> ST;
    private SymbolTable parent;
    private int level;
    private Symbol.Scope scope;

    public SymbolTable(int level, Symbol.Scope scope) {
        this.ST = new LinkedHashMap<>();
        this.parent = null;
        this.level = level;
        this.scope = scope;
    }

    public Map<String, Symbol> getST() {
        return ST;
    }

    public void setST(Map<String, Symbol> ST) {
        this.ST = ST;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }

    public int getLevel() {
        return level;
    }

    public Symbol.Scope getScope() {
        return scope;
    }

    public void insert(String name, Symbol symbol) {
        ST.put(name, symbol);
    }

    public Symbol lookUp(String name) {
        // Update to include looking up during semantic checking
        return ST.get(name);
    }

//    public void setLevel(int level) {
//        this.level = level;
//    }

}
