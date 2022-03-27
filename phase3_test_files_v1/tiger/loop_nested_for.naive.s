.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -40
# end of prologue
li $t0, 1
sw $t0, 4($sp)
_L0:
lw $t0, 4($sp)
li $t1, 4
bgt $t0, $t1, _L1
li $t0, 1
sw $t0, 0($sp)
_L2:
lw $t0, 0($sp)
li $t1, 2
bgt $t0, $t1, _L3
lw $t0, 4($sp)
lw $t1, 0($sp)
lw $t2, 8($sp)
mul $t2, $t0, $t1
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
lw $t2, 0($sp)
add $t2, $t0, $t1
sw $t2, 0($sp)
j _L2
_L3:
lw $t0, 4($sp)
li $t1, 1
lw $t2, 4($sp)
add $t2, $t0, $t1
sw $t2, 4($sp)
j _L0
_L1:
# start of epilogue
addiu $sp, $sp, 40
# end of epilogue
li $v0, 0
jr $ra
