.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -840
# end of prologue
li $t0, 1
sw $t0, 0($sp)
li $t0, 2
sw $t0, 4($sp)
li $t0, 3
sw $t0, 8($sp)
li $t0, 0
sw $t0, 12($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
bgt $t0, $t1, _L0
li $t0, 1
sw $t0, 12($sp)
_L0:
li $t0, 0
sw $t0, 16($sp)
lw $t0, 12($sp)
lw $t1, 8($sp)
bgt $t0, $t1, _L1
li $t0, 1
sw $t0, 16($sp)
_L1:
li $v0, 1
lw $t0, 16($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 20($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
beq $t0, $t1, _L2
li $t0, 1
sw $t0, 20($sp)
_L2:
li $t0, 0
sw $t0, 24($sp)
lw $t0, 8($sp)
lw $t1, 0($sp)
blt $t0, $t1, _L3
li $t0, 1
sw $t0, 24($sp)
_L3:
lw $t0, 20($sp)
lw $t1, 24($sp)
lw $t2, 28($sp)
or $t2, $t0, $t1
sw $t2, 28($sp)
li $v0, 1
lw $t0, 28($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 32($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
bge $t0, $t1, _L4
li $t0, 1
sw $t0, 32($sp)
_L4:
lw $t0, 32($sp)
lw $t1, 8($sp)
lw $t2, 36($sp)
and $t2, $t0, $t1
sw $t2, 36($sp)
li $v0, 1
lw $t0, 36($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 40($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
bge $t0, $t1, _L5
li $t0, 1
sw $t0, 40($sp)
_L5:
li $t0, 0
sw $t0, 44($sp)
lw $t0, 8($sp)
lw $t1, 4($sp)
ble $t0, $t1, _L6
li $t0, 1
sw $t0, 44($sp)
_L6:
lw $t0, 40($sp)
lw $t1, 44($sp)
lw $t2, 48($sp)
and $t2, $t0, $t1
sw $t2, 48($sp)
li $v0, 1
lw $t0, 48($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 52($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
ble $t0, $t1, _L7
li $t0, 1
sw $t0, 52($sp)
_L7:
li $t0, 0
sw $t0, 56($sp)
lw $t0, 0($sp)
lw $t1, 8($sp)
bge $t0, $t1, _L8
li $t0, 1
sw $t0, 56($sp)
_L8:
lw $t0, 52($sp)
lw $t1, 56($sp)
lw $t2, 60($sp)
or $t2, $t0, $t1
sw $t2, 60($sp)
li $v0, 1
lw $t0, 60($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 64($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
ble $t0, $t1, _L9
li $t0, 1
sw $t0, 64($sp)
_L9:
li $t0, 0
sw $t0, 68($sp)
lw $t0, 4($sp)
lw $t1, 8($sp)
ble $t0, $t1, _L10
li $t0, 1
sw $t0, 68($sp)
_L10:
lw $t0, 64($sp)
lw $t1, 68($sp)
lw $t2, 72($sp)
and $t2, $t0, $t1
sw $t2, 72($sp)
li $t0, 0
sw $t0, 76($sp)
lw $t0, 8($sp)
li $t1, 4
bge $t0, $t1, _L11
li $t0, 1
sw $t0, 76($sp)
_L11:
lw $t0, 72($sp)
lw $t1, 76($sp)
lw $t2, 80($sp)
or $t2, $t0, $t1
sw $t2, 80($sp)
li $v0, 1
lw $t0, 80($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 840
# end of epilogue
li $v0, 0
jr $ra
