.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -144
# end of prologue
li $t0, 1
sw $t0, 16($sp)
li $t0, 2
sw $t0, 12($sp)
li $t0, 3
sw $t0, 8($sp)
li $t0, 4
sw $t0, 4($sp)
li $t0, 0
sw $t0, 20($sp)
lw $t0, 16($sp)
lw $t1, 12($sp)
ble $t0, $t1, _L0
li $t0, 1
sw $t0, 20($sp)
li $t0, 0
sw $t0, 24($sp)
lw $t0, 16($sp)
lw $t1, 8($sp)
ble $t0, $t1, _L2
li $t0, 1
sw $t0, 24($sp)
li $t0, 1
sw $t0, 0($sp)
j _L3
_L2:
li $t0, 2
sw $t0, 0($sp)
_L3:
_L0:
li $t0, 0
sw $t0, 28($sp)
lw $t0, 16($sp)
lw $t1, 8($sp)
bge $t0, $t1, _L4
li $t0, 1
sw $t0, 28($sp)
li $t0, 0
sw $t0, 32($sp)
lw $t0, 16($sp)
lw $t1, 4($sp)
blt $t0, $t1, _L6
li $t0, 1
sw $t0, 32($sp)
li $t0, 4
sw $t0, 0($sp)
j _L7
_L6:
li $t0, 8
sw $t0, 0($sp)
_L7:
j _L5
_L4:
li $t0, 16
sw $t0, 0($sp)
_L5:
_L1:
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 144
# end of epilogue
li $v0, 0
jr $ra
