.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -24
# end of prologue
li $t0, 5
sw $t0, 0($sp)
li $t1, 12
sw $t1, 4($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
lw $t2, 8($sp)
add $t2, $t0, $t1
sw $t2, 8($sp)
lw $t0, 8($sp)
sw $t0, 4($sp)
lw $t1, 4($sp)
li $t0, 3
lw $t2, 12($sp)
add $t2, $t1, $t0
sw $t2, 12($sp)
lw $t1, 12($sp)
sw $t1, 0($sp)
li $v0, 1
lw $t0, 0($sp)
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
