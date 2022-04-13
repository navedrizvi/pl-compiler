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
li $s0, 0
sw $s0, 52($sp)
li $s0, 0
sw $s0, 56($sp)
li $s0, 1
sw $s0, 60($sp)
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 64($sp)
add $s2, $s0, $s1
sw $s2, 64($sp)
lw $s0, 64($sp)
sw $s0, 56($sp)
_L0:
li $s0, 0
sw $s0, 68($sp)
lw $s0, 52($sp)
li $s1, 10
bge $s0, $s1, _L1
li $s0, 1
sw $s0, 68($sp)
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 72($sp)
add $s2, $s0, $s1
sw $s2, 72($sp)
lw $s0, 72($sp)
sw $s0, 56($sp)
li $s0, 0
sw $s0, 76($sp)
lw $s0, 52($sp)
li $s1, 5
bge $s0, $s1, _L2
li $s0, 1
sw $s0, 76($sp)
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 80($sp)
add $s2, $s0, $s1
sw $s2, 80($sp)
lw $s0, 80($sp)
sw $s0, 56($sp)
j _L3
_L2:
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 84($sp)
sub $s2, $s0, $s1
sw $s2, 84($sp)
lw $s0, 84($sp)
sw $s0, 56($sp)
_L3:
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 88($sp)
add $s2, $s0, $s1
sw $s2, 88($sp)
lw $s0, 88($sp)
sw $s0, 56($sp)
lw $s0, 52($sp)
li $s1, 1
lw $s2, 92($sp)
add $s2, $s0, $s1
sw $s2, 92($sp)
lw $s0, 92($sp)
sw $s0, 52($sp)
j _L0
_L1:
li $v0, 1
lw $s0, 56($sp)
move $a0, $s0
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
addiu $sp, $sp, 96
# end of epilogue
jr $ra
