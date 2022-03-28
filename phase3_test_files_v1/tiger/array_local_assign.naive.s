.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -68
# end of prologue
li $t0, 6
sw $t0, 0($sp)
sw $t0, 4($sp)
sw $t0, 8($sp)
li $t0, 12
sw $t0, 12($sp)
sw $t0, 16($sp)
sw $t0, 20($sp)
lw $t0, 24($sp)
lw $t0, 0($sp)
sw $t0, 24($sp)
li $v0, 1
lw $t0, 24($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 28($sp)
lw $t0, 4($sp)
sw $t0, 28($sp)
li $v0, 1
lw $t0, 28($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 32($sp)
lw $t0, 8($sp)
sw $t0, 32($sp)
li $v0, 1
lw $t0, 32($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 36($sp)
lw $t0, 12($sp)
sw $t0, 36($sp)
li $v0, 1
lw $t0, 36($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 40($sp)
lw $t0, 16($sp)
sw $t0, 40($sp)
li $v0, 1
lw $t0, 40($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 44($sp)
lw $t0, 20($sp)
sw $t0, 44($sp)
li $v0, 1
lw $t0, 44($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
sw $t0, 12($sp)
lw $t0, 4($sp)
sw $t0, 16($sp)
lw $t0, 8($sp)
sw $t0, 20($sp)
lw $t0, 48($sp)
lw $t0, 12($sp)
sw $t0, 48($sp)
lw $t0, 52($sp)
lw $t0, 16($sp)
sw $t0, 52($sp)
lw $t0, 48($sp)
lw $t1, 52($sp)
lw $t2, 56($sp)
add $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 60($sp)
lw $t0, 20($sp)
sw $t0, 60($sp)
lw $t0, 56($sp)
lw $t1, 60($sp)
lw $t2, 64($sp)
add $t2, $t0, $t1
sw $t2, 64($sp)
li $v0, 1
lw $t0, 64($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 68
# end of epilogue
li $v0, 0
jr $ra
