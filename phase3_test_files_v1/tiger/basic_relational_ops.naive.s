.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -220
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
li $t1, 1
bne $t0, $t1, _L0
li $t0, 1
sw $t0, 12($sp)
_L0:
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 16($sp)
lw $t0, 0($sp)
li $t1, 1
beq $t0, $t1, _L1
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
ble $t0, $t1, _L2
li $t0, 1
sw $t0, 20($sp)
_L2:
li $v0, 1
lw $t0, 20($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 24($sp)
lw $t0, 0($sp)
lw $t1, 4($sp)
bge $t0, $t1, _L3
li $t0, 1
sw $t0, 24($sp)
_L3:
li $v0, 1
lw $t0, 24($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 28($sp)
lw $t0, 0($sp)
lw $t1, 8($sp)
bgt $t0, $t1, _L4
li $t0, 1
sw $t0, 28($sp)
_L4:
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
li $t1, 1
bgt $t0, $t1, _L5
li $t0, 1
sw $t0, 32($sp)
_L5:
li $v0, 1
lw $t0, 32($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 0
sw $t0, 36($sp)
lw $t0, 0($sp)
lw $t1, 8($sp)
blt $t0, $t1, _L6
li $t0, 1
sw $t0, 36($sp)
_L6:
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
li $t1, 1
blt $t0, $t1, _L7
li $t0, 1
sw $t0, 40($sp)
_L7:
li $v0, 1
lw $t0, 40($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 220
# end of epilogue
li $v0, 0
jr $ra
