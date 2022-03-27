.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -60
# end of prologue
li $t0, 1
sw $t0, 0($sp)
_L0:
lw $t0, 0($sp)
li $t1, 4
bgt $t0, $t1, _L1
li $t0, 1
sw $t0, 4($sp)
lw $t0, 0($sp)
lw $t1, 0($sp)
lw $t2, 8($sp)
mul $t2, $t0, $t1
sw $t2, 8($sp)
lw $t0, 8($sp)
lw $t1, 4($sp)
lw $t2, 12($sp)
mul $t2, $t0, $t1
sw $t2, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 4($sp)
li $t1, 1
lw $t2, 16($sp)
add $t2, $t0, $t1
sw $t2, 16($sp)
lw $t0, 16($sp)
sw $t0, 4($sp)
lw $t0, 0($sp)
li $t1, 1
lw $t2, 0($sp)
add $t2, $t0, $t1
sw $t2, 0($sp)
j _L0
_L1:
# start of epilogue
addiu $sp, $sp, 60
# end of epilogue
li $v0, 0
jr $ra
