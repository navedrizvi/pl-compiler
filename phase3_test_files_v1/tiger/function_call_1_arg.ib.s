.data
newline: .asciiz "\n"
.text
.globl main
square:
# start of prologue
addiu $sp, $sp, -64
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
# end of prologue
lw $s0, 52($sp)
lw $s1, 56($sp)
mul $s1, $s0, $s0
sw $s1, 56($sp)
sw $s0, 52($sp)
sw $s1, 56($sp)
lw $v0, 56($sp)
# start of epilogue
lw $s2, 16($sp)
lw $s3, 20($sp)
lw $s4, 24($sp)
lw $s5, 28($sp)
lw $s6, 32($sp)
lw $s7, 36($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 64
# end of epilogue
jr $ra
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
lw $s0, 52($sp)
li $a0, 5
sw $s0, 52($sp)
jal square
lw $s0, 52($sp)
move $s0, $v0
li $v0, 1
move $a0, $s0
syscall
li $v0, 4
la $a0, newline
syscall
sw $s0, 52($sp)
li $v0, 0
# start of epilogue
lw $s1, 16($sp)
lw $s2, 20($sp)
lw $s3, 24($sp)
lw $s4, 28($sp)
lw $s5, 32($sp)
lw $s6, 36($sp)
lw $s7, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
