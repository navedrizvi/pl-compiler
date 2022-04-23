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
li.s $f4, 0.000001
s.s $f4, 68($sp)
l.s $f5, 56($sp)
s.s $f5, 60($sp)
li.s $f6, 1.0
s.s $f6, 64($sp)
_L0:
l.s $f11, 60($sp)
l.s $f16, 64($sp)
l.s $f10, 72($sp)
sub.s $f10, $f11, $f16
s.s $f10, 72($sp)
li $s0, 0
sw $s0, 52($sp)
l.s $f17, 72($sp)
l.s $f18, 68($sp)
c.le.s $f17, $f18
bc1t _L1
li $s0, 1
sw $s0, 52($sp)
l.s $f23, 60($sp)
l.s $f24, 64($sp)
l.s $f22, 76($sp)
add.s $f22, $f23, $f24
s.s $f22, 76($sp)
li $s0, 2
mtc1 $s0, $f26
cvt.s.w $f26, $f26
l.s $f25, 76($sp)
li.s $f26, 2.0
l.s $f22, 80($sp)
div.s $f22, $f25, $f26
s.s $f22, 80($sp)
l.s $f25, 80($sp)
s.s $f25, 60($sp)
l.s $f29, 56($sp)
l.s $f30, 60($sp)
l.s $f28, 84($sp)
div.s $f28, $f29, $f30
s.s $f28, 84($sp)
l.s $f29, 84($sp)
s.s $f29, 64($sp)
j _L0
_L1:
lw $v0, 60($sp)
# start of epilogue
l.s $f31, 16($sp)
l.s $f28, 20($sp)
l.s $f30, 24($sp)
l.s $f29, 28($sp)
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
li.s $f12, 42.0
jal squareRoot
s.s $f0, 56($sp)
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
