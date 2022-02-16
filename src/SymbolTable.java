import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Symbol> ST;
    private SymbolTable parent;
    private int level;

    public SymbolTable(int level) {
        this.ST = new HashMap<>();
        this.parent = null;
        this.level = level;
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

//    public void setLevel(int level) {
//        this.level = level;
//    }

}