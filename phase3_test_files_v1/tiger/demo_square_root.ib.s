.data
newline: .asciiz "\n"
.text
.globl main
squareRoot:
# start of prologue
addiu $sp, $sp, -88
s.s $f12, 56($sp)
s.s $f31, 16($sp)
s.s $f30, 20($sp)
s.s $f29, 24($sp)
s.s $f28, 28($sp)
s.s $f27, 32($sp)
s.s $f26, 36($sp)
s.s $f25, 40($sp)
s.s $f24, 44($sp)
sw $ra, 48($sp)
# end of prologue
l.s $f20, 68($sp)
l.s $f21, 64($sp)
l.s $f22, 60($sp)
l.s $f23, 56($sp)
li.s $f4, 0.000001
mov.s $f20, $f4
mov.s $f22, $f23
li.s $f5, 1.0
mov.s $f21, $f5
s.s $f20, 68($sp)
s.s $f21, 64($sp)
s.s $f22, 60($sp)
s.s $f23, 56($sp)
_L0:
l.s $f22, 68($sp)
l.s $f21, 64($sp)
l.s $f20, 60($sp)
l.s $f23, 72($sp)
lw $s0, 52($sp)
sub.s $f23, $f20, $f21
s.s $f23, 72($sp)
li $s1, 0
move $s0, $s1
s.s $f22, 68($sp)
s.s $f21, 64($sp)
s.s $f20, 60($sp)
s.s $f23, 72($sp)
sw $s0, 52($sp)
c.le.s $f23, $f22
bc1t _L1
l.s $f20, 64($sp)
l.s $f23, 60($sp)
l.s $f25, 56($sp)
l.s $f21, 76($sp)
lw $s0, 52($sp)
l.s $f22, 84($sp)
l.s $f24, 80($sp)
li $s1, 1
move $s0, $s1
add.s $f21, $f23, $f20
s.s $f21, 76($sp)
li $s1, 2
mtc1 $s1, $f18
cvt.s.w $f18, $f18
li.s $f18, 2.0
div.s $f24, $f21, $f18
s.s $f24, 80($sp)
mov.s $f23, $f24
div.s $f22, $f25, $f23
s.s $f22, 84($sp)
mov.s $f20, $f22
s.s $f20, 64($sp)
s.s $f23, 60($sp)
s.s $f25, 56($sp)
s.s $f21, 76($sp)
sw $s0, 52($sp)
s.s $f22, 84($sp)
s.s $f24, 80($sp)
j _L0
_L1:
l.s $f24, 60($sp)
s.s $f24, 60($sp)
lw $v0, 60($sp)
# start of epilogue
l.s $f31, 16($sp)
l.s $f30, 20($sp)
l.s $f29, 24($sp)
l.s $f28, 28($sp)
l.s $f20, 32($sp)
l.s $f23, 36($sp)
l.s $f25, 40($sp)
l.s $f21, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 88
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -60
s.s $f31, 16($sp)
s.s $f30, 20($sp)
s.s $f29, 24($sp)
s.s $f28, 28($sp)
s.s $f27, 32($sp)
s.s $f26, 36($sp)
s.s $f25, 40($sp)
s.s $f24, 44($sp)
sw $ra, 48($sp)
# end of prologue
l.s $f20, 56($sp)
li.s $f12, 42.0
s.s $f20, 56($sp)
jal squareRoot
l.s $f20, 56($sp)
mov.s $f20, $f0
li $v0, 2
l.s $f4, 56($sp)
mov.s $f12, $f4
syscall
li $v0, 4
la $a0, newline
syscall
s.s $f20, 56($sp)
li $v0, 0
# start of epilogue
l.s $f31, 16($sp)
l.s $f30, 20($sp)
l.s $f29, 24($sp)
l.s $f28, 28($sp)
l.s $f27, 32($sp)
l.s $f26, 36($sp)
l.s $f25, 40($sp)
l.s $f24, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
