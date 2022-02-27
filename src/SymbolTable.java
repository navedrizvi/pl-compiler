import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Symbol> ST;
    private SymbolTable parent;
    private int level;
    private Symbol.Scope scope;
    private int scopeNumber;

    public SymbolTable(int level, Symbol.Scope scope, int scopeNumber) {
        this.ST = new LinkedHashMap<>();
        this.parent = null;
        this.level = level;
        this.scope = scope;
        this.scopeNumber = scopeNumber;
    }

    public Map<String, Symbol> getST() {
        return ST;
    }

    public int getScopeNumber() {
        return scopeNumber;
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

    public Symbol lookUpCurrentScope(String name) {
        return ST.get(name);
    }

    public Symbol lookUp(String name) {
        Symbol symbol = ST.get(name);
        if (symbol != null)
            return symbol;

        SymbolTable parent = getParent();
        while (parent != null) {
            Map<String, Symbol> map = parent.getST();
            symbol = map.get(name);
            if (symbol != null)
                return symbol;
            parent = parent.getParent();
        }
        return null;
    }

    public int getScopeNumber(String name) {
        Symbol symbol = ST.get(name);
        if (symbol != null)
            return scopeNumber;

        SymbolTable parent = getParent();
        while (parent != null) {
            Map<String, Symbol> map = parent.getST();
            symbol = map.get(name);
            if (symbol != null)
                return parent.getScopeNumber();
            parent = parent.getParent();
        }
        return -1;
    }
}
