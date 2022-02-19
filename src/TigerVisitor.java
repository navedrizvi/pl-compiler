// Generated from Tiger.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TigerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TigerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TigerParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(TigerParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#decl_seg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_seg(TigerParser.Decl_segContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#type_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_decl_list(TigerParser.Type_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#var_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl_list(TigerParser.Var_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#funct_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunct_list(TigerParser.Funct_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_decl(TigerParser.Type_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBaseType}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBaseType(TigerParser.TypeBaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeArray}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArray(TigerParser.TypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeID}
	 * labeled alternative in {@link TigerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeID(TigerParser.TypeIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeInt}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeInt(TigerParser.BaseTypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeFloat}
	 * labeled alternative in {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeFloat(TigerParser.BaseTypeFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(TigerParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StorageClassVar}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClassVar(TigerParser.StorageClassVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StorageClassStatic}
	 * labeled alternative in {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClassStatic(TigerParser.StorageClassStaticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdListId}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdListId(TigerParser.IdListIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdList}
	 * labeled alternative in {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(TigerParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#optional_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptional_init(TigerParser.Optional_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#funct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunct(TigerParser.FunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(TigerParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#param_list_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list_tail(TigerParser.Param_list_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(TigerParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(TigerParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatSingle}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatSingle(TigerParser.StatSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatSeq}
	 * labeled alternative in {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatSeq(TigerParser.StatSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(TigerParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatIf}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIf(TigerParser.StatIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatIfElse}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatIfElse(TigerParser.StatIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatWhile}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatWhile(TigerParser.StatWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatFor}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatFor(TigerParser.StatForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatFunctionCall}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatFunctionCall(TigerParser.StatFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatBreak}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatBreak(TigerParser.StatBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatReturn}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatReturn(TigerParser.StatReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatLet}
	 * labeled alternative in {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatLet(TigerParser.StatLetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#opt_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt_return(TigerParser.Opt_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#opt_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpt_prefix(TigerParser.Opt_prefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(TigerParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(TigerParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprPow}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprPow(TigerParser.ExprPowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExporOr}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExporOr(TigerParser.ExporOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(TigerParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprValue}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprValue(TigerParser.ExprValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprComp}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComp(TigerParser.ExprCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDiv(TigerParser.ExprMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprConstant}
	 * labeled alternative in {@link TigerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprConstant(TigerParser.ExprConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantIntLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantIntLit(TigerParser.ConstantIntLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantFloatLit}
	 * labeled alternative in {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantFloatLit(TigerParser.ConstantFloatLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(TigerParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list_tail(TigerParser.Expr_list_tailContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(TigerParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TigerParser#value_tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_tail(TigerParser.Value_tailContext ctx);
}