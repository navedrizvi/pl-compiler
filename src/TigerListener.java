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
	 * Enter a parse tree produced by {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TigerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TigerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBase_type(TigerParser.Base_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBase_type(TigerParser.Base_typeContext ctx);
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
	 * Enter a parse tree produced by {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void enterStorage_class(TigerParser.Storage_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#storage_class}.
	 * @param ctx the parse tree
	 */
	void exitStorage_class(TigerParser.Storage_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(TigerParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(TigerParser.Id_listContext ctx);
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
	 * Enter a parse tree produced by {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void enterStat_seq(TigerParser.Stat_seqContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#stat_seq}.
	 * @param ctx the parse tree
	 */
	void exitStat_seq(TigerParser.Stat_seqContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(TigerParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(TigerParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(TigerParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link TigerParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(TigerParser.ConstantContext ctx);
}