.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -84
# end of prologue
li $t0, 1
sw $t0, 4($sp)
_L0:
lw $t0, 4($sp)
li $t1, 5
bgt $t0, $t1, _L1
li $t0, 5
sw $t0, 0($sp)
_L2:
li $t0, 0
sw $t0, 8($sp)
lw $t0, 0($sp)
li $t1, 0
ble $t0, $t1, _L3
li $t0, 1
sw $t0, 8($sp)
li $t0, 0
sw $t0, 12($sp)
lw $t0, 4($sp)
lw $t1, 0($sp)
bne $t0, $t1, _L4
li $t0, 1
sw $t0, 12($sp)
j _L5
_L4:
lw $t0, 4($sp)
lw $t1, 0($sp)
lw $t2, 16($sp)
mul $t2, $t0, $t1
sw $t2, 16($sp)
li $v0, 1
lw $t0, 16($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
li $t1, 1
lw $t2, 20($sp)
sub $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 20($sp)
sw $t0, 0($sp)
j _L2
_L3:
_L5:
lw $t0, 4($sp)
li $t1, 1
lw $t2, 4($sp)
add $t2, $t0, $t1
sw $t2, 4($sp)
j _L0
_L1:
# start of epilogue
addiu $sp, $sp, 84
# end of epilogue
li $v0, 0
jr $ra
