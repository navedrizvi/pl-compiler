import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.*;

public class TigerIRListener extends TigerBaseListener {

    static class Value {
        String value;
        String type;

        public Value(String value, String type) {
            this.value = value;
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
        }
    }

    private List<SymbolTable> stAsList;
    private int scopeNumber = -1;
    ParseTreeProperty<Value> ctxValues = new ParseTreeProperty<>();
    private Map<Integer, Map<String, String>> intListMap = new HashMap<>();
    private Map<Integer, Map<String, String>> floatListMap = new HashMap<>();
    private List<String> varDecList = null;
    private Map<String, String> staticVars = new HashMap<>();
    // maps labels for each level of for, while, if, else
    private Map<String, Stack<String>> controlFlowStack;

    public TigerIRListener(List<SymbolTable> stAsList) {
        this.stAsList = stAsList;
        this.controlFlowStack = new LinkedHashMap<>();
        this.controlFlowStack.put("for", new Stack<>());
        this.controlFlowStack.put("while", new Stack<>());
        this.controlFlowStack.put("if", new Stack<>());
        this.controlFlowStack.put("else", new Stack<>());
    }

    private void setValue(ParseTree node, Value value) { ctxValues.put(node, value); }

    private Value getValue(ParseTree node) { return ctxValues.get(node); }

    private SymbolTable getCurrentST() { return stAsList.get(scopeNumber); }

    @Override public void enterMain(TigerParser.MainContext ctx) {
        scopeNumber++;
        IR.emit("start_program " + ctx.ID().getText());
    }

    private String getMangledName(String name, int scopeNumber) {
        return "_" + scopeNumber + "_" + name;
    }

    @Override public void exitMain(TigerParser.MainContext ctx) {
        IR.emit("end_program " + ctx.ID().getText());
    }

    @Override public void enterDecl_seg(TigerParser.Decl_segContext ctx) { }

    @Override public void exitDecl_seg(TigerParser.Decl_segContext ctx) {
        if (scopeNumber == 0) {
            IR.populateStaticVarLists();
        }
    }

    @Override public void enterType_decl_list(TigerParser.Type_decl_listContext ctx) { }

    @Override public void exitType_decl_list(TigerParser.Type_decl_listContext ctx) { }

    @Override public void enterVar_decl_list(TigerParser.Var_decl_listContext ctx) { }

    @Override public void exitVar_decl_list(TigerParser.Var_decl_listContext ctx) { }

    @Override public void enterFunct_list(TigerParser.Funct_listContext ctx) { }

    @Override public void exitFunct_list(TigerParser.Funct_listContext ctx) { }

    @Override public void enterType_decl(TigerParser.Type_declContext ctx) { }

    @Override public void exitType_decl(TigerParser.Type_declContext ctx) { }

    @Override public void enterTypeBaseType(TigerParser.TypeBaseTypeContext ctx) { }

    @Override public void exitTypeBaseType(TigerParser.TypeBaseTypeContext ctx) { }

    @Override public void enterTypeArray(TigerParser.TypeArrayContext ctx) { }

    @Override public void exitTypeArray(TigerParser.TypeArrayContext ctx) { }

    @Override public void enterTypeID(TigerParser.TypeIDContext ctx) { }

    @Override public void exitTypeID(TigerParser.TypeIDContext ctx) { }

    @Override public void enterBaseTypeInt(TigerParser.BaseTypeIntContext ctx) { }

    @Override public void exitBaseTypeInt(TigerParser.BaseTypeIntContext ctx) { }

