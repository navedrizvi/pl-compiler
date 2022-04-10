.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -60
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
# end of prologue
li $t0, 1
sw $t0, 52($sp)
lw $t0, 52($sp)
sltu $t1, $zero, $t0
xori $t1, $t1, 1
sw $t1, 52($sp)
li $v0, 1
lw $t1, 52($sp)
move $a0, $t1
syscall
li $v0, 4
la $a0, newline
syscall
lw $t1, 52($sp)
sltu $t0, $zero, $t1
xori $t0, $t0, 1
sw $t0, 52($sp)
li $v0, 1
lw $t0, 52($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
lw $s0, 16($sp)
lw $s1, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s4, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
