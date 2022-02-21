import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class TigerSemanticAnalysisListener extends TigerBaseListener {

    private List<SymbolTable> stAsList;
    private List<SemanticError> errors;
    // for, while, if, else
    private Map<String, Stack<ParserRuleContext>> controlFlowStack;
    private int scopeNumber = -1;
    enum ExprReturnValue {
        INT,
        FLOAT,
        ARRAY
    }
    ParseTreeProperty<ExprReturnValue> exprReturnValues = new ParseTreeProperty<>();

    public void setExprReturnValue(ParseTree node, ExprReturnValue value) { exprReturnValues.put(node, value); }

    public ExprReturnValue getExprReturnValue(ParseTree node) { return exprReturnValues.get(node); }

    public TigerSemanticAnalysisListener(List<SymbolTable> stAsList) {
        this.stAsList = stAsList;
        this.errors = new ArrayList<>();
        this.controlFlowStack = new LinkedHashMap<>();
        this.controlFlowStack.put("for", new Stack<>());
        this.controlFlowStack.put("while", new Stack<>());
        this.controlFlowStack.put("if", new Stack<>());
        this.controlFlowStack.put("else", new Stack<>());

    }

    public List<SemanticError> getErrors() { return errors; }

    private SymbolTable getCurrentST() { return stAsList.get(scopeNumber); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMain(TigerParser.MainContext ctx) {
        scopeNumber++;

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMain(TigerParser.MainContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecl_seg(TigerParser.Decl_segContext ctx) { }
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
    @Override public void enterType_decl(TigerParser.Type_declContext ctx) { }
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
        String name = ctx.ID().getText();
        Symbol lookUp = getCurrentST().lookUp(name);
        if (lookUp == null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot resolve symbol '" + name + "'"
                    )
            );
        }
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
    @Override public void enterVar_decl(TigerParser.Var_declContext ctx) { }
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
    @Override public void enterIdListId(TigerParser.IdListIdContext ctx) { }
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
    @Override public void enterIdList(TigerParser.IdListContext ctx) { }
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
        scopeNumber++;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunct(TigerParser.FunctContext ctx) { }
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
    @Override public void exitStatAssign(TigerParser.StatAssignContext ctx) {
        TigerParser.ValueContext value = ctx.value();
        TigerParser.ExprContext expr = ctx.expr();

        ExprReturnValue left = getExprReturnValue(value);
        ExprReturnValue right = getExprReturnValue(expr);

        if (left == ExprReturnValue.INT && right == ExprReturnValue.FLOAT) {
            errors.add(
                    new SemanticError(
                            ctx.ASSIGN().getSymbol().getLine(),
                            ctx.ASSIGN().getSymbol().getCharPositionInLine(),
                            "Narrowing conversion on assignment"
                    )
            );
            return;
        }

        // err_assign_array_type
        // err_assign_array_size
        if (left == ExprReturnValue.ARRAY && right == ExprReturnValue.ARRAY) {
            int lvalueArrayDimension = 0;
            String lvalueArrayBaseType = null;
            Symbol lvalue = getCurrentST().lookUp(value.getText());
            Symbol type = getCurrentST().lookUp(lvalue.getType());
            if (type instanceof DefinedTypeArraySymbol) {
                lvalueArrayBaseType = ((DefinedTypeArraySymbol) type).getBaseType();
                lvalueArrayDimension = ((DefinedTypeArraySymbol) type).getDimension();
            }
            int rvalueArrayDimension = 0;
            String rvalueArrayBaseType = null;
            Symbol rvalue = getCurrentST().lookUp(((TigerParser.ExprValueContext) expr).value().getText());
            type = getCurrentST().lookUp(rvalue.getType());
            System.out.println("exitStatAssign: " + lvalue + " " + rvalue);
            if (type instanceof DefinedTypeArraySymbol) {
                rvalueArrayBaseType = ((DefinedTypeArraySymbol) type).getBaseType();
                rvalueArrayDimension = ((DefinedTypeArraySymbol) type).getDimension();
            }
            if (!lvalueArrayBaseType.equals(rvalueArrayBaseType)) {
                errors.add(
                        new SemanticError(
                                ctx.ASSIGN().getSymbol().getLine(),
                                ctx.ASSIGN().getSymbol().getCharPositionInLine(),
                                "Cannot do array assignment to array of different type"
                        )
                );
                return;
            }
            if (lvalueArrayDimension != rvalueArrayDimension) {
                errors.add(
                        new SemanticError(
                                ctx.ASSIGN().getSymbol().getLine(),
                                ctx.ASSIGN().getSymbol().getCharPositionInLine(),
                                "Cannot do array assignment to array of different size"
                        )
                );
                return;
            }
        }
    }
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
    @Override public void enterStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").push(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").pop();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatFunctionCall(TigerParser.StatFunctionCallContext ctx) {
        String name = ctx.ID().getText();
        Symbol lookUp = getCurrentST().lookUp(name);
        if (lookUp == null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot resolve symbol '" + name + "'"
                    )
            );
            return;
        }

        String lvalueType = null;
        if (ctx.opt_prefix() != null) {
            lvalueType = getCurrentST().lookUp(ctx.opt_prefix().value().getText()).getType();
        }

