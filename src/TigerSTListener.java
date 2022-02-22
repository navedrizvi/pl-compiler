import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.ArrayList;
import java.util.List;

public class TigerSTListener extends TigerBaseListener {

    private int level = -1; // Represents the lexical level where (current) symbol is declared
    int scopeNumber = 0;
    private SymbolTable st;
    private SymbolTable currentST;
    private Symbol.Scope currentScope;
    private List<SymbolTable> stAsList;
    private List<SemanticError> errors;

    public  TigerSTListener() {
        this.stAsList = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public SymbolTable getST() { return st; }

    public List<SemanticError> getErrors() { return errors; }

    public List<SymbolTable> getSTAsList() { return stAsList; }

    // Initializes a new symbol table for a scope
    private void initializeScope() {
        level++;
        st = new SymbolTable(level, currentScope, scopeNumber);
        // Add standard library functions to the global scope
        if (scopeNumber == 0)
            addStdLibFunctionsToScope(st);
        stAsList.add(st);
        scopeNumber++;
        if (level > 0)
            st.setParent(currentST);
        currentST = st;
    }

    // Finalizes the symbol table for a scope
    private void finalizeScope() {
        level--;
        if (level > -1)
            currentST = currentST.getParent();
    }

    private void addStdLibFunctionsToScope(SymbolTable st) {
        SubroutineSymbol.CustomArrayList args = new SubroutineSymbol.CustomArrayList();

        // printi
        args.insert("i", "int");
        st.insert("printi", new SubroutineSymbol("printi", Symbol.Scope.GLOBAL, args, null));

        // printf
        args = new SubroutineSymbol.CustomArrayList();
        args.insert("f", "float");
        st.insert("printf", new SubroutineSymbol("printf", Symbol.Scope.GLOBAL, args, null));

        // not
        args = new SubroutineSymbol.CustomArrayList();
        args.insert("i", "int");
        st.insert("not", new SubroutineSymbol("not", Symbol.Scope.GLOBAL, args, "int"));

        // exit
        args = new SubroutineSymbol.CustomArrayList();
        args.insert("i", "int");
        st.insert("exit", new SubroutineSymbol("exit", Symbol.Scope.GLOBAL, args, null));
    }

    @Override public void enterMain(TigerParser.MainContext ctx) {
        currentScope = Symbol.Scope.GLOBAL;
        initializeScope();
    }

    @Override public void exitMain(TigerParser.MainContext ctx) {
        finalizeScope();
        currentScope = currentST.getScope();
    }

    @Override public void enterType_decl(TigerParser.Type_declContext ctx) {
        String name = ctx.ID().getText();
        Symbol lookUp = currentST.lookUpCurrentScope(name);
        if (lookUp != null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "'" + name + "' is already defined in the scope"
                    )
            );
        }
        TigerParser.TypeContext typeContext = ctx.type();
        String type;
        Symbol symbol;
        if (typeContext instanceof TigerParser.TypeBaseTypeContext) {
            // TypeBaseType
            type = typeContext.getText();
            symbol = new DefinedTypeSymbol(name, ctx.TYPE().getText(), currentScope, type);
        }
        else if (typeContext instanceof TigerParser.TypeArrayContext) {
            // TypeArray
            type = ((TigerParser.TypeArrayContext) typeContext).base_type().getText();
            int dimension = Integer.parseInt(((TigerParser.TypeArrayContext) typeContext).INTLIT().getText());
            symbol = new DefinedTypeArraySymbol(name, ctx.TYPE().getText(), currentScope, type, dimension);
        }
        else {
            // TypeID
            type = typeContext.getText();
            symbol = new DefinedTypeSymbol(name, ctx.TYPE().getText(), currentScope, type);
        }
//        System.out.println(symbol);
        currentST.insert(name, symbol);
    }

    @Override public void enterVar_decl(TigerParser.Var_declContext ctx) {
        String storageClass = ctx.storage_class().getText();
        VariableSymbol.StorageClass storageClassForSymbol;
        if (storageClass.equals("static"))
            storageClassForSymbol = VariableSymbol.StorageClass.STATIC;
        else
            storageClassForSymbol = VariableSymbol.StorageClass.VAR;

        if (currentScope == Symbol.Scope.GLOBAL && storageClassForSymbol == VariableSymbol.StorageClass.VAR) {
            errors.add(
                new SemanticError(
                    ctx.storage_class().getStart().getLine(),
                    ctx.storage_class().getStart().getCharPositionInLine(),
                    "Variable(s) in scope must be declared as static"
                )
            );
        }

        if (currentScope == Symbol.Scope.LET && storageClassForSymbol == VariableSymbol.StorageClass.STATIC) {
            errors.add(
                new SemanticError(
                    ctx.storage_class().getStart().getLine(),
                    ctx.storage_class().getStart().getCharPositionInLine(),
                    "Variable(s) in scope must be declared as var"
                )
            );
        }

        if (ctx.type() instanceof TigerParser.TypeArrayContext) {
            errors.add(
                    new SemanticError(
                            ctx.type().getStart().getLine(),
                            ctx.type().getStart().getCharPositionInLine(),
                            "Array defined without a type"
                    )
            );
        }

        // Undefined type
        if (ctx.type() instanceof TigerParser.TypeIDContext && currentST.lookUp(((TigerParser.TypeIDContext) ctx.type()).ID().getText()) == null) {
            errors.add(
                    new SemanticError(
                            ctx.type().getStart().getLine(),
                            ctx.type().getStart().getCharPositionInLine(),
                            "Cannot resolve symbol '" + ((TigerParser.TypeIDContext) ctx.type()).ID().getText() + "'"
                    )
            );
        }

        if (ctx.id_list() instanceof TigerParser.IdListIdContext) {
            //System.out.println(((TigerParser.IdListIdContext) ctx.id_list()).ID());
            String name = ((TigerParser.IdListIdContext) ctx.id_list()).ID().getText();
            Symbol lookUp = currentST.lookUpCurrentScope(name);
            if (lookUp != null) {
                // collect error during ST step
//                System.out.println(ctx.);
                errors.add(
                    new SemanticError(
                        ctx.id_list().getStart().getLine(),
                        ctx.id_list().getStart().getCharPositionInLine(),
                        "Variable '" + name + "' is already defined in the scope"
                    )
                );
            }
            currentST.insert(name, new VariableSymbol(name, ctx.type().getText(), currentScope, storageClassForSymbol));
        }
        else {
            TigerParser.IdListContext temp = (TigerParser.IdListContext) ctx.id_list();
            String name;
            Symbol lookUp;
            while (true) {
               // System.out.println(temp.ID());
                name = temp.ID().getText();
                lookUp = currentST.lookUpCurrentScope(name);
                if (lookUp != null) {
                    // collect error during ST step
                    errors.add(
                            new SemanticError(
                            ctx.id_list().getStart().getLine(),
                            ctx.id_list().getStart().getCharPositionInLine(),
                            "Variable '" + name + "' is already defined in the scope"
                        )
                    );
                }
                currentST.insert(name, new VariableSymbol(name, ctx.type().getText(), currentScope, storageClassForSymbol));
                if (temp.id_list() instanceof TigerParser.IdListIdContext) {
                    //System.out.println(((TigerParser.IdListIdContext) temp.id_list()).ID());
                    name = ((TigerParser.IdListIdContext) temp.id_list()).ID().getText();
                    lookUp = currentST.lookUpCurrentScope(name);
                    if (lookUp != null) {
                        // collect error during ST step
                        errors.add(
                            new SemanticError(
                                    ctx.id_list().getStart().getLine(),
                                    ctx.id_list().getStart().getCharPositionInLine(),
                                    "Variable '" + name + "' is already defined in the scope"
                            )
                        );
                    }
                    currentST.insert(name, new VariableSymbol(name, ctx.type().getText(), currentScope, storageClassForSymbol));
                    break;
                }
                temp = (TigerParser.IdListContext) temp.id_list();
            }
        }
    }

    @Override public void enterFunct(TigerParser.FunctContext ctx) {
        // assumes currentScope == Symbol.Scope.GLOBAL, the parser will throw error on any other scope
        String name = ctx.ID().getText();
        Symbol lookUp = currentST.lookUpCurrentScope(name);
        if (lookUp != null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "'" + name + "' is already defined in the scope"
                    )
            );
            return;
        }

        // returnType is null for procedures
        String returnType = null;
        try {
            returnType = ctx.return_type().type().getText();
        }
        catch (NullPointerException e) {
        }

        TigerParser.Param_listContext temp = (TigerParser.Param_listContext) ctx.param_list();
        SubroutineSymbol.CustomArrayList args = new SubroutineSymbol.CustomArrayList();
        if (temp.param() != null) { // handle empty param_list
            args.insert(temp.param().ID().getText(), temp.param().type().getText());
            TigerParser.Param_list_tailContext temp2 = (TigerParser.Param_list_tailContext) ctx.param_list().param_list_tail();
            if (temp2.param() != null) {
                while (true) {
                    args.insert(temp2.param().ID().getText(), temp2.param().type().getText());
                    temp2 = temp2.param_list_tail();
                    if (temp2.param() == null) {
                        break;
                    }
                }
            }
        }
        currentST.insert(name, new SubroutineSymbol(name, currentScope, args, returnType));
        currentScope = Symbol.Scope.SUBROUTINE;
        initializeScope();

        for (SubroutineSymbol.Tuple arg: args) {
            currentST.insert(arg.name, new VariableSymbol(arg.name, arg.type, currentScope, VariableSymbol.StorageClass.VAR));
        }
    }

    @Override public void exitFunct(TigerParser.FunctContext ctx) {
        finalizeScope();
        currentScope = currentST.getScope();
    }

    @Override public void enterStatLet(TigerParser.StatLetContext ctx) {
        currentScope = Symbol.Scope.LET;
        initializeScope();
    }

    @Override public void exitStatLet(TigerParser.StatLetContext ctx) {
        finalizeScope();
        currentScope = currentST.getScope();
    }
}
