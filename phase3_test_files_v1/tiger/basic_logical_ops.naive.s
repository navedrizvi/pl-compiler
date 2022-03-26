.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -84
# end of prologue
li $t0, 1
sw $t0, 0($sp)
lw $t0, 0($sp)
li $t1, 0
lw $t2, 4($sp)
or $t2, $t0, $t1
sw $t2, 4($sp)
li $v0, 1
lw $t0, 4($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
li $t1, 0
lw $t2, 8($sp)
and $t2, $t0, $t1
sw $t2, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
li $t1, 1
lw $t2, 12($sp)
or $t2, $t0, $t1
sw $t2, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
li $t1, 1
lw $t2, 16($sp)
and $t2, $t0, $t1
sw $t2, 16($sp)
li $v0, 1
lw $t0, 16($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 1
li $t1, 0
lw $t2, 20($sp)
and $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 20($sp)
li $t1, 1
lw $t2, 24($sp)
or $t2, $t0, $t1
sw $t2, 24($sp)
li $v0, 1
lw $t0, 24($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 84
# end of epilogue
li $v0, 0
jr $ra
