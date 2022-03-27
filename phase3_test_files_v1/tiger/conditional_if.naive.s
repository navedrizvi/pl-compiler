.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -544
# end of prologue
li $t0, 1
sw $t0, 0($sp)
li $t0, 0
sw $t0, 4($sp)
lw $t0, 0($sp)
li $t1, 0
ble $t0, $t1, _L0
li $t0, 1
sw $t0, 4($sp)
li $v0, 1
li $a0, 1
syscall
li $v0, 4
la $a0, newline
syscall
_L0:
li $t0, 0
sw $t0, 8($sp)
lw $t0, 0($sp)
li $t1, 1
ble $t0, $t1, _L1
li $t0, 1
sw $t0, 8($sp)
li $v0, 1
li $a0, 2
syscall
li $v0, 4
la $a0, newline
syscall
_L1:
li $t0, 0
sw $t0, 12($sp)
lw $t0, 0($sp)
li $t1, 2
ble $t0, $t1, _L2
li $t0, 1
sw $t0, 12($sp)
li $v0, 1
li $a0, 3
syscall
li $v0, 4
la $a0, newline
syscall
_L2:
li $t0, 0
sw $t0, 16($sp)
lw $t0, 0($sp)
li $t1, 0
bge $t0, $t1, _L3
li $t0, 1
sw $t0, 16($sp)
li $v0, 1
li $a0, 4
syscall
li $v0, 4
la $a0, newline
syscall
_L3:
li $t0, 0
sw $t0, 20($sp)
lw $t0, 0($sp)
li $t1, 1
bge $t0, $t1, _L4
li $t0, 1
sw $t0, 20($sp)
li $v0, 1
li $a0, 5
syscall
li $v0, 4
la $a0, newline
syscall
_L4:
li $t0, 0
sw $t0, 24($sp)
lw $t0, 0($sp)
li $t1, 2
bge $t0, $t1, _L5
li $t0, 1
sw $t0, 24($sp)
li $v0, 1
li $a0, 6
syscall
li $v0, 4
la $a0, newline
syscall
_L5:
li $t0, 0
sw $t0, 28($sp)
lw $t0, 0($sp)
li $t1, 0
blt $t0, $t1, _L6
li $t0, 1
sw $t0, 28($sp)
li $v0, 1
li $a0, 7
syscall
li $v0, 4
la $a0, newline
syscall
_L6:
li $t0, 0
sw $t0, 32($sp)
lw $t0, 0($sp)
li $t1, 1
blt $t0, $t1, _L7
li $t0, 1
sw $t0, 32($sp)
li $v0, 1
li $a0, 8
syscall
li $v0, 4
la $a0, newline
syscall
_L7:
li $t0, 0
sw $t0, 36($sp)
lw $t0, 0($sp)
li $t1, 2
blt $t0, $t1, _L8
li $t0, 1
sw $t0, 36($sp)
li $v0, 1
li $a0, 9
syscall
li $v0, 4
la $a0, newline
syscall
_L8:
li $t0, 0
sw $t0, 40($sp)
lw $t0, 0($sp)
li $t1, 0
bgt $t0, $t1, _L9
li $t0, 1
sw $t0, 40($sp)
li $v0, 1
li $a0, 10
syscall
li $v0, 4
la $a0, newline
syscall
_L9:
li $t0, 0
sw $t0, 44($sp)
lw $t0, 0($sp)
li $t1, 1
bgt $t0, $t1, _L10
li $t0, 1
sw $t0, 44($sp)
li $v0, 1
li $a0, 11
syscall
li $v0, 4
la $a0, newline
syscall
_L10:
li $t0, 0
sw $t0, 48($sp)
lw $t0, 0($sp)
li $t1, 2
bgt $t0, $t1, _L11
li $t0, 1
sw $t0, 48($sp)
li $v0, 1
li $a0, 12
syscall
li $v0, 4
la $a0, newline
syscall
_L11:
li $t0, 0
sw $t0, 52($sp)
lw $t0, 0($sp)
li $t1, 0
bne $t0, $t1, _L12
li $t0, 1
sw $t0, 52($sp)
li $v0, 1
li $a0, 13
syscall
li $v0, 4
la $a0, newline
syscall
_L12:
li $t0, 0
sw $t0, 56($sp)
lw $t0, 0($sp)
li $t1, 1
bne $t0, $t1, _L13
li $t0, 1
sw $t0, 56($sp)
li $v0, 1
li $a0, 14
syscall
li $v0, 4
la $a0, newline
syscall
_L13:
li $t0, 0
sw $t0, 60($sp)
lw $t0, 0($sp)
li $t1, 0
beq $t0, $t1, _L14
li $t0, 1
sw $t0, 60($sp)
li $v0, 1
li $a0, 15
syscall
li $v0, 4
la $a0, newline
syscall
_L14:
li $t0, 0
sw $t0, 64($sp)
lw $t0, 0($sp)
li $t1, 1
beq $t0, $t1, _L15
li $t0, 1
sw $t0, 64($sp)
li $v0, 1
li $a0, 16
syscall
li $v0, 4
la $a0, newline
syscall
_L15:
# start of epilogue
addiu $sp, $sp, 544
# end of epilogue
li $v0, 0
jr $ra
