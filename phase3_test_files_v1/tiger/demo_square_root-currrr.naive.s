.data
newline: .asciiz "\n"
.text
.globl main
squareRoot:
# start of prologue
addiu $sp, $sp, -88
s.s $f12, 56($sp)
s.s $f20, 16($sp)
s.s $f21, 20($sp)
s.s $f22, 24($sp)
s.s $f23, 28($sp)
s.s $f24, 32($sp)
s.s $f25, 36($sp)
s.s $f26, 40($sp)
s.s $f27, 44($sp)
sw $ra, 48($sp)
# end of prologue
li.s $f4, 0.000001
s.s $f4, 68($sp)
l.s $f5, 56($sp)
s.s $f5, 60($sp)
li.s $f6, 1.0
s.s $f6, 64($sp)
_L0:
l.s $f7, 60($sp)
l.s $f8, 64($sp)
l.s $f9, 72($sp)
sub.s $f9, $f7, $f8
s.s $f9, 72($sp)
li $s0, 0
sw $s0, 52($sp)
l.s $f10, 72($sp)
l.s $f11, 68($sp)
ble $f10, $f11, _L1









li $s0, 1
sw $s0, 52($sp)

l.s $f16, 60($sp)
l.s $f17, 64($sp)
l.s $f18, 76($sp)
add.s $f18, $f16, $f17
s.s $f18, 76($sp)



#TODO1- cast
lw $s0, 76($sp)
li $s1, 2
lw $s2, 80($sp)


div $s2, $s0, $s1


sw $s2, 80($sp)
lw $s0, 80($sp)
sw $s0, 60($sp)








l.s $f19, 56($sp)
l.s $f31, 60($sp)
l.s $f30, 84($sp)
div.s $f30, $f19, $f31
s.s $f30, 84($sp)
l.s $f29, 84($sp)
s.s $f29, 64($sp)
j _L0
_L1:
lw $v0, 60($sp)
# start of epilogue
l.s $f20, 16($sp)
l.s $f21, 20($sp)
l.s $f22, 24($sp)
l.s $f23, 28($sp)
l.s $f24, 32($sp)
l.s $f25, 36($sp)
l.s $f26, 40($sp)
l.s $f27, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 88
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -60
s.s $f20, 16($sp)
s.s $f21, 20($sp)
s.s $f22, 24($sp)
s.s $f23, 28($sp)
s.s $f24, 32($sp)
s.s $f25, 36($sp)
s.s $f26, 40($sp)
s.s $f27, 44($sp)
sw $ra, 48($sp)
# end of prologue
li.s $f12, 42.0
jal squareRoot
sw $v0, 56($sp)
li $v0, 2
l.s $f4, 56($sp)
mov.s $f12, $f4
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
l.s $f20, 16($sp)
l.s $f21, 20($sp)
l.s $f22, 24($sp)
l.s $f23, 28($sp)
l.s $f24, 32($sp)
l.s $f25, 36($sp)
l.s $f26, 40($sp)
l.s $f27, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
