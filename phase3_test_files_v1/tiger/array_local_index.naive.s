.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -40
# end of prologue
li $t0, 0
sw $t0, 20($sp)
_L0:
lw $t0, 20($sp)
li $t1, 4
bgt $t0, $t1, _L1
lw $t0, 20($sp)
lw $t1, 20($sp)
lw $t2, 24($sp)
mul $t2, $t0, $t1
sw $t2, 24($sp)
move $t0, $sp
addiu $t0, $t0, 0
lw $t1, 20($sp)
li $t2, 4
mul $t2, $t1, $t2
addu $t0, $t0, $t2
lw $t3, 24($sp)
sw $t3, 0($t0)
lw $t0, 20($sp)
li $t1, 1
lw $t2, 20($sp)
add $t2, $t0, $t1
sw $t2, 20($sp)
j _L0
_L1:
li $t0, 0
sw $t0, 20($sp)
_L2:
lw $t0, 20($sp)
li $t1, 4
bgt $t0, $t1, _L3
move $t0, $sp
addiu $t0, $t0, 0
lw $t1, 20($sp)
li $t2, 4
mul $t2, $t1, $t2
addu $t0, $t0, $t2
lw $t3, 32($sp)
lw $t3, 0($t0)
sw $t3, 32($sp)
li $v0, 1
lw $t0, 32($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 20($sp)
li $t1, 1
lw $t2, 20($sp)
add $t2, $t0, $t1
sw $t2, 20($sp)
j _L2
_L3:
# start of epilogue
addiu $sp, $sp, 40
# end of epilogue
li $v0, 0
jr $ra