//        System.out.println("enterStatFunctionCall: " + lvalueType + " " + ((SubroutineSymbol) lookUp).getReturnType());
        if ((lvalueType != null) && lvalueType.equals("int") && ((SubroutineSymbol) lookUp).getReturnType().equals("float")) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Narrowing conversion not allowed"
                    )
            );
            return;
        }

    }
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
    @Override public void enterStatBreak(TigerParser.StatBreakContext ctx) {
        if (controlFlowStack.get("for").size() == 0) {
            errors.add(
                    new SemanticError(
                            ctx.BREAK().getSymbol().getLine(),
                            ctx.BREAK().getSymbol().getCharPositionInLine(),
                            "Break statement found outside of loop(s)"
                    )
            );
        }
    }
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
    @Override public void enterStatReturn(TigerParser.StatReturnContext ctx) {
    }
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
        scopeNumber++;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatLet(TigerParser.StatLetContext ctx) { }
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
    @Override public void enterExprAddSub(TigerParser.ExprAddSubContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprAddSub(TigerParser.ExprAddSubContext ctx) {
        ExprReturnValue left = getExprReturnValue(ctx.expr(0));
        ExprReturnValue right = getExprReturnValue(ctx.expr(1));

        if (left == ExprReturnValue.ARRAY || right == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot do binary operations between two arrays"
                    )
            );
            return;
        }

        if (left == ExprReturnValue.FLOAT || right == ExprReturnValue.FLOAT) {
            setExprReturnValue(ctx, ExprReturnValue.FLOAT);
        }

        else {
            setExprReturnValue(ctx, ExprReturnValue.INT);
        }
        System.out.println("exitExprAddSub: " + left + " " + right);
    }
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
    @Override public void exitExprPow(TigerParser.ExprPowContext ctx) {
        ExprReturnValue left = getExprReturnValue(ctx.expr(0));
        ExprReturnValue right = getExprReturnValue(ctx.expr(1));

        System.out.println("exitExprPow: " + left + " " + right);
        if (left == ExprReturnValue.ARRAY || right == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot do binary operations between two arrays"
                    )
            );
            return;
        }

        if (right == ExprReturnValue.FLOAT) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Exponent is a float expression"
                    )
            );
            return;
        }

        if (left == ExprReturnValue.FLOAT)
            setExprReturnValue(ctx, ExprReturnValue.FLOAT);
        else
            setExprReturnValue(ctx, ExprReturnValue.INT);
    }
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
    @Override public void enterExprParen(TigerParser.ExprParenContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprParen(TigerParser.ExprParenContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
    }
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
    @Override public void exitExprValue(TigerParser.ExprValueContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.value()));
    }
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
    @Override public void exitExprComp(TigerParser.ExprCompContext ctx) {
        TigerParser.ExprContext left = ctx.expr(0);
        TigerParser.ExprContext right = ctx.expr(1);
        if (left.getClass() == ctx.getClass() || right.getClass() == ctx.getClass()) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Relational operators do not associate"
                    )
            );
            return;
        }
        ExprReturnValue leftReturnValue = getExprReturnValue(ctx.expr(0));
        ExprReturnValue rightReturnValue = getExprReturnValue(ctx.expr(1));

        System.out.println("left: " + left + ", right: " + right);

        if (leftReturnValue == ExprReturnValue.ARRAY || rightReturnValue == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot do binary operations between two arrays"
                    )
            );
            return;
        }


        if (leftReturnValue != rightReturnValue) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Operands for relational operators should either be both integers or both floats"
                    )
            );
        }

        setExprReturnValue(ctx, ExprReturnValue.INT);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExprMultDiv(TigerParser.ExprMultDivContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExprMultDiv(TigerParser.ExprMultDivContext ctx) {
        ExprReturnValue left = getExprReturnValue(ctx.expr(0));
        ExprReturnValue right = getExprReturnValue(ctx.expr(1));

        if (left == ExprReturnValue.ARRAY || right == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot do binary operations between two arrays"
                    )
            );
            return;
        }

        if (left == ExprReturnValue.FLOAT || right == ExprReturnValue.FLOAT) {
            setExprReturnValue(ctx, ExprReturnValue.FLOAT);
        }

        else {
            setExprReturnValue(ctx, ExprReturnValue.INT);
        }
    }
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
    @Override public void exitExprConstant(TigerParser.ExprConstantContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.constant()));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterConstantIntLit(TigerParser.ConstantIntLitContext ctx) {
        setExprReturnValue(ctx, ExprReturnValue.INT);
    }
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
    @Override public void enterConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) {
        setExprReturnValue(ctx, ExprReturnValue.FLOAT);

    }
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
    @Override public void enterValue(TigerParser.ValueContext ctx) {

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitValue(TigerParser.ValueContext ctx) {
        // err_undefined_var
        String name = ctx.ID().getText();
        Symbol lookUp = getCurrentST().lookUp(name);
        if (lookUp == null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot resolve symbol '" + name + "'"
                    )
            );
            return;
        }

        if (getExprReturnValue(ctx.value_tail()) == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot index an array with an array type"
                    )
            );
            return;
        }
        // TODO: Double-check this logic
        ExprReturnValue returnValue;
//        System.out.println("exitValue lookup: " + lookUp + " " + lookUp.getType());
        if (lookUp.getType().equals("int"))
            returnValue = ExprReturnValue.INT;
        else if (lookUp.getType().equals("float"))
            returnValue = ExprReturnValue.FLOAT;
        // get base type
        else {
            Symbol type = getCurrentST().lookUp(name);
            if (type instanceof DefinedTypeSymbol) {
                String baseType = ((DefinedTypeSymbol) type).getBaseType();
                if (baseType.equals("int"))
                    returnValue = ExprReturnValue.INT;
                else
                    returnValue = ExprReturnValue.FLOAT;
            }
            else
                returnValue = ExprReturnValue.ARRAY;
        }
        setExprReturnValue(ctx, returnValue);
    }
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
    @Override public void exitValue_tail(TigerParser.Value_tailContext ctx) {
        if (ctx != null) {
            setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
        }
    }

}
