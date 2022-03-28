.data
newline: .asciiz "\n"
_0_a: .word 0, 0, 0
_0_b: .word 0, 0, 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -44
# end of prologue
li $t0, 14
la $t1, _0_b
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
li $t0, 7
la $t1, _0_a
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
addi $t1, $t1, 4
sw $t0, ($t1)
la $t0, _0_a
addi $t0, $t0, 0
lw $t1, ($t0)
sw $t1, 0($sp)
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_a
addi $t0, $t0, 4
lw $t1, ($t0)
sw $t1, 4($sp)
li $v0, 1
lw $t0, 4($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_a
addi $t0, $t0, 8
lw $t1, ($t0)
sw $t1, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_b
addi $t0, $t0, 0
lw $t1, ($t0)
sw $t1, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_b
addi $t0, $t0, 4
lw $t1, ($t0)
sw $t1, 16($sp)
li $v0, 1
lw $t0, 16($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_b
addi $t0, $t0, 8
lw $t1, ($t0)
sw $t1, 20($sp)
li $v0, 1
lw $t0, 20($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
la $t0, _0_b
la $t1, _0_a
lw $t2, ($t1)
sw $t2, ($t0)
addi $t1, $t1, 4
addi $t0, $t0, 4
lw $t2, ($t1)
sw $t2, ($t0)
addi $t1, $t1, 4
addi $t0, $t0, 4
lw $t2, ($t1)
sw $t2, ($t0)
la $t0, _0_b
addi $t0, $t0, 0
lw $t1, ($t0)
sw $t1, 24($sp)
la $t0, _0_b
addi $t0, $t0, 4
lw $t1, ($t0)
sw $t1, 28($sp)
lw $t0, 24($sp)
lw $t1, 28($sp)
lw $t2, 32($sp)
add $t2, $t0, $t1
sw $t2, 32($sp)
la $t0, _0_b
addi $t0, $t0, 8
lw $t1, ($t0)
sw $t1, 36($sp)
lw $t0, 32($sp)
lw $t1, 36($sp)
lw $t2, 40($sp)
add $t2, $t0, $t1
sw $t2, 40($sp)
li $v0, 1
lw $t0, 40($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 44
# end of epilogue
li $v0, 0
jr $ra
