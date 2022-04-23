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
mov.s $f22, $f7
mov.s $f23, $f20
li.s $f6, 1.0
mov.s $f4, $f6
_L0:
sub.s $f21, $f23, $f4
s.s $f21, 56($sp)
li $s3, 0
sw $s3, 36($sp)
ble $f21, $f22, _L1
li $s3, 1
sw $s3, 36($sp)
add.s $f21, $f23, $f4
s.s $f21, 60($sp)
li $s3, 2
div.s $f21, $f21, $s3
s.s $f21, 64($sp)
mov.s $f23, $f21
div.s $f21, $f20, $f23
s.s $f21, 68($sp)
mov.s $f4, $f21
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
s.s $f21, 40($sp)
jal squareRoot
l.s $f21, 40($sp)
move $f21, $v0
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
