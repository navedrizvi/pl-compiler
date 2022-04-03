.data
newline: .asciiz "\n"
.text
.globl main
sum:
# start of prologue
addiu $sp, $sp, -80
# end of prologue
sw $a0, 0($sp)
sw $a1, 4($sp)
sw $a2, 8($sp)
sw $a3, 12($sp)
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
lw $t2, 16($sp)
add $t2, $t0, $t1
sw $t2, 16($sp)
lw $t0, 16($sp)
lw $t1, 8($sp)
lw $t2, 20($sp)
add $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 20($sp)
lw $t1, 12($sp)
lw $t2, 24($sp)
add $t2, $t0, $t1
sw $t2, 24($sp)
lw $v0, 24($sp)
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
addiu $sp, $sp, 80
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -56
# end of prologue
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
li $a0, 1
li $a1, 2
li $a2, 3
li $a3, 4
jal sum
sw $v0, 0($sp)
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
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
addiu $sp, $sp, 56
# end of epilogue
jr $ra
