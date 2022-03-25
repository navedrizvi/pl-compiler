.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -12
# end of prologue
li $t0, 1
sw $t0, 0($sp)
li $t0, 2
sw $t0, 8($sp)
li $t0, 3
sw $t0, 4($sp)
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t0, 4($sp)
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
