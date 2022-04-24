.data
newline: .asciiz "\n"
.text
.globl main
squareRoot:
# start of prologue
addiu $sp, $sp, -88
s.s $f12, 56($sp)
s.s $f31, 16($sp)
s.s $f29, 20($sp)
s.s $f28, 24($sp)
s.s $f27, 28($sp)
s.s $f26, 32($sp)
s.s $f25, 36($sp)
s.s $f24, 40($sp)
sw $ra, 48($sp)
# end of prologue
li.s $f4, 0.000001
mov.s $f22, $f4
mov.s $f20, $f21
li.s $f5, 1.0
mov.s $f23, $f5
_L0:
sub.s $f30, $f20, $f23
s.s $f30, 72($sp)
li $s0, 0
sw $s0, 52($sp)
c.le.s $f30, $f22
bc1t _L1
li $s0, 1
sw $s0, 52($sp)
add.s $f30, $f20, $f23
s.s $f30, 76($sp)
li $s0, 2
mtc1 $s0, $f18
cvt.s.w $f18, $f18
li.s $f18, 2.0
div.s $f30, $f30, $f18
s.s $f30, 80($sp)
mov.s $f20, $f30
div.s $f30, $f21, $f20
s.s $f30, 84($sp)
mov.s $f23, $f30
j _L0
_L1:
lw $v0, 60($sp)
# start of epilogue
l.s $f31, 16($sp)
l.s $f29, 20($sp)
l.s $f28, 24($sp)
l.s $f27, 28($sp)
l.s $f26, 32($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 88
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -60
s.s $f31, 16($sp)
s.s $f29, 20($sp)
s.s $f28, 24($sp)
s.s $f27, 28($sp)
s.s $f26, 32($sp)
s.s $f25, 36($sp)
s.s $f24, 40($sp)
s.s $f23, 44($sp)
sw $ra, 48($sp)
# end of prologue
li.s $f12, 42.0
s.s $f30, 56($sp)
jal squareRoot
l.s $f30, 56($sp)
mov.s $f30, $f0
li $v0, 2
l.s $f4, 56($sp)
mov.s $f12, $f4
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
l.s $f31, 16($sp)
l.s $f29, 20($sp)
l.s $f28, 24($sp)
l.s $f27, 28($sp)
l.s $f26, 32($sp)
l.s $f25, 36($sp)
l.s $f24, 40($sp)
l.s $f23, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
