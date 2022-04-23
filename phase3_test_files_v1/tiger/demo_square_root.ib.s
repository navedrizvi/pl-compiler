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
l.s $f23, 52($sp)
l.s $f22, 48($sp)
l.s $f21, 44($sp)
l.s $f20, 40($sp)
li.s $f7, 0.000001
mov.s $f23, $f7
mov.s $f21, $f20
li.s $f6, 1.0
mov.s $f22, $f6
s.s $f23, 52($sp)
s.s $f22, 48($sp)
s.s $f21, 44($sp)
s.s $f20, 40($sp)
_L0:
l.s $f21, 52($sp)
l.s $f22, 48($sp)
l.s $f23, 44($sp)
l.s $f20, 56($sp)
lw $s3, 36($sp)
sub.s $f20, $f23, $f22
s.s $f20, 56($sp)
li $s2, 0
move $s3, $s2
s.s $f21, 52($sp)
s.s $f22, 48($sp)
s.s $f23, 44($sp)
s.s $f20, 56($sp)
sw $s3, 36($sp)
ble $f20, $f21, _L1
l.s $f23, 48($sp)
l.s $f20, 44($sp)
l.s $f4, 40($sp)
l.s $f22, 60($sp)
lw $s3, 36($sp)
l.s $f21, 68($sp)
l.s $f5, 64($sp)
li $s2, 1
move $s3, $s2
add.s $f22, $f20, $f23
s.s $f22, 60($sp)
li $s2, 2
div.s $f5, $f22, $s2
s.s $f5, 64($sp)
mov.s $f20, $f5
div.s $f21, $f4, $f20
s.s $f21, 68($sp)
mov.s $f23, $f21
s.s $f23, 48($sp)
s.s $f20, 44($sp)
s.s $f4, 40($sp)
s.s $f22, 60($sp)
sw $s3, 36($sp)
s.s $f21, 68($sp)
s.s $f5, 64($sp)
j _L0
_L1:
l.s $f21, 44($sp)
s.s $f21, 44($sp)
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
l.s $f23, 40($sp)
li $a0, 42.0
s.s $f23, 40($sp)
jal squareRoot
l.s $f23, 40($sp)
move $f23, $v0
li $v0, 2
l.s $f7, 40($sp)
mov.s $f12, $f7
syscall
li $v0, 4
la $a0, newline
syscall
s.s $f23, 40($sp)
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
