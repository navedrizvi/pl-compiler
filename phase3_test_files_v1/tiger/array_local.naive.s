.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -36
# end of prologue
lw $t0, 0($sp)
li $t1, 10
sw $t1, 0($sp)
lw $t0, 0($sp)
li $t1, 20
sw $t1, 4($sp)
lw $t0, 12($sp)
lw $t1, 0($sp)
lw $t0, 0($sp)
sw $t0, 12($sp)
lw $t0, 16($sp)
lw $t1, 0($sp)
lw $t0, 4($sp)
sw $t0, 16($sp)
lw $t0, 12($sp)
lw $t1, 16($sp)
lw $t2, 20($sp)
add $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 0($sp)
lw $t1, 20($sp)
sw $t1, 8($sp)
lw $t0, 24($sp)
lw $t1, 0($sp)
lw $t0, 0($sp)
sw $t0, 24($sp)
li $v0, 1
lw $t0, 24($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 28($sp)
lw $t1, 0($sp)
lw $t0, 4($sp)
sw $t0, 28($sp)
li $v0, 1
lw $t0, 28($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 32($sp)
lw $t1, 0($sp)
lw $t0, 8($sp)
sw $t0, 32($sp)
li $v0, 1
lw $t0, 32($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 36
# end of epilogue
li $v0, 0
jr $ra

jr $ra
