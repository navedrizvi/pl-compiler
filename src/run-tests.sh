set -v

javac Tiger*.java

# java Tiger -i ../phase2_test_files_v1/semantic/err_undefined_var.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_undefined_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_undefined_function.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_redefine_var.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_redefine_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_redefine_func.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_storage_class_global_var.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_storage_class_local_static.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_assign_array_size.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_assign_array_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_assign_narrowing_return.tiger  --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_assign_narrowing.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_power_op_float.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_relational_associate.tiger  --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_relational_mixed.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_conditional_array.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_conditional_float.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_break_outside_loop.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_while_expr_array.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_while_expr_float.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_call_array_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_no_return.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_return_array.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_return_proc.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_return_void.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_array_add.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_array_index_array.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_array_index_float.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_array_without_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_for_exp_float.tiger --ir

# java Tiger -i ../phase2_test_files_v1/semantic/err_func_call_narrowing.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_call_too_few_args.tiger --ir
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_call_too_many_args.tiger --ir
java Tiger -i ../phase2_test_files_v1/semantic/err_func_return_narrowing.tiger --ir
