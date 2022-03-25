.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -12
# end of prologue
li $t0, 4
sw $t0, 0($sp)
li $t0, 6
sw $t0, 4($sp)
li $t0, 6
sw $t0, 8($sp)
li $t0, 5
sw $t0, 8($sp)
li $v0, 1
lw $t1, 0($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t1, 8($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t1, 4($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 12
# end of epilogue
li $v0, 0
jr $ra
