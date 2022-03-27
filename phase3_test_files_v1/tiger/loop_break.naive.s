.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -84
# end of prologue
li $t0, 4
sw $t0, 0($sp)
assign:
_L0:
lw $t0, 4($sp)
li $t1, 10
bgt $t0, $t1, _L1
li $v0, 1
lw $t0, 4($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 8($sp)
lw $t0, 4($sp)
lw $t1, 0($sp)
bne $t0, $t1, _L2
li $t0, 1
sw $t0, 8($sp)
j _L3
_L2:
lw $t0, 4($sp)
li $t1, 1
lw $t2, 4($sp)
add $t2, $t0, $t1
sw $t2, 4($sp)
j _L0
_L1:
_L3:
li $t0, 10
sw $t0, 4($sp)
_L4:
li $t0, 0
sw $t0, 16($sp)
lw $t0, 4($sp)
li $t1, 0
ble $t0, $t1, _L5
li $t0, 1
sw $t0, 16($sp)
li $v0, 1
lw $t0, 4($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 20($sp)
lw $t0, 4($sp)
lw $t1, 0($sp)
bne $t0, $t1, _L6
li $t0, 1
sw $t0, 20($sp)
j _L7
_L6:
lw $t0, 4($sp)
li $t1, 1
lw $t2, 24($sp)
sub $t2, $t0, $t1
sw $t2, 24($sp)
lw $t0, 24($sp)
sw $t0, 4($sp)
j _L4
_L5:
_L7:
# start of epilogue
addiu $sp, $sp, 84
# end of epilogue
li $v0, 0
jr $ra
