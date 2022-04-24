set -v

# javac Tiger*.java

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
# java Tiger -i ../phase2_test_files_v1/semantic/err_func_return_narrowing.tiger --ir


# java Tiger -i ../phase2_test_files_v1/tiger/ --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_combo_ops.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_local.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_local_assign.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_local_index.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_local_init.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_static.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_static_assign.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_static_index.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/array_static_init.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_assign.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_init.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_logical_ops.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_logical_relational_combo.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_math.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_math_combo.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_math_power_op.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_relational_ops.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_scope_hiding.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_scope_nested.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_static_assign.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_static_init.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/basic_type_of_type.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/conditional_if.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/conditional_if_else.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/conditional_nested_if.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/conditional_nested_if_else.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_fib.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_jacobi.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_matrix.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_motor.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_priority_queue.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_prng.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_selection_sort.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_slope.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_square_root.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/demo_tak.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_assign.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_init.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_math.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_math_combo.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_math_mixed.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/float_math_power_op.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_call_1_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_call_4_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_call_8_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_call_chain.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_call_void_ret.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_recursive_1_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_recursive_6_arg.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/function_static_global.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/lib_call_exit.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/lib_call_not.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/lib_call_printf.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/lib_call_printi.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_break.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_for.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_nested_break.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_nested_for.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_nested_while.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/loop_while.tiger --ir
# java Tiger -i ../phase2_test_files_v1/tiger/print_example.tiger --ir






# 4.1) demo_selection_sort (Manually Graded) (0.0/0.0)
# 4.5) demo_prng (Manually Graded) (0.0/0.0)
# 4.8) demo_matrix (Manually Graded) (0.0/0.0)
# 4.9) demo_jacobi (Manually Graded) (0.0/0.0)



# TODO FLOATS: 
# 4.2) demo_slope
# 4.4) demo_square_root
# 4.6) demo_motor (Manually Graded) (0.0/0.0)


# 4.3) demo_fib
# 4.7) demo_priority_queue: NOT float related. dk whatsup
# 4.10) demo_tak: NOT float related. this uses the -g






# TODO LIMITS: 
# 5.4) Allocation with Limit: demo_square_root --limit 4 (Manually Graded) (0.0/0.0)
# 5.3) Allocation with Limit: demo_fib --limit 4 (Manually Graded) (0.0/0.0)


# 5.1) Allocation with Limit: demo_selection_sort --limit 4 (Manually Graded) (0.0/0.0)
# 5.2) Allocation with Limit: demo_slope --limit 4 (Manually Graded) (0.0/0.0)
# 5.5) Allocation with Limit: demo_prng --limit 4 (Manually Graded) (0.0/0.0)
# 5.6) Allocation with Limit: demo_motor --limit 4 (Manually Graded) (0.0/0.0)
# 5.7) Allocation with Limit: demo_priority_queue --limit 4 (Manually Graded) (0.0/0.0)
# 5.8) Allocation with Limit: demo_matrix --limit 4 (Manually Graded) (0.0/0.0)
# 5.9) Allocation with Limit: demo_jacobi --limit 4 (Manually Graded) (0.0/0.0)
# 5.10) Allocation with Limit: demo_tak --limit 4 (Manually Graded) (0.0/0.0)

make clean
make
cd cs8803_bin

TEST=demo_square_root
ALLOCATOR=-b # can be -g, -b, -n
java -jar tigerc.jar -r ../phase3_test_files_v1/ir/$TEST.ir -i ../phase3_test_files_v1/tiger/$TEST.tiger  --limit 4 --ir $ALLOCATOR --mips