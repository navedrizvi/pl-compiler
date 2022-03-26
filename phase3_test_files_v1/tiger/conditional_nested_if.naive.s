.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -480
# end of prologue
li $t0, 1
sw $t0, 20($sp)
li $t0, 2
sw $t0, 16($sp)
li $t0, 3
sw $t0, 12($sp)
li $t0, 4
sw $t0, 8($sp)
li $t0, 5
sw $t0, 4($sp)
li $t0, 0
sw $t0, 0($sp)
li $t0, 0
sw $t0, 24($sp)
lw $t0, 20($sp)
lw $t1, 16($sp)
bge $t0, $t1, _L0
li $t0, 1
sw $t0, 24($sp)
lw $t0, 0($sp)
li $t1, 1
lw $t2, 28($sp)
add $t2, $t0, $t1
sw $t2, 28($sp)
lw $t0, 28($sp)
sw $t0, 0($sp)
li $t0, 0
sw $t0, 32($sp)
lw $t0, 20($sp)
lw $t1, 12($sp)
bge $t0, $t1, _L1
li $t0, 1
sw $t0, 32($sp)
lw $t0, 0($sp)
li $t1, 2
lw $t2, 36($sp)
add $t2, $t0, $t1
sw $t2, 36($sp)
lw $t0, 36($sp)
sw $t0, 0($sp)
li $t0, 0
sw $t0, 40($sp)
lw $t0, 20($sp)
lw $t1, 8($sp)
bge $t0, $t1, _L2
li $t0, 1
sw $t0, 40($sp)
lw $t0, 0($sp)
li $t1, 4
lw $t2, 44($sp)
add $t2, $t0, $t1
sw $t2, 44($sp)
lw $t0, 44($sp)
sw $t0, 0($sp)
_L2:
_L1:
li $t0, 0
sw $t0, 48($sp)
lw $t0, 20($sp)
lw $t1, 4($sp)
ble $t0, $t1, _L3
li $t0, 1
sw $t0, 48($sp)
lw $t0, 0($sp)
li $t1, 8
lw $t2, 52($sp)
add $t2, $t0, $t1
sw $t2, 52($sp)
lw $t0, 52($sp)
sw $t0, 0($sp)
li $t0, 0
sw $t0, 56($sp)
lw $t0, 20($sp)
lw $t1, 8($sp)
bge $t0, $t1, _L4
li $t0, 1
sw $t0, 56($sp)
lw $t0, 0($sp)
li $t1, 16
lw $t2, 60($sp)
add $t2, $t0, $t1
sw $t2, 60($sp)
lw $t0, 60($sp)
sw $t0, 0($sp)
_L4:
_L3:
_L0:
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 480
# end of epilogue
li $v0, 0
jr $ra
