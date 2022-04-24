set -v


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


# 4.6) Allocation: demo_motor (Manually Graded) (0.0/0.0)
# 4.2) Allocation: demo_slope (Manually Graded) (0.0/0.0)
# 4.8) Allocation: demo_matrix (Manually Graded) (0.0/0.0)
# 4.9) Allocation: demo_jacobi (Manually Graded) (0.0/0.0)
# 5.6) Allocation with Limit: demo_motor --limit 4 (Manually Graded) (0.0/0.0)
# 5.8) Allocation with Limit: demo_matrix --limit 4 (Manually Graded) (0.0/0.0)
# 5.9) Allocation with Limit: demo_jacobi --limit 4 (Manually Graded) (0.0/0.0)




# ####################3
# n-passed:
# 3.4) Benchmark: benchmark4 (Manually Graded) (0.0/0.0)
# 4.4) Allocation: demo_square_root (Manually Graded) (0.0/0.0)
# 5.4) Allocation with Limit: demo_square_root --limit 4 (Manually Graded) (0.0/0.0)

# i-passed:
# 4.3) Allocation: demo_fib (Manually Graded) (0.0/0.0)
# 4.5) Allocation: demo_prng (Manually Graded) (0.0/0.0)
# 4.10) Allocation: demo_tak (Manually Graded) (0.0/0.0)
# 5.3) Allocation with Limit: demo_fib --limit 4 (Manually Graded) (0.0/0.0)
# 5.5) Allocation with Limit: demo_prng --limit 4 (Manually Graded) (0.0/0.0)
# ####################3

# ignoring:
# 4.7) Allocation: demo_priority_queue (Manually Graded) (0.0/0.0)
# 5.7) Allocation with Limit: demo_priority_queue --limit 4 (Manually Graded) (0.0/0.0)


# 5.2) Allocation with Limit: demo_slope --limit 4 (Manually Graded) (0.0/0.0)


# Li float-issue:
    # Demo_slope + limit
    # Demo_matrix + limit

# No more registers:
    # Benchmark4
    # Motor + limit
    # Jacobi + limit
    # Square_root + limit



make clean
make
cd cs8803_bin


# TEST=demo_fib
# TEST=demo_square_root
TEST=demo_slope
# TEST=demo_motor
ALLOCATOR=-n # can be -g, -b, -n
# ALLOCATOR=-n # can be -g, -b, -n
# java -jar tigerc.jar -r ../phase3_test_files_v1/ir/$TEST.ir -i ../phase3_test_files_v1/tiger/$TEST.tiger  --limit 4 --ir $ALLOCATOR --mips
# java -jar tigerc.jar -r ../phase3_test_files_v1/ir/$TEST.ir -i ../phase3_test_files_v1/tiger/$TEST.tiger  --ir $ALLOCATOR --mips
java -jar tigerc.jar -r ../phase3_test_files_v1/ir/$TEST.ir -i ../phase3_test_files_v1/tiger/$TEST.tiger  --ir $ALLOCATOR --mips --limit 4