    @Override public void enterBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx) { }

    @Override public void exitBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx) { }

    @Override public void enterVar_decl(TigerParser.Var_declContext ctx) {
        varDecList = new ArrayList<>();
    }

    @Override public void exitVar_decl(TigerParser.Var_declContext ctx) {
        for (String var : varDecList) {
            boolean isArray = false;
            boolean isDefinedType = false;
            String baseType = null;
            int dimension = 0;
            int scopeNumber = getCurrentST().getScopeNumber(var);
            String mangledName = getMangledName(var, scopeNumber);
            String arrayMangledName = mangledName;
            VariableSymbol symbol = (VariableSymbol) getCurrentST().lookUp(var);
            String type = symbol.getType();
            if (type.equals("int")) {
                if (symbol.getStorageClass() == VariableSymbol.StorageClass.VAR)
                    IR.addVarInt(mangledName);
                else {
                    IR.addStaticInt(mangledName);
                    if (ctx.optional_init().constant() != null)
                        staticVars.put(mangledName, ctx.optional_init().constant().getText());
                }
            }
            else if (type.equals("float")) {
                if (symbol.getStorageClass() == VariableSymbol.StorageClass.VAR)
                    IR.addVarFloat(mangledName);
                else {
                    IR.addStaticFloat(mangledName);
                    if (ctx.optional_init().constant() != null)
                        staticVars.put(mangledName, ctx.optional_init().constant().getText());
                }
            }
            else {
                isDefinedType = true;
                DefinedTypeSymbol baseTypeSymbol = getBaseTypeSymbol(type);
                baseType = baseTypeSymbol.getBaseType();
                if (baseTypeSymbol instanceof DefinedTypeArraySymbol) {
                    isArray = true;
                    dimension = ((DefinedTypeArraySymbol) baseTypeSymbol).getDimension();
                    arrayMangledName += "[" + dimension + "]";
                }
                if (baseType.equals("int")) {
                    if (symbol.getStorageClass() == VariableSymbol.StorageClass.VAR) {
                        if(isArray)
                            IR.addVarInt(arrayMangledName);
                        else
                            IR.addVarInt(mangledName);
                    }
                    else {
                        if(isArray) {
                            IR.addStaticInt(arrayMangledName);
                            if (ctx.optional_init().constant() != null)
                                staticVars.put(arrayMangledName, ctx.optional_init().constant().getText());
                        }
                        else {
                            IR.addStaticInt(mangledName);
                            if (ctx.optional_init().constant() != null)
                                staticVars.put(mangledName, ctx.optional_init().constant().getText());
                        }
                    }
                }
                else if (baseType.equals("float")) {
                    if (symbol.getStorageClass() == VariableSymbol.StorageClass.VAR) {
                        if(isArray)
                            IR.addVarFloat(arrayMangledName);
                        else
                            IR.addVarFloat(mangledName);
                    }
                    else {
                        if (isArray) {
                            IR.addStaticFloat(arrayMangledName);
                            if (ctx.optional_init().constant() != null)
                                staticVars.put(arrayMangledName, ctx.optional_init().constant().getText());
                        }
                        else {
                            IR.addStaticFloat(mangledName);
                            if (ctx.optional_init().constant() != null)
                                staticVars.put(mangledName, ctx.optional_init().constant().getText());
                        }
                    }
                }

            }
            if (symbol.getStorageClass() == VariableSymbol.StorageClass.VAR && !ctx.optional_init().getText().isEmpty()) {
                if (isDefinedType && isArray)
                    IR.emit("assign, " + mangledName + ", " + dimension + ", " + ctx.optional_init().constant().getText());
                else
                    IR.emit("assign, " + mangledName + ", " + ctx.optional_init().constant().getText());
            }
        }
    }

    private String getBaseType(String type) {
        if (type.equals("int") || type.equals("float"))
            return type;
        return getBaseTypeSymbol(type).getBaseType();
    }

    private DefinedTypeSymbol getBaseTypeSymbol(String type) {
        DefinedTypeSymbol typeSymbol = (DefinedTypeSymbol) getCurrentST().lookUp(type);
        String baseType = typeSymbol.getBaseType();
        while(!(baseType.equals("int") || baseType.equals("float"))) {
            typeSymbol = (DefinedTypeSymbol) getCurrentST().lookUp(baseType);
            baseType = typeSymbol.getBaseType();
        }
        return typeSymbol;
    }

    @Override public void enterStorageClassVar(TigerParser.StorageClassVarContext ctx) { }

    @Override public void exitStorageClassVar(TigerParser.StorageClassVarContext ctx) { }

    @Override public void enterStorageClassStatic(TigerParser.StorageClassStaticContext ctx) { }

    @Override public void exitStorageClassStatic(TigerParser.StorageClassStaticContext ctx) { }

    @Override public void enterIdListId(TigerParser.IdListIdContext ctx) { }

    @Override public void exitIdListId(TigerParser.IdListIdContext ctx) {
        varDecList.add(ctx.ID().getText());
    }

    @Override public void enterIdList(TigerParser.IdListContext ctx) { }

    @Override public void exitIdList(TigerParser.IdListContext ctx) {
        varDecList.add(ctx.ID().getText());
    }

    @Override public void enterOptional_init(TigerParser.Optional_initContext ctx) { }

    @Override public void exitOptional_init(TigerParser.Optional_initContext ctx) { }

    @Override public void enterFunct(TigerParser.FunctContext ctx) {
        scopeNumber++;
        String name = ctx.ID().getText();
        Symbol lookUp = getCurrentST().lookUp(name);
        String returnType = ((SubroutineSymbol) lookUp).getReturnType();
        IR.emit("start_function " + name);
        IR.emit(returnType + " " + name + "()");
        IR.emitForVarIntList();
        IR.emitForVarFloatList();
        IR.emit(name + ":");
        if (name.equals("main")) {
            for (Map.Entry<String, String> entry : staticVars.entrySet()) {
                if (entry.getValue().isEmpty())
                    continue;
                String array = entry.getKey();
                if (array.endsWith("]")) {
                    String varName = array.substring(0, array.indexOf("["));
                    String dimension = array.substring(array.indexOf("[") + 1, array.indexOf("]"));
                    IR.emit("assign, " + varName + ", " + dimension + ", " + entry.getValue());
                }
                else {
                    IR.emit("assign, " + entry.getKey() + ", " + entry.getValue());
                }
            }
        }
    }

    @Override public void exitFunct(TigerParser.FunctContext ctx) {
        String name = ctx.ID().getText();
        IR.populateVarLists();
        IR.emit("end_function " + name);
        IR.reset();
    }

    @Override public void enterParam_list(TigerParser.Param_listContext ctx) { }

    @Override public void exitParam_list(TigerParser.Param_listContext ctx) { }

    @Override public void enterParam_list_tail(TigerParser.Param_list_tailContext ctx) { }

    @Override public void exitParam_list_tail(TigerParser.Param_list_tailContext ctx) { }

    @Override public void enterReturn_type(TigerParser.Return_typeContext ctx) { }

    @Override public void exitReturn_type(TigerParser.Return_typeContext ctx) { }

    @Override public void enterParam(TigerParser.ParamContext ctx) { }

    @Override public void exitParam(TigerParser.ParamContext ctx) { }

    @Override public void enterStatSingle(TigerParser.StatSingleContext ctx) { }

    @Override public void enterStatSeq(TigerParser.StatSeqContext ctx) { }

    @Override public void exitStatSeq(TigerParser.StatSeqContext ctx) { }

    @Override public void enterStatAssign(TigerParser.StatAssignContext ctx) { }

    @Override public void exitStatAssign(TigerParser.StatAssignContext ctx) {
        String name = ctx.value().ID().getText();
        Value value = getValue(ctx.value());
        Value expr = getValue(ctx.expr());
        int scopeNumber = getCurrentST().getScopeNumber(name);
        String mangledName = getMangledName(name, scopeNumber);
        // Array index on left
        if (value.getValue().endsWith("]")) {
            int leftBracket = value.getValue().indexOf("[");
            String indexValue = value.getValue().substring(leftBracket + 1, value.getValue().indexOf("]"));
            String varName = value.getValue().substring(0, leftBracket);
            IR.emit("array_store, " + varName + ", " + indexValue + ", " + expr.getValue());
        }
        else {
            IR.emit("assign, " + value.getValue() + ", " + expr.getValue());
        }
    }

    @Override public void enterStatIf(TigerParser.StatIfContext ctx) {
        String label = IR.createNewLabel();
        controlFlowStack.get("if").push(label);
    }

    @Override public void exitStatIf(TigerParser.StatIfContext ctx) {
        String label = controlFlowStack.get("if").pop();
        IR.emit(label + ":");
    }

    @Override public void exitStatSingle(TigerParser.StatSingleContext ctx) {
        // This assumes that if-else is not nested.
        if (controlFlowStack.get("else").size() == 1 && controlFlowStack.get("if").size() == 1) {
            IR.emit("goto, " + controlFlowStack.get("if").peek());
            String label = controlFlowStack.get("else").pop();
            IR.emit(label + ":");
        }
        else if (controlFlowStack.get("else").size() > 0 ) {
            if (controlFlowStack.get("else").size() % 2 == 0) {
                IR.emit("goto, " + controlFlowStack.get("if").peek());
                String label = controlFlowStack.get("else").pop();
                IR.emit(label + ":");
            }
        }
    }

    @Override public void enterStatIfElse(TigerParser.StatIfElseContext ctx) {
        String label = IR.createNewLabel();
        controlFlowStack.get("else").push(label);
        label = IR.createNewLabel();
        controlFlowStack.get("if").push(label);
    }

    @Override public void exitStatIfElse(TigerParser.StatIfElseContext ctx) {
        String label;
        label = controlFlowStack.get("if").pop();
        IR.emit(label + ":");
        if (controlFlowStack.get("if").size() > 0) {
            if (controlFlowStack.get("if").size() % 2 == 0) {
                IR.emit("goto, " + controlFlowStack.get("if").peek());
            }
        }
        if (controlFlowStack.get("else").size() > 0 && controlFlowStack.get("else").size() % 2 != 0) {
            label = controlFlowStack.get("else").pop();
            IR.emit(label + ":");
        }
    }

    @Override public void enterStatWhile(TigerParser.StatWhileContext ctx) {
        System.out.println("enterStatWhile");
        String loopLabel = IR.createNewLabel();
        String exitLabel = IR.createNewLabel();
        IR.emit(loopLabel + ":");
        controlFlowStack.get("while").push(loopLabel);
        controlFlowStack.get("while").push(exitLabel);
    }

    @Override public void exitStatWhile(TigerParser.StatWhileContext ctx) {
        System.out.println("exitStatWhile 1");
        String exitLabel = controlFlowStack.get("while").pop();
        String loopLabel = controlFlowStack.get("while").pop();
        IR.emit("goto, " + loopLabel);
        IR.emit(exitLabel + ":");
        System.out.println("exitStatWhile 2");
    }

    @Override public void enterStatFor(TigerParser.StatForContext ctx) { }

    @Override public void exitStatFor(TigerParser.StatForContext ctx) { }

    @Override public void enterStatFunctionCall(TigerParser.StatFunctionCallContext ctx) { }

    @Override public void exitStatFunctionCall(TigerParser.StatFunctionCallContext ctx) {
        // Will need to expand this for when there is a list of expressions in a function call.
        Value expr = getValue(ctx.expr_list().expr());
        Value value = getValue(ctx.opt_prefix());

        // Currently does not handle function call assignment to array indexing
        if (value == null) {
            IR.emit("call, " + ctx.ID().getText() + ", " + expr.getValue());
        }
        else {
            IR.emit("callr, " + value.getValue() + ", " + ctx.ID().getText() + ", " + expr.getValue());
        }
    }

    @Override public void enterStatBreak(TigerParser.StatBreakContext ctx) { }

    @Override public void exitStatBreak(TigerParser.StatBreakContext ctx) { }

    @Override public void enterStatReturn(TigerParser.StatReturnContext ctx) { }

    @Override public void exitStatReturn(TigerParser.StatReturnContext ctx) {
        IR.emit("return, 0, ,");
    }

    @Override public void enterStatLet(TigerParser.StatLetContext ctx) {
        scopeNumber++;
    }

    @Override public void exitStatLet(TigerParser.StatLetContext ctx) { }

    @Override public void enterOpt_return(TigerParser.Opt_returnContext ctx) { }

    @Override public void exitOpt_return(TigerParser.Opt_returnContext ctx) { }

    @Override public void enterOpt_prefix(TigerParser.Opt_prefixContext ctx) { }

    @Override public void exitOpt_prefix(TigerParser.Opt_prefixContext ctx) {
        setValue(ctx, getValue(ctx.value()));
    }

    @Override public void enterExprAddSub(TigerParser.ExprAddSubContext ctx) { }

    @Override public void exitExprAddSub(TigerParser.ExprAddSubContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));

        VariableSymbol temp;
        if (left.getType().equals("int") && right.getType().equals("int")) {
            temp = IR.createNewTemp("int", getCurrentST().getScope());
            IR.addVarInt(temp.getName());
        }
        else {
            temp = IR.createNewTemp("float", getCurrentST().getScope());
            IR.addVarFloat(temp.getName());
        }

        getCurrentST().insert(temp.getName(), temp);

        String op = ctx.op.getText();
        if (op.equals("+")) {
            IR.emit("add, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        }
        else {
            IR.emit("sub, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        }

        setValue(ctx, new Value(temp.getName(), temp.getType()));
    }

    @Override public void enterExprAnd(TigerParser.ExprAndContext ctx) { }

    @Override public void exitExprAnd(TigerParser.ExprAndContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));

        VariableSymbol temp = IR.createNewTemp("int", getCurrentST().getScope());
        IR.addVarInt(temp.getName());

        getCurrentST().insert(temp.getName(), temp);

        IR.emit("and, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        setValue(ctx, new Value(temp.getName(), temp.getType()));
    }

    @Override public void enterExprPow(TigerParser.ExprPowContext ctx) { }

    @Override public void exitExprPow(TigerParser.ExprPowContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));
        if (right.getValue().equals("0")) {
            VariableSymbol temp = IR.createNewTemp("int", getCurrentST().getScope());
            getCurrentST().insert(temp.getName(), temp);
            IR.addVarInt(temp.getName());
            IR.emit("assign, " + temp.getName() + ", 1");
            setValue(ctx, new Value(temp.getName(), temp.getType()));
            return;
        }
        String code = "brgeq";
        String loopLabel = IR.createNewLabel();
        String exitLabel = IR.createNewLabel();
        VariableSymbol tempIter = IR.createNewTemp("int", getCurrentST().getScope());
        getCurrentST().insert(tempIter.getName(), tempIter);
        IR.addVarInt(tempIter.getName());

        VariableSymbol tempValue;
        if (left.getType().equals("float")) {
            tempValue = IR.createNewTemp("float", getCurrentST().getScope());
            IR.addVarFloat(tempValue.getName());
        }
        else {
            tempValue = IR.createNewTemp("int", getCurrentST().getScope());
            IR.addVarInt(tempValue.getName());
        }
        getCurrentST().insert(tempValue.getName(), tempValue);
        IR.emit("assign, " + tempIter.getName() + ", 1");
        IR.emit("assign, " + tempValue.getName() + ", " + left.getValue());
        IR.emit(loopLabel + ":");
        IR.emit(code + ", " + tempIter.getName() + ", " + right.getValue() + ", " + exitLabel);
        IR.emit("mult, " + tempValue.getName() + ", " + left.getValue() + ", " + tempValue.getName());
        IR.emit("add, " + tempIter.getName() + ", " +  "1, " + tempIter.getName());
        IR.emit("goto, " + loopLabel);
        IR.emit(exitLabel + ":");
        setValue(ctx, new Value(tempValue.getName(), tempValue.getType()));
    }

    @Override public void enterExporOr(TigerParser.ExporOrContext ctx) { }

    @Override public void exitExporOr(TigerParser.ExporOrContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));

        VariableSymbol temp = IR.createNewTemp("int", getCurrentST().getScope());
        IR.addVarInt(temp.getName());

        getCurrentST().insert(temp.getName(), temp);

        IR.emit("or, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        setValue(ctx, new Value(temp.getName(), temp.getType()));
    }

    @Override public void enterExprParen(TigerParser.ExprParenContext ctx) { }

    @Override public void exitExprParen(TigerParser.ExprParenContext ctx) {
        setValue(ctx, getValue(ctx.expr()));
    }

    @Override public void enterExprValue(TigerParser.ExprValueContext ctx) { }

    @Override public void exitExprValue(TigerParser.ExprValueContext ctx) {
        Value value = getValue(ctx.value());
        if (value.getValue().endsWith("]")) {
            int leftBracket = value.getValue().indexOf("[");
            String indexValue = value.getValue().substring(leftBracket + 1, value.getValue().indexOf("]"));
            String varName = value.getValue().substring(0, leftBracket);
            VariableSymbol temp = IR.createNewTemp(value.getType(), getCurrentST().getScope());
            getCurrentST().insert(temp.getName(), temp);
            if (value.getType().equals("int"))
                IR.addVarInt(temp.getName());
            else
                IR.addVarFloat(temp.getName());
            IR.emit("array_load, " + temp.getName() + ", " + varName + ", " + indexValue);
            setValue(ctx, new Value(temp.getName(), temp.getType()));
        }
        else {
            setValue(ctx, getValue(ctx.value()));
        }
    }

    @Override public void enterExprComp(TigerParser.ExprCompContext ctx) { }

    @Override public void exitExprComp(TigerParser.ExprCompContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));

        String op = ctx.op.getText();
        String code;
        // Take opposite code
        if (op.equals("==")) {
            // !=
            code = "brneq";
        }
        else if (op.equals("!=")) {
            // ==
            code = "breq";
        }
        else if (op.equals("<")) {
            // >=
            code = "brgeq";
        }
        else if (op.equals(">")) {
            // <=
            code = "brleq";
        }
        else if (op.equals("<=")) {
            // >
            code = "brgt";
        }
        // >=
        else {
            // <
            code = "brlt";
        }

        VariableSymbol temp = IR.createNewTemp("int", getCurrentST().getScope());
        getCurrentST().insert(temp.getName(), temp);
        IR.addVarInt(temp.getName());

        if (controlFlowStack.get("if").size() > 0) {
            IR.emit("assign, " + temp.getName() + ", 0");
            if (controlFlowStack.get("else").size() > 0) {
                IR.emit(code + ", " + left.getValue() + ", " + right.getValue() + ", " + controlFlowStack.get("else").peek());
            }
            else {
                IR.emit(code + ", " + left.getValue() + ", " + right.getValue() + ", " + controlFlowStack.get("if").peek());
            }
            IR.emit("assign, " + temp.getName() + ", 1");
        }
        else if (controlFlowStack.get("while").size() > 0) {
            IR.emit("assign, " + temp.getName() + ", 0");
            IR.emit(code + ", " + left.getValue() + ", " + right.getValue() + ", " + controlFlowStack.get("while").peek());
            IR.emit("assign, " + temp.getName() + ", 1");
        }
        // Comparison operators inside a function call (for example)
        else {
            IR.emit("assign, " + temp.getName() + ", 0");
            String label = IR.createNewLabel();
            IR.emit(code + ", " + left.getValue() + ", " + right.getValue() + ", " + label);
            IR.emit("assign, " + temp.getName() + ", 1");
            IR.emit(label + ":");
        }
        setValue(ctx, new Value(temp.getName(), temp.getType()));
    }

    @Override public void enterExprMultDiv(TigerParser.ExprMultDivContext ctx) { }

    @Override public void exitExprMultDiv(TigerParser.ExprMultDivContext ctx) {
        Value left = getValue(ctx.expr(0));
        Value right = getValue(ctx.expr(1));

        VariableSymbol temp;
        if (left.getType().equals("int") && right.getType().equals("int")) {
            temp = IR.createNewTemp("int", getCurrentST().getScope());
            IR.addVarInt(temp.getName());
        }
        else {
            temp = IR.createNewTemp("float", getCurrentST().getScope());
            IR.addVarFloat(temp.getName());
        }

        getCurrentST().insert(temp.getName(), temp);

        String op = ctx.op.getText();
        if (op.equals("*")) {
            IR.emit("mult, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        }
        else {
            IR.emit("div, " + left.getValue() + ", " + right.getValue() + ", " + temp.getName());
        }

        setValue(ctx, new Value(temp.getName(), temp.getType()));
    }

    @Override public void enterExprConstant(TigerParser.ExprConstantContext ctx) { }

    @Override public void exitExprConstant(TigerParser.ExprConstantContext ctx) {
        setValue(ctx, getValue(ctx.constant()));
    }

    @Override public void enterConstantIntLit(TigerParser.ConstantIntLitContext ctx) { }

    @Override public void exitConstantIntLit(TigerParser.ConstantIntLitContext ctx) {
        setValue(ctx, new Value(ctx.getText(), "int"));
    }

    @Override public void enterConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) { }

    @Override public void exitConstantFloatLit(TigerParser.ConstantFloatLitContext ctx) {
        setValue(ctx, new Value(ctx.getText(), "float"));
    }

    @Override public void enterExpr_list(TigerParser.Expr_listContext ctx) { }

    @Override public void exitExpr_list(TigerParser.Expr_listContext ctx) { }

    @Override public void enterExpr_list_tail(TigerParser.Expr_list_tailContext ctx) { }

    @Override public void exitExpr_list_tail(TigerParser.Expr_list_tailContext ctx) { }

    @Override public void enterValue(TigerParser.ValueContext ctx) { }

    @Override public void exitValue(TigerParser.ValueContext ctx) {
        String name = ctx.ID().getText();
        Symbol lookup = getCurrentST().lookUp(name);
        String baseType = getBaseType(lookup.getType());
        int scopeNumber = getCurrentST().getScopeNumber(name);
        String mangledName = getMangledName(name, scopeNumber);
        if (!ctx.value_tail().getText().isEmpty()) {
            mangledName += ctx.value_tail().getText();
        }
        setValue(ctx, new Value(mangledName, baseType));
    }

    @Override public void enterValue_tail(TigerParser.Value_tailContext ctx) { }

    @Override public void exitValue_tail(TigerParser.Value_tailContext ctx) {
        Value value = getValue(ctx.expr());
        if (value == null)
            return;
        setValue(ctx, new Value(value.getValue(), value.getType()));
    }
}