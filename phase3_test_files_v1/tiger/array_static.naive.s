.data
newline: .asciiz "\n"
_0_a: .word 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -24
# end of prologue
li $t0, 15
la $t1, _0_a
addi $t1, $t1, 0
sw $t0, ($t1)
li $t0, 25
la $t1, _0_a
addi $t1, $t1, 4
sw $t0, ($t1)
la $t0, _0_a
addi $t0, $t0, 0
lw $t1, ($t0)
sw $t1, 0($sp)
la $t0, _0_a
addi $t0, $t0, 4
lw $t1, ($t0)
sw $t1, 4($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
lw $t2, 8($sp)
add $t2, $t0, $t1
sw $t2, 8($sp)
lw $t0, 8($sp)
la $t1, _0_a
addi $t1, $t1, 8
sw $t0, ($t1)
la $t0, _0_a
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
la $t0, _0_a
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
la $t0, _0_a
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
# start of epilogue
addiu $sp, $sp, 24
# end of epilogue
li $v0, 0
jr $ra
