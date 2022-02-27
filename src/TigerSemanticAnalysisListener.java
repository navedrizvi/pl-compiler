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

    ParserRuleContext returnStatement = null;

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
    @Override public void enterTypeID(TigerParser.TypeIDContext ctx) { }
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
        returnStatement = null;
    }

    public class SymbolPosTuple { 
        public final String symbol; 
        public final int line; 
        public final int pos; 
        public SymbolPosTuple(String symbol, int line, int pos) { 
          this.symbol = symbol; 
          this.line = line; 
          this.pos = pos; 
        } 
    } 
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunct(TigerParser.FunctContext ctx) {
        // wip
        ArrayList<SymbolPosTuple> fnParams = new ArrayList<SymbolPosTuple>();
        String name = ctx.ID().getText();
        SubroutineSymbol lookUp = (SubroutineSymbol) getCurrentST().lookUp(name);
       
        TigerParser.Param_listContext fnParamList = ctx.param_list();
        if (fnParamList.param()!=null) {
            TerminalNode fstParam = fnParamList.param().ID();

            SymbolPosTuple paramDetails = new SymbolPosTuple(fstParam.getText(), fstParam.getSymbol().getLine(), fstParam.getSymbol().getCharPositionInLine());
            fnParams.add(paramDetails);
            TigerParser.Param_list_tailContext c = fnParamList.param_list_tail();
            TigerParser.ParamContext param = c.param();
            while (param!=null) {
                if (param != null) {
                    TerminalNode childParam = param.ID();
                    SymbolPosTuple cparamDetails = new SymbolPosTuple(childParam.getText(), childParam.getSymbol().getLine(), childParam.getSymbol().getCharPositionInLine());
                    fnParams.add(cparamDetails);
                    c = c.param_list_tail();
                    param = c.param();
                }
            }

            for (SymbolPosTuple e: fnParams) {
                Symbol val = getCurrentST().lookUp(e.symbol);
                String type = val.getType();
                Symbol lookUp2 = getCurrentST().lookUp(type);
                if (lookUp2 instanceof DefinedTypeArraySymbol) {
                    errors.add(
                        new SemanticError(
                                e.line,
                                e.pos,
                                "Cannot pass array as an argument to a subroutine"
                        )
                    );
                    return;
                }
            }
        }
 
        String returnType = ((SubroutineSymbol) lookUp).getReturnType();
//        System.out.println(getExprReturnValue(returnStatement).name() + " " + returnType);
        if (returnStatement == null && returnType != null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Function '" + name + "' contains no return statement"
                    )
            );
            return;
        }

        if (returnStatement != null && returnType == null) {
            errors.add(
                    new SemanticError(
                            returnStatement.getStart().getLine(),
                            returnStatement.getStart().getCharPositionInLine(),
                            "Procedure '" + name + "' returned  non-void type"
                    )
            );
            return;
        }

        if (returnStatement != null && returnType != null && ((TigerParser.StatReturnContext) returnStatement).opt_return().expr() == null) {
            errors.add(
                    new SemanticError(
                            returnStatement.getStart().getLine(),
                            returnStatement.getStart().getCharPositionInLine(),
                            "Function '" + name + "' returned void, expected " + returnType
                    )
            );
            return;
        }

        if (returnStatement != null && getExprReturnValue(returnStatement) == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Function '" + name + "' cannot return an array type"
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
//            System.out.println("exitStatAssign: " + lvalue + " " + rvalue);
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
    @Override public void enterStatIf(TigerParser.StatIfContext ctx) {
   

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatIf(TigerParser.StatIfContext ctx) {
        List<ParseTree> children = ctx.expr().children;
        for (ParseTree t: children) {
            if (getExprReturnValue(t) == ExprReturnValue.ARRAY) {
                    errors.add(
                        new SemanticError(
                                ctx.IF().getSymbol().getLine(),
                                ctx.IF().getSymbol().getCharPositionInLine(),
                                "Expression in `if` condition is array type"
                        )
                );
                return;
            }
            if (getExprReturnValue(t) == ExprReturnValue.FLOAT) {
                errors.add(
                    new SemanticError(
                            ctx.IF().getSymbol().getLine(),
                            ctx.IF().getSymbol().getCharPositionInLine(),
                            "Expression in `if` condition is float type"
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
    @Override public void enterStatIfElse(TigerParser.StatIfElseContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatIfElse(TigerParser.StatIfElseContext ctx) {
        List<ParseTree> children = ctx.expr().children;
        for (ParseTree t: children) {
            if (getExprReturnValue(t) == ExprReturnValue.ARRAY) {
                    errors.add(
                        new SemanticError(
                                ctx.IF().getSymbol().getLine(),
                                ctx.IF().getSymbol().getCharPositionInLine(),
                                "Expression in `if` condition is array type"
                        )
                );
                return;
            }
            if (getExprReturnValue(t) == ExprReturnValue.FLOAT) {
                errors.add(
                    new SemanticError(
                            ctx.IF().getSymbol().getLine(),
                            ctx.IF().getSymbol().getCharPositionInLine(),
                            "Expression in `if` condition is float type"
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
    @Override public void enterStatWhile(TigerParser.StatWhileContext ctx) {
        controlFlowStack.get("while").push(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatWhile(TigerParser.StatWhileContext ctx) {
        controlFlowStack.get("while").pop();
        List<ParseTree> children = ctx.expr().children;
        for (ParseTree t: children) {
            if (getExprReturnValue(t) == ExprReturnValue.ARRAY) {
                    errors.add(
                        new SemanticError(
                                ctx.WHILE().getSymbol().getLine(),
                                ctx.WHILE().getSymbol().getCharPositionInLine(),
                                "Expression in `while` condition is array type"
                        )
                );
                return;
            }
            if (getExprReturnValue(t) == ExprReturnValue.FLOAT) {
                errors.add(
                    new SemanticError(
                            ctx.WHILE().getSymbol().getLine(),
                            ctx.WHILE().getSymbol().getCharPositionInLine(),
                            "Expression in `while` condition is float type"
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
    @Override public void enterStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").push(ctx);
        TigerParser.ExprContext left = ctx.expr(0);
        TigerParser.ExprContext right = ctx.expr(1);
        List<ParseTree> childsLeft = left.children;
        List<ParseTree> childsRight = right.children;

        List<String> symbols = new ArrayList<String>();
        // TODO should handle both types and names? (double-check)
        for (ParseTree cl: childsLeft) {
            if (cl.getChildCount() > 1) {
                ParseTree child = cl.getChild(0);
                int i = 1;
                while (child != null) {
                    child = cl.getChild(i);
                    symbols.add(cl.getText());
                    i++;
                }
            }
            if (cl.getChildCount() == 1) {
                symbols.add(cl.getText());
            }
        }
        for (ParseTree cr: childsRight) {
            if (cr.getChildCount() > 1) {
                ParseTree child = cr.getChild(0);
                int i = 1;
                while (child != null) {
                    symbols.add(child.getText());
                    child = cr.getChild(i);
                    if (child == null) {
                        break;
                    }
                    i++;
                }
            }
            if (cr.getChildCount() == 1) {
                symbols.add(cr.getText());
            }
        }

        for (String symbol: symbols) {
            Symbol lookUp = getCurrentST().lookUp(symbol);
            if (lookUp != null) {
                if (lookUp.getType().equals("float")) {
                    errors.add(
                        new SemanticError(
                                ctx.FOR().getSymbol().getLine(),
                                ctx.FOR().getSymbol().getCharPositionInLine(),
                                "For loop range is float type"
                        )
                    );
                    return;
                }
                String type = lookUp.getType();
                Symbol lookUp2 = getCurrentST().lookUp(type);
                if (lookUp2 instanceof DefinedTypeArraySymbol) {
                    errors.add(
                        new SemanticError(
                                ctx.FOR().getSymbol().getLine(),
                                ctx.FOR().getSymbol().getCharPositionInLine(),
                                "For loop range is array type"
                        )
                    );
                    return;
                }
            }
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").pop();
//        System.out.println("entering for loop" + ctx.getText() + " " + controlFlowStack.get("for"));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatFunctionCall(TigerParser.StatFunctionCallContext ctx) {


    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatFunctionCall(TigerParser.StatFunctionCallContext ctx) {
        ArrayList<SymbolPosTuple> fnArgs = new ArrayList<SymbolPosTuple>();
    
        String functionName = ctx.ID().getText();
        SubroutineSymbol lookUp = (SubroutineSymbol) getCurrentST().lookUp(functionName);
        if (lookUp == null) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot resolve symbol '" + functionName + "'"
                    )
            );
            return;
        }
        SubroutineSymbol.CustomArrayList fnParams = lookUp.getParameters();
        TigerParser.Expr_listContext args = ctx.expr_list();
        
        if (args.expr()!=null) {
            SymbolPosTuple argSyb = new SymbolPosTuple(args.expr().getText(), ctx.OPENPAREN().getSymbol().getLine(), ctx.OPENPAREN().getSymbol().getCharPositionInLine());
            fnArgs.add(argSyb);
            TigerParser.Expr_list_tailContext arg = args.expr_list_tail();
            while (arg.expr()!=null) {
                if (getCurrentST().lookUp(arg.expr().getText()) != null) {
                    SymbolPosTuple argSyb2 = new SymbolPosTuple(arg.expr().getText(), ctx.OPENPAREN().getSymbol().getLine(), ctx.OPENPAREN().getSymbol().getCharPositionInLine());
                    fnArgs.add(argSyb2);
                }
                arg = arg.expr_list_tail();
            }
        }

        for (int i=0; i<fnArgs.size(); i++) {
            if (fnArgs.size() > fnParams.size()) {
                errors.add(
                        new SemanticError(
                                ctx.getStart().getLine(),
                                ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                                "Too many arguments provided to function call"
                        )
                );
                return;
            }
            if (fnArgs.size() < fnParams.size()) {
                errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                            "Not all arguments provided to function call"
                    )
            );
                return;
            }
            SymbolPosTuple fnA = fnArgs.get(i);
            SubroutineSymbol.Tuple fnP = fnParams.get(i);

            try {
                Float.parseFloat(fnA.symbol);
                if (fnP.type.equals("int")) {
                    errors.add(
                            new SemanticError(
                                    ctx.getStart().getLine(),
                                    ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                                    "Narrowing conversion on function call"
                            )
                    );
                    return;
                }
            }
            catch (Exception e){
            }
            
            String fnAType = getCurrentST().lookUp(fnA.symbol).getType();

            if (fnAType.equals("float") && fnP.type.equals("int")) {
                errors.add(
                        new SemanticError(
                                ctx.getStart().getLine(),
                                ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                                "Narrowing conversion on function call"
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
    @Override public void enterStatBreak(TigerParser.StatBreakContext ctx) {
//        System.out.println("enterStatBreak: in break statement: " + controlFlowStack.get("for"));
        // This is not the best test for break outside of loops so might need to modify it later
        // or we come up with a different strategy during IR
        if (controlFlowStack.get("for").size() == 0 && controlFlowStack.get("while").size() == 0) {
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
    @Override public void exitStatReturn(TigerParser.StatReturnContext ctx) {
        if (getExprReturnValue(ctx.opt_return()) != null) {
            setExprReturnValue(ctx, getExprReturnValue(ctx.opt_return()));
            returnStatement = ctx;
        }

        if (ctx.RETURN() != null) {
            returnStatement = ctx;
        }
    }
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
    @Override public void exitOpt_return(TigerParser.Opt_returnContext ctx) {
        if (ctx != null)
            setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
    }
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
//        System.out.println("exitExprAddSub: " + left + " " + right);
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

//        System.out.println("exitExprPow: " + left + " " + right);
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

//        System.out.println("left: " + left + ", right: " + right);

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

        // TODO: Double-check this logic
        ExprReturnValue returnValue = null;
        if (lookUp.getType().equals("int"))
            returnValue = ExprReturnValue.INT;
        else if (lookUp.getType().equals("float"))
            returnValue = ExprReturnValue.FLOAT;
        // get base type
        else {
            // Array by index
//            System.out.println("exitValue lookup type: " + lookUp.getClass() + " " + getCurrentST().lookUp(lookUp.getType()).getClass());
            if (ctx.value_tail().getText().isEmpty() && (getCurrentST().lookUp(lookUp.getType()) instanceof DefinedTypeArraySymbol)) {
                returnValue = ExprReturnValue.ARRAY;
            }
            // Referring to array object
            else {

//                System.out.println("base type: " + lookUp + " " + lookUp.getType());
                String baseType = getBaseType(lookUp.getType());
                if (baseType.equals("int"))
                    returnValue = ExprReturnValue.INT;
                else
                    returnValue = ExprReturnValue.FLOAT;
            }
        }
        setExprReturnValue(ctx, returnValue);
    }

    private String getBaseType(String type) {
        DefinedTypeSymbol typeSymbol = (DefinedTypeSymbol) getCurrentST().lookUp(type);
        String baseType = typeSymbol.getBaseType();
//        System.out.println("base type 1: " + baseType + " " + typeSymbol);
        while(!(baseType.equals("int") || baseType.equals("float"))) {
//            System.out.println("base type 2: " + baseType + " " + typeSymbol + " " + (!baseType.equals("int") || !baseType.equals("float")));
            typeSymbol = (DefinedTypeSymbol) getCurrentST().lookUp(baseType);
            baseType = typeSymbol.getBaseType();
        }
//        System.out.println("base type 3: " + baseType + " " + typeSymbol.getType());
        return baseType;
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
//        System.out.println("exitValue_tail ctx: " + ctx.getText());
        if (ctx.getText().isEmpty())
            return;

        if(getExprReturnValue(ctx.expr()) == ExprReturnValue.FLOAT) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot index an array with a float type"
                    )
            );
            return;
        }

        if(getExprReturnValue(ctx.expr()) == ExprReturnValue.ARRAY) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            "Cannot index an array with an array type"
                    )
            );
            return;
        }

        setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
    }

}
