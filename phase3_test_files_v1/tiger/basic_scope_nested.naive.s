.data
newline: .asciiz "\n"
_0_a: .word 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -144
# end of prologue
li $t0, 10
sw $t0, _0_a
lw $t0, _0_a
li $t1, 1
lw $t2, 4($sp)
add $t2, $t0, $t1
sw $t2, 4($sp)
lw $t0, 4($sp)
sw $t0, _0_a
li $t0, 20
sw $t0, 0($sp)
lw $t0, _0_a
li $t1, 1
lw $t2, 12($sp)
add $t2, $t0, $t1
sw $t2, 12($sp)
lw $t0, 12($sp)
sw $t0, _0_a
lw $t0, 0($sp)
li $t1, 1
lw $t2, 16($sp)
add $t2, $t0, $t1
sw $t2, 16($sp)
lw $t0, 16($sp)
sw $t0, 0($sp)
li $t0, 30
sw $t0, 8($sp)
lw $t0, _0_a
li $t1, 1
lw $t2, 24($sp)
add $t2, $t0, $t1
sw $t2, 24($sp)
lw $t0, 24($sp)
sw $t0, _0_a
lw $t0, 0($sp)
li $t1, 1
lw $t2, 28($sp)
add $t2, $t0, $t1
sw $t2, 28($sp)
lw $t0, 28($sp)
sw $t0, 0($sp)
lw $t0, 8($sp)
li $t1, 1
lw $t2, 32($sp)
add $t2, $t0, $t1
sw $t2, 32($sp)
lw $t0, 32($sp)
sw $t0, 8($sp)
li $t0, 40
sw $t0, 20($sp)
li $v0, 1
lw $t0, 20($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $t0, 0($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $a0, _0_a
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 144
# end of epilogue
li $v0, 0
jr $ra
