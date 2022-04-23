.data
newline: .asciiz "\n"
.text
.globl main
squareRoot:
# start of prologue
addiu $sp, $sp, -72
sw $a0, 40($sp)
sw $s3, 16($sp)
sw $s2, 20($sp)
sw $s1, 24($sp)
sw $s0, 28($sp)
sw $ra, 32($sp)
# end of prologue
li.s $f7, 0.000001
s.s $f7, 52($sp)
lw $s3, 40($sp)
sw $s3, 44($sp)
li.s $f6, 1.0
s.s $f6, 48($sp)
_L0:
lw $s3, 44($sp)
lw $s2, 48($sp)
lw $s1, 56($sp)
sub $s1, $s3, $s2
sw $s1, 56($sp)
li $s3, 0
sw $s3, 36($sp)
lw $s3, 56($sp)
lw $s2, 52($sp)
ble $s3, $s2, _L1
li $s3, 1
sw $s3, 36($sp)
lw $s3, 44($sp)
lw $s2, 48($sp)
lw $s1, 60($sp)
add $s1, $s3, $s2
sw $s1, 60($sp)
lw $s3, 60($sp)
li $s2, 2
lw $s1, 64($sp)
div $s1, $s3, $s2
sw $s1, 64($sp)
lw $s3, 64($sp)
sw $s3, 44($sp)
lw $s3, 40($sp)
lw $s2, 44($sp)
lw $s1, 68($sp)
div $s1, $s3, $s2
sw $s1, 68($sp)
lw $s3, 68($sp)
sw $s3, 48($sp)
j _L0
_L1:
lw $v0, 44($sp)
# start of epilogue
lw $s3, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
lw $ra, 32($sp)
addiu $sp, $sp, 72
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -44
sw $s3, 16($sp)
sw $s2, 20($sp)
sw $s1, 24($sp)
sw $s0, 28($sp)
sw $ra, 32($sp)
# end of prologue
li $a0, 42.0
jal squareRoot
sw $v0, 40($sp)
li $v0, 2
l.s $f7, 40($sp)
mov.s $f12, $f7
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
lw $s3, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
lw $ra, 32($sp)
addiu $sp, $sp, 44
# end of epilogue
jr $ra
