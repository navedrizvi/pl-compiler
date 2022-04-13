.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -96
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
lw $s3, 52($sp)
lw $s1, 64($sp)
lw $s2, 60($sp)
lw $s0, 56($sp)
li $s4, 0
move $s3, $s4
li $s4, 0
move $s0, $s4
li $s4, 1
move $s2, $s4
add $s1, $s0, $s2
sw $s1, 64($sp)
move $s0, $s1
sw $s3, 52($sp)
sw $s1, 64($sp)
sw $s2, 60($sp)
sw $s0, 56($sp)
_L0:
lw $s0, 52($sp)
lw $s2, 68($sp)
li $s1, 0
move $s2, $s1
sw $s0, 52($sp)
sw $s2, 68($sp)
li $s1, 10
bge $s0, $s1, _L1
lw $s1, 52($sp)
lw $s2, 72($sp)
lw $s3, 68($sp)
lw $s4, 60($sp)
lw $s0, 56($sp)
lw $s5, 76($sp)
li $s6, 1
move $s3, $s6
add $s2, $s0, $s4
sw $s2, 72($sp)
move $s0, $s2
li $s6, 0
move $s5, $s6
sw $s1, 52($sp)
sw $s2, 72($sp)
sw $s3, 68($sp)
sw $s4, 60($sp)
sw $s0, 56($sp)
sw $s5, 76($sp)
li $s6, 5
bge $s1, $s6, _L2
lw $s4, 60($sp)
lw $s5, 56($sp)
lw $s0, 80($sp)
lw $s3, 76($sp)
li $s2, 1
move $s3, $s2
add $s0, $s5, $s4
sw $s0, 80($sp)
move $s5, $s0
sw $s4, 60($sp)
sw $s5, 56($sp)
sw $s0, 80($sp)
sw $s3, 76($sp)
j _L3
_L2:
lw $s3, 84($sp)
lw $s5, 60($sp)
lw $s0, 56($sp)
sub $s3, $s0, $s5
sw $s3, 84($sp)
move $s0, $s3
sw $s3, 84($sp)
sw $s5, 60($sp)
sw $s0, 56($sp)
_L3:
lw $s0, 88($sp)
lw $s5, 92($sp)
lw $s3, 52($sp)
lw $s2, 60($sp)
lw $s4, 56($sp)
add $s0, $s4, $s2
sw $s0, 88($sp)
move $s4, $s0
li $s1, 1
add $s5, $s3, $s1
sw $s5, 92($sp)
move $s3, $s5
sw $s0, 88($sp)
sw $s5, 92($sp)
sw $s3, 52($sp)
sw $s2, 60($sp)
sw $s4, 56($sp)
j _L0
_L1:
lw $s4, 56($sp)
li $v0, 1
move $a0, $s4
syscall
li $v0, 4
la $a0, newline
syscall
sw $s4, 56($sp)
li $v0, 0
# start of epilogue
lw $s2, 16($sp)
lw $s3, 20($sp)
lw $s5, 24($sp)
lw $s0, 28($sp)
lw $s1, 32($sp)
lw $s6, 36($sp)
lw $s7, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 96
# end of epilogue
jr $ra
