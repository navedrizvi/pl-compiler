.data
newline: .asciiz "\n"
_0_a: .word 0, 0, 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -12
# end of prologue
li $t0, 20
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
# start of epilogue
addiu $sp, $sp, 12
# end of epilogue
li $v0, 0
jr $ra
