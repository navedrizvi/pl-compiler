// Generated from Tiger.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TigerParser}.
 */
public interface TigerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TigerParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TigerParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TigerParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#decl_seg}.
	 * @param ctx the parse tree
	 */
	void enterDecl_seg(TigerParser.Decl_segContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#decl_seg}.
	 * @param ctx the parse tree
	 */
	void exitDecl_seg(TigerParser.Decl_segContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#type_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterType_decl_list(TigerParser.Type_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#type_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitType_decl_list(TigerParser.Type_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#var_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_list(TigerParser.Var_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#var_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_list(TigerParser.Var_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#funct_list}.
	 * @param ctx the parse tree
	 */
	void enterFunct_list(TigerParser.Funct_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#funct_list}.
	 * @param ctx the parse tree
	 */
	void exitFunct_list(TigerParser.Funct_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void enterType_decl(TigerParser.Type_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void exitType_decl(TigerParser.Type_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBaseType}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBaseType(TigerParser.TypeBaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBaseType}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBaseType(TigerParser.TypeBaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeArray}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeArray(TigerParser.TypeArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeArray}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeArray(TigerParser.TypeArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeID}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeID(TigerParser.TypeIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeID}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeID(TigerParser.TypeIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeInt}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeInt(TigerParser.BaseTypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeInt}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeInt(TigerParser.BaseTypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeFloat}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeFloat}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(TigerParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(TigerParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StorageClassVar}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void enterStorageClassVar(TigerParser.StorageClassVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StorageClassVar}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void exitStorageClassVar(TigerParser.StorageClassVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StorageClassStatic}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void enterStorageClassStatic(TigerParser.StorageClassStaticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StorageClassStatic}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void exitStorageClassStatic(TigerParser.StorageClassStaticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdListId}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterIdListId(TigerParser.IdListIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdListId}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitIdListId(TigerParser.IdListIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdList}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterIdList(TigerParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdList}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitIdList(TigerParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#optional_init}.
	 * @param ctx the parse tree
	 */
	void enterOptional_init(TigerParser.Optional_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#optional_init}.
	 * @param ctx the parse tree
	 */
	void exitOptional_init(TigerParser.Optional_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#funct}.
	 * @param ctx the parse tree
	 */
	void enterFunct(TigerParser.FunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#funct}.
	 * @param ctx the parse tree
	 */
	void exitFunct(TigerParser.FunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(TigerParser.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(TigerParser.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#param_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_list_tail(TigerParser.Param_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#param_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_list_tail(TigerParser.Param_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(TigerParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(TigerParser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(TigerParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(TigerParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatSingle}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void enterStatSingle(TigerParser.StatSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatSingle}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void exitStatSingle(TigerParser.StatSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatSeq}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void enterStatSeq(TigerParser.StatSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatSeq}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void exitStatSeq(TigerParser.StatSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(TigerParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(TigerParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatIf}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatIf(TigerParser.StatIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatIf}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatIf(TigerParser.StatIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatIfElse}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatIfElse(TigerParser.StatIfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatIfElse}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatIfElse(TigerParser.StatIfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatWhile}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatWhile(TigerParser.StatWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatWhile}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatWhile(TigerParser.StatWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatFor}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatFor(TigerParser.StatForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatFor}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatFor(TigerParser.StatForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatFunctionCall}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatFunctionCall(TigerParser.StatFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatFunctionCall}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatFunctionCall(TigerParser.StatFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatBreak}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatBreak(TigerParser.StatBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatBreak}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatBreak(TigerParser.StatBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatReturn}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatReturn(TigerParser.StatReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatReturn}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatReturn(TigerParser.StatReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatLet}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatLet(TigerParser.StatLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatLet}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatLet(TigerParser.StatLetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#opt_return}.
	 * @param ctx the parse tree
	 */
	void enterOpt_return(TigerParser.Opt_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#opt_return}.
	 * @param ctx the parse tree
	 */
	void exitOpt_return(TigerParser.Opt_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#opt_prefix}.
	 * @param ctx the parse tree
	 */
	void enterOpt_prefix(TigerParser.Opt_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#opt_prefix}.
	 * @param ctx the parse tree
	 */
	void exitOpt_prefix(TigerParser.Opt_prefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(TigerParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(TigerParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(TigerParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(TigerParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPow(TigerParser.ExprPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPow(TigerParser.ExprPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExporOr}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExporOr(TigerParser.ExporOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExporOr}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExporOr(TigerParser.ExporOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(TigerParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(TigerParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprValue(TigerParser.ExprValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprValue(TigerParser.ExprValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprComp}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprComp(TigerParser.ExprCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComp}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprComp(TigerParser.ExprCompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(TigerParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(TigerParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprConstant}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprConstant(TigerParser.ExprConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprConstant}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprConstant(TigerParser.ExprConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantIntLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstantIntLit(TigerParser.ConstantIntLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantIntLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstantIntLit(TigerParser.ConstantIntLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantFloatLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstantFloatLit(TigerParser.ConstantFloatLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantFloatLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstantFloatLit(TigerParser.ConstantFloatLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(TigerParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(TigerParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(TigerParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(TigerParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TigerParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TigerParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#value_tail}.
	 * @param ctx the parse tree
	 */
	void enterValue_tail(TigerParser.Value_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#value_tail}.
	 * @param ctx the parse tree
	 */
	void exitValue_tail(TigerParser.Value_tailContext ctx);
}