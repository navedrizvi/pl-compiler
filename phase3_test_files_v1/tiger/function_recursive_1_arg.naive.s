.data
newline: .asciiz "\n"
.text
.globl main
factorial:
# start of prologue
addiu $sp, $sp, -72
# end of prologue
sw $a0, 52($sp)
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
li $t0, 0
sw $t0, 60($sp)
lw $t0, 52($sp)
li $t1, 0
bne $t0, $t1, _L0
li $t0, 1
sw $t0, 60($sp)
li $v0, 1
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
addiu $sp, $sp, 72
# end of epilogue
jr $ra
_L0:
lw $t0, 52($sp)
li $t1, 1
lw $t2, 64($sp)
sub $t2, $t0, $t1
sw $t2, 64($sp)
lw $a0, 64($sp)
jal factorial
sw $v0, 56($sp)
lw $t0, 52($sp)
lw $t1, 56($sp)
lw $t2, 68($sp)
mul $t2, $t0, $t1
sw $t2, 68($sp)
lw $v0, 68($sp)
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
addiu $sp, $sp, 72
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -56
# end of prologue
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
li $a0, 7
jal factorial
sw $v0, 52($sp)
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
addiu $sp, $sp, 56
# end of epilogue
jr $ra
