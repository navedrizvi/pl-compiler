.data
newline: .asciiz "\n"
_0_a: .word 0, 0, 0
.text
.globl main
reset:
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
li $t0, 12
sw $t0, 52($sp)
sw $t0, 56($sp)
sw $t0, 60($sp)
li $t0, 11
sw $t0, 52($sp)
li $t0, 13
sw $t0, 60($sp)
la $t0, _0_a
lw $t1, 52($sp)
sw $t1, ($t0)
lw $t1, 56($sp)
addi $t0, $t0, 4
sw $t1, ($t0)
lw $t1, 60($sp)
addi $t0, $t0, 4
sw $t1, ($t0)
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
main:
# start of prologue
addiu $sp, $sp, -80
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
li $t0, 5
la $t1, _0_a
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
la $t0, _0_a
li $t1, 15
addi $t0, $t0, 0
sw $t1, ($t0)
la $t1, _0_a
addi $t1, $t1, 0
lw $t0, ($t1)
sw $t0, 56($sp)
lw $t1, 56($sp)
sw $t1, 52($sp)
li $v0, 1
lw $t1, 52($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
jal reset
li $v0, 1
lw $t1, 52($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
la $t1, _0_a
addi $t1, $t1, 0
lw $t0, ($t1)
sw $t0, 60($sp)
la $t1, _0_a
addi $t1, $t1, 4
lw $t0, ($t1)
sw $t0, 64($sp)
lw $t1, 60($sp)
lw $t0, 64($sp)
lw $t2, 68($sp)
add $t2, $t1, $t0
sw $t2, 68($sp)
la $t1, _0_a
addi $t1, $t1, 8
lw $t0, ($t1)
sw $t0, 72($sp)
lw $t1, 68($sp)
lw $t0, 72($sp)
lw $t2, 76($sp)
add $t2, $t1, $t0
sw $t2, 76($sp)
li $v0, 1
lw $t1, 76($sp)
move $a0, $t1
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
addiu $sp, $sp, 80
# end of epilogue
jr $ra
