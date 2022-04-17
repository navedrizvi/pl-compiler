.data
newline: .asciiz "\n"
.text
.globl main
squareRoot:
# start of prologue
addiu $sp, $sp, -88
sw $a0, 56($sp)
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
li.s $f4, 0.000001
s.s $f4, 68($sp)
lw $s0, 56($sp)
sw $s0, 60($sp)
li.s $f5, 1.0
s.s $f5, 64($sp)
_L0:
lw $s0, 60($sp)
lw $s1, 64($sp)
lw $s2, 72($sp)
sub $s2, $s0, $s1
sw $s2, 72($sp)
li $s0, 0
sw $s0, 52($sp)
lw $s0, 72($sp)
lw $s1, 68($sp)
ble $s0, $s1, _L1
li $s0, 1
sw $s0, 52($sp)
lw $s0, 60($sp)
lw $s1, 64($sp)
lw $s2, 76($sp)
add $s2, $s0, $s1
sw $s2, 76($sp)
lw $s0, 76($sp)
li $s1, 2
lw $s2, 80($sp)
div $s2, $s0, $s1
sw $s2, 80($sp)
lw $s0, 80($sp)
sw $s0, 60($sp)
lw $s0, 56($sp)
lw $s1, 60($sp)
lw $s2, 84($sp)
div $s2, $s0, $s1
sw $s2, 84($sp)
lw $s0, 84($sp)
sw $s0, 64($sp)
j _L0
_L1:
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
addiu $sp, $sp, 88
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
li.s $f12, 42.0
jal squareRoot
sw $v0, 56($sp)
li $v0, 2
l.s $f4, 56($sp)
mov.s $f12, $f4
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
