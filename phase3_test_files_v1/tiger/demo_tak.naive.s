.data
newline: .asciiz "\n"
.text
.globl main
tak:
# start of prologue
addiu $sp, $sp, -100
sw $a0, 52($sp)
sw $a1, 56($sp)
sw $a2, 60($sp)
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
sw $s0, 80($sp)
lw $s0, 56($sp)
lw $s1, 52($sp)
bge $s0, $s1, _L0
li $s0, 1
sw $s0, 80($sp)
lw $s0, 52($sp)
li $s1, 1
lw $s2, 84($sp)
sub $s2, $s0, $s1
sw $s2, 84($sp)
lw $a0, 84($sp)
lw $a1, 56($sp)
lw $a2, 60($sp)
jal tak
sw $v0, 76($sp)
lw $s0, 56($sp)
li $s1, 1
lw $s2, 88($sp)
sub $s2, $s0, $s1
sw $s2, 88($sp)
lw $a0, 88($sp)
lw $a1, 60($sp)
lw $a2, 52($sp)
jal tak
sw $v0, 72($sp)
lw $s0, 60($sp)
li $s1, 1
lw $s2, 92($sp)
sub $s2, $s0, $s1
sw $s2, 92($sp)
lw $a0, 92($sp)
lw $a1, 52($sp)
lw $a2, 56($sp)
jal tak
sw $v0, 68($sp)
lw $a0, 76($sp)
lw $a1, 72($sp)
lw $a2, 68($sp)
jal tak
sw $v0, 64($sp)
lw $v0, 64($sp)
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
addiu $sp, $sp, 100
# end of epilogue
jr $ra
j _L1
_L0:
lw $v0, 60($sp)
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
addiu $sp, $sp, 100
# end of epilogue
jr $ra
_L1:
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
li $a0, 15
li $a1, 10
li $a2, 5
jal tak
sw $v0, 52($sp)
li $v0, 1
lw $s0, 52($sp)
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
addiu $sp, $sp, 60
# end of epilogue
jr $ra
