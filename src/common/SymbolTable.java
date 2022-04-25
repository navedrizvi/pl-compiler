package common;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import common.Symbol.Scope;

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

    /* assumes lookup is from last st in the linked list */
    public Symbol lookUpMangledName(String mangledName) {
        if (mangledName.startsWith("_t")) {
            return this.lookUp(mangledName);
        }
        else if (mangledName.startsWith("_")) {
            String[] nameSplit = mangledName.split("_");
            int scope = Integer.parseInt(nameSplit[1]);
            String name = nameSplit[2];
        
            Symbol symbol = ST.get(name);
            if (symbol != null)
                return symbol;
    
            SymbolTable parent = getParent();
            while (parent != null && parent.getScopeNumber() != scope) {
                Map<String, Symbol> map = parent.getST();
                symbol = map.get(name);
                System.out.println("YEEE");
                System.out.println(symbol);
                System.out.println(name);
                System.out.println(map);
                if (symbol != null)
                    return symbol;
                parent = parent.getParent();
            }
            return null;
        }
        else {
            return null;
        }
    }

    public Symbol lookUpMangledNameUnsafe(String mangledName) {
        // bad b/c it will return the name in latest scope (disregards scope in @mangledName)
        if (!mangledName.startsWith("_")) {
            return this.lookUp(mangledName);
        }
        // else if (mangledName.startsWith("_")) {
            String[] nameSplit = mangledName.split("_");
            String name = nameSplit[2];
            return this.lookUp(name);
        // }
        // else {
        //     return null;
        // }
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
