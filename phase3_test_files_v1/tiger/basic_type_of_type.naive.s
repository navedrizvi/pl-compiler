.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -24
# end of prologue
li $t0, 7
sw $t0, 0($sp)
li $t0, 10
sw $t0, 4($sp)
lw $t0, 0($sp)
lw $t3, 4($sp)
lw $t4, 12($sp)
add $t4, $t0, $t3
sw $t4, 12($sp)
lw $t0, 12($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
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
