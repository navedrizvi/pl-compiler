import org.antlr.v4.runtime.ParserRuleContext;
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

    private void setExprReturnValue(ParseTree node, ExprReturnValue value) { exprReturnValues.put(node, value); }

    private ExprReturnValue getExprReturnValue(ParseTree node) { return exprReturnValues.get(node); }

    private String currentFunctionName = null;
    private boolean currentFunctionVoidReturn = false;

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

    @Override public void enterMain(TigerParser.MainContext ctx) {
        scopeNumber++;

    }

    @Override public void enterFunct(TigerParser.FunctContext ctx) {
        scopeNumber++;
        returnStatement = null;
        currentFunctionName = ctx.ID().getText();
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

    @Override public void exitFunct(TigerParser.FunctContext ctx) {
        currentFunctionName = null;

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
        if (returnStatement == null && returnType != null) {
            currentFunctionVoidReturn = true;
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
            currentFunctionVoidReturn = true;
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
            currentFunctionVoidReturn = true;
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
            currentFunctionVoidReturn = true;
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

    @Override public void enterStatWhile(TigerParser.StatWhileContext ctx) {
        controlFlowStack.get("while").push(ctx);
    }

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

    @Override public void enterStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").push(ctx);
        TigerParser.ExprContext left = ctx.expr(0);
        TigerParser.ExprContext right = ctx.expr(1);
        List<ParseTree> childsLeft = left.children;
        List<ParseTree> childsRight = right.children;

        List<String> symbols = new ArrayList<String>();
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

    @Override public void exitStatFor(TigerParser.StatForContext ctx) {
        controlFlowStack.get("for").pop();
    }

    @Override public void exitStatFunctionCall(TigerParser.StatFunctionCallContext ctx) {
        ArrayList<SymbolPosTuple> fnArgSymbs = new ArrayList<SymbolPosTuple>();
        int fnArgsCount = 0;
    
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
    
        if (ctx.opt_prefix().value() != null) {
            if (lookUp.getReturnType().equals("float") && getCurrentST().lookUp(ctx.opt_prefix().value().getText()).getType().equals("int")) {
                errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                            "Narrowing conversion on function assignment"
                    )
                );
                return;
            }
        }
        SubroutineSymbol.CustomArrayList fnParams = lookUp.getParameters();
        TigerParser.Expr_listContext args = ctx.expr_list();
        
        if (args.expr()!=null) {
            SymbolPosTuple argSyb = new SymbolPosTuple(args.expr().getText(), ctx.OPENPAREN().getSymbol().getLine(), ctx.OPENPAREN().getSymbol().getCharPositionInLine());
            fnArgSymbs.add(argSyb);
            fnArgsCount += 1;
            TigerParser.Expr_list_tailContext arg = args.expr_list_tail();
            while (arg.expr()!=null) {
                fnArgsCount += 1;
                if (getCurrentST().lookUp(arg.expr().getText()) != null) {
                    SymbolPosTuple argSyb2 = new SymbolPosTuple(arg.expr().getText(), ctx.OPENPAREN().getSymbol().getLine(), ctx.OPENPAREN().getSymbol().getCharPositionInLine());
                    fnArgSymbs.add(argSyb2);
                }
                arg = arg.expr_list_tail();
            }
        }
        if (fnArgsCount > fnParams.size()) {
            errors.add(
                    new SemanticError(
                            ctx.getStart().getLine(),
                            ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                            "Too many arguments provided to function call"
                    )
            );
            return;
        }
        if (fnArgsCount < fnParams.size()) {
            errors.add(
                new SemanticError(
                        ctx.getStart().getLine(),
                        ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
                        "Not all arguments provided to function call"
                )
            );
            return;
        }

        for (int i=0; i < fnArgSymbs.size(); i++) {
            SymbolPosTuple fnA = fnArgSymbs.get(i);
            SubroutineSymbol.Tuple fnP = fnParams.get(i);

            System.out.println(fnA.symbol);
            System.out.println(fnP.name);

            // TODO: remove when all IR is passing
//            try {
//                Float.parseFloat(fnA.symbol);
//                if (fnP.type.equals("int") && currentFunctionVoidReturn!= true) {
//                    System.out.println("here");
//                    errors.add(
//                            new SemanticError(
//                                    ctx.getStart().getLine(),
//                                    ctx.CLOSEPAREN().getSymbol().getCharPositionInLine(),
//                                    "Narrowing conversion on function call"
//                            )
//                    );
//                    return;
//                }
//            }
//            catch (Exception e){
//            }
            
            Symbol lookUp2 = getCurrentST().lookUp(fnA.symbol);
            if (lookUp2 == null) {
                return;
            }
            if (currentFunctionVoidReturn != true) {
                if (lookUp2.getType().equals("float") && fnP.type.equals("int")) {
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
    }

    @Override public void enterStatBreak(TigerParser.StatBreakContext ctx) {
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

    @Override public void exitStatReturn(TigerParser.StatReturnContext ctx) {
        if (getExprReturnValue(ctx.opt_return()) != null) {
            setExprReturnValue(ctx, getExprReturnValue(ctx.opt_return()));
            returnStatement = ctx;
        }

        SubroutineSymbol function = (SubroutineSymbol) getCurrentST().lookUp(currentFunctionName);
        if (currentFunctionVoidReturn != true) {
            if (function != null) {
                if (function.getReturnType() != null && ctx.opt_return().expr() != null) {
                    if ((function.getReturnType().equals("int")) && getExprReturnValue(ctx.opt_return().expr()) == ExprReturnValue.FLOAT) {
                        errors.add(
                                new SemanticError(
                                        ctx.getStart().getLine(),
                                        ctx.RETURN().getSymbol().getCharPositionInLine(),
                                        "Narrowing conversion on function call"
                                )
                        );
                        return;
                    }
                }
           }
        }
        
        if (ctx.RETURN() != null) {
            returnStatement = ctx;
        }
    }

    @Override public void enterStatLet(TigerParser.StatLetContext ctx) {
        scopeNumber++;
    }

    @Override public void exitOpt_return(TigerParser.Opt_returnContext ctx) {
        if (ctx != null)
            setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
    }

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
    }

    @Override public void exitExprPow(TigerParser.ExprPowContext ctx) {
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

    @Override public void exitExprParen(TigerParser.ExprParenContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.expr()));
    }

    @Override public void exitExprValue(TigerParser.ExprValueContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.value()));
    }

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

    @Override public void exitExprConstant(TigerParser.ExprConstantContext ctx) {
        setExprReturnValue(ctx, getExprReturnValue(ctx.constant()));
    }

    @Override public void enterConstantIntLit(TigerParser.ConstantIntLitContext ctx) {
        setExprReturnValue(ctx, ExprReturnValue.INT);
    }

    @Override public void exitConstantIntLit(TigerParser.ConstantIntLitContext ctx) { }

    @Override public void enterConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) {
        setExprReturnValue(ctx, ExprReturnValue.FLOAT);
    }

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
            if (ctx.value_tail().getText().isEmpty() && (getCurrentST().lookUp(lookUp.getType()) instanceof DefinedTypeArraySymbol)) {
                returnValue = ExprReturnValue.ARRAY;
            }
            // Referring to array object
            else {

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
        while(!(baseType.equals("int") || baseType.equals("float"))) {
            typeSymbol = (DefinedTypeSymbol) getCurrentST().lookUp(baseType);
            baseType = typeSymbol.getBaseType();
        }
        return baseType;
    }

    @Override public void exitValue_tail(TigerParser.Value_tailContext ctx) {
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
