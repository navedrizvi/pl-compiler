import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import symbol.Symbol;
import symbol.SymbolTable;
import symbol.VariableSymbol;

import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.ArrayList;
import java.util.List;

public class TigerSTListener extends TigerBaseListener {

    private int level = -1;
    private SymbolTable st;
    private SymbolTable currentST;
    private Symbol.Scope currentScope;
    private List<SymbolTable> stAsList = new ArrayList<>();
    private List<SemanticError> errors = new ArrayList<>();

    public SymbolTable getST() { return st; }

    public List<SemanticError> getErrors() { return errors; }

    public List<SymbolTable> getSTAsList() { return stAsList; }

    private void initializeScope() {
        level++;
        st = new SymbolTable(level, currentScope);
        stAsList.add(st);
        if (level > 0)
            st.setParent(currentST);
        currentST = st;
    }

    private void finalizeScope() {
        level--;
        if (level > -1)
            currentST = st.getParent();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMain(TigerParser.MainContext ctx) {
        currentScope = Symbol.Scope.GLOBAL;
        initializeScope();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMain(TigerParser.MainContext ctx) {
        finalizeScope();
        currentScope = currentST.getScope();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecl_seg(TigerParser.Decl_segContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDecl_seg(TigerParser.Decl_segContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterType_decl_list(TigerParser.Type_decl_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitType_decl_list(TigerParser.Type_decl_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVar_decl_list(TigerParser.Var_decl_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar_decl_list(TigerParser.Var_decl_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunct_list(TigerParser.Funct_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunct_list(TigerParser.Funct_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterType_decl(TigerParser.Type_declContext ctx) {
        String name = ctx.ID().getText();
        Symbol lookUp = currentST.lookUp(name);
        if (lookUp != null) {
            System.out.println(ctx.getStart().getLine());
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Type '" + name + "' is already defined in the scope"
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
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitType_decl(TigerParser.Type_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTypeBaseType(TigerParser.TypeBaseTypeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTypeBaseType(TigerParser.TypeBaseTypeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTypeArray(TigerParser.TypeArrayContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTypeArray(TigerParser.TypeArrayContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTypeID(TigerParser.TypeIDContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTypeID(TigerParser.TypeIDContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBaseTypeInt(TigerParser.BaseTypeIntContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBaseTypeInt(TigerParser.BaseTypeIntContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
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

        if (ctx.id_list() instanceof TigerParser.IdListIdContext) {
            //System.out.println(((TigerParser.IdListIdContext) ctx.id_list()).ID());
            String name = ((TigerParser.IdListIdContext) ctx.id_list()).ID().getText();
            Symbol lookUp = currentST.lookUp(name);
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
                lookUp = currentST.lookUp(name);
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
                    lookUp = currentST.lookUp(name);
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
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar_decl(TigerParser.Var_declContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStorageClassVar(TigerParser.StorageClassVarContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStorageClassVar(TigerParser.StorageClassVarContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStorageClassStatic(TigerParser.StorageClassStaticContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStorageClassStatic(TigerParser.StorageClassStaticContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIdListId(TigerParser.IdListIdContext ctx) {
//        System.out.println(ctx.ID());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdListId(TigerParser.IdListIdContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIdList(TigerParser.IdListContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIdList(TigerParser.IdListContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOptional_init(TigerParser.Optional_initContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOptional_init(TigerParser.Optional_initContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunct(TigerParser.FunctContext ctx) {
        initializeScope();
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunct(TigerParser.FunctContext ctx) {
        finalizeScope();
        //TODO refactor calls
        System.out.println(getST().getST().toString());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_list(TigerParser.Param_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_list(TigerParser.Param_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_list_tail(TigerParser.Param_list_tailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_list_tail(TigerParser.Param_list_tailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReturn_type(TigerParser.Return_typeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReturn_type(TigerParser.Return_typeContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam(TigerParser.ParamContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam(TigerParser.ParamContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatSingle(TigerParser.StatSingleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatSingle(TigerParser.StatSingleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatSeq(TigerParser.StatSeqContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatSeq(TigerParser.StatSeqContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatAssign(TigerParser.StatAssignContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatAssign(TigerParser.StatAssignContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatIf(TigerParser.StatIfContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatIf(TigerParser.StatIfContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatIfElse(TigerParser.StatIfElseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatIfElse(TigerParser.StatIfElseContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatWhile(TigerParser.StatWhileContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatWhile(TigerParser.StatWhileContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatFor(TigerParser.StatForContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatFor(TigerParser.StatForContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatFunctionCall(TigerParser.StatFunctionCallContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatFunctionCall(TigerParser.StatFunctionCallContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatBreak(TigerParser.StatBreakContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatBreak(TigerParser.StatBreakContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatReturn(TigerParser.StatReturnContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatReturn(TigerParser.StatReturnContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatLet(TigerParser.StatLetContext ctx) {
        currentScope = Symbol.Scope.LET;
        initializeScope();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatLet(TigerParser.StatLetContext ctx) {
        finalizeScope();
        currentScope = currentST.getScope();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOpt_return(TigerParser.Opt_returnContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOpt_return(TigerParser.Opt_returnContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterOpt_prefix(TigerParser.Opt_prefixContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitOpt_prefix(TigerParser.Opt_prefixContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprAddSub(TigerParser.ExprAddSubContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprAddSub(TigerParser.ExprAddSubContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprAnd(TigerParser.ExprAndContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprAnd(TigerParser.ExprAndContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprPow(TigerParser.ExprPowContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprPow(TigerParser.ExprPowContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExporOr(TigerParser.ExporOrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExporOr(TigerParser.ExporOrContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprParen(TigerParser.ExprParenContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprParen(TigerParser.ExprParenContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprValue(TigerParser.ExprValueContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprValue(TigerParser.ExprValueContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprComp(TigerParser.ExprCompContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprComp(TigerParser.ExprCompContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprMultDiv(TigerParser.ExprMultDivContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprMultDiv(TigerParser.ExprMultDivContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprConstant(TigerParser.ExprConstantContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprConstant(TigerParser.ExprConstantContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterConstantIntLit(TigerParser.ConstantIntLitContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitConstantIntLit(TigerParser.ConstantIntLitContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_list(TigerParser.Expr_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list(TigerParser.Expr_listContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_list_tail(TigerParser.Expr_list_tailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list_tail(TigerParser.Expr_list_tailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterValue(TigerParser.ValueContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitValue(TigerParser.ValueContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterValue_tail(TigerParser.Value_tailContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitValue_tail(TigerParser.Value_tailContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}
