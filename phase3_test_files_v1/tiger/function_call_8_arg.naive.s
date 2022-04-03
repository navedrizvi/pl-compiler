.data
newline: .asciiz "\n"
.text
.globl main
sum:
# start of prologue
addiu $sp, $sp, -112
# end of prologue
sw $a0, 52($sp)
sw $a1, 56($sp)
sw $a2, 60($sp)
sw $a3, 64($sp)
lw $t0, 128($sp)
sw $t0, 68($sp)
lw $t0, 132($sp)
sw $t0, 72($sp)
lw $t0, 136($sp)
sw $t0, 76($sp)
lw $t0, 140($sp)
sw $t0, 80($sp)
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
lw $t0, 52($sp)
lw $t1, 56($sp)
lw $t2, 84($sp)
add $t2, $t0, $t1
sw $t2, 84($sp)
lw $t0, 84($sp)
lw $t1, 60($sp)
lw $t2, 88($sp)
add $t2, $t0, $t1
sw $t2, 88($sp)
lw $t0, 88($sp)
lw $t1, 64($sp)
lw $t2, 92($sp)
add $t2, $t0, $t1
sw $t2, 92($sp)
lw $t0, 92($sp)
lw $t1, 68($sp)
lw $t2, 96($sp)
add $t2, $t0, $t1
sw $t2, 96($sp)
lw $t0, 96($sp)
lw $t1, 72($sp)
lw $t2, 100($sp)
add $t2, $t0, $t1
sw $t2, 100($sp)
lw $t0, 100($sp)
lw $t1, 76($sp)
lw $t2, 104($sp)
add $t2, $t0, $t1
sw $t2, 104($sp)
lw $t0, 104($sp)
lw $t1, 80($sp)
lw $t2, 108($sp)
add $t2, $t0, $t1
sw $t2, 108($sp)
lw $v0, 108($sp)
# start of epilogue
lw $s0, 16($sp)
lw $s1, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s4, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 112
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -72
# end of prologue
sw $s0, 32($sp)
sw $s1, 36($sp)
sw $s2, 40($sp)
sw $s3, 44($sp)
sw $s4, 48($sp)
sw $s5, 52($sp)
sw $s6, 56($sp)
sw $s7, 60($sp)
sw $ra, 64($sp)
li $a0, 1
li $a1, 2
li $a2, 3
li $a3, 4
li $t0, 5
sw $t0, 16($sp)
li $t0, 6
sw $t0, 20($sp)
li $t0, 7
sw $t0, 24($sp)
li $t0, 8
sw $t0, 28($sp)
jal sum
sw $v0, 68($sp)
li $v0, 1
lw $t0, 68($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
lw $s0, 32($sp)
lw $s1, 36($sp)
lw $s2, 40($sp)
lw $s3, 44($sp)
lw $s4, 48($sp)
lw $s5, 52($sp)
lw $s6, 56($sp)
lw $s7, 60($sp)
lw $ra, 64($sp)
addiu $sp, $sp, 72
# end of epilogue
jr $ra
