.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -116
sw $ra, 48($sp)
# end of prologue
li $s0, 1
sw $s0, 52($sp)
li.s $f4, 2.4
s.s $f4, 60($sp)
li $v0, 2
li $s0, 5
mtc1 $s0, $f5
cvt.s.w $f5, $f5
mov.s $f12, $f5
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 1
mtc1 $s0, $f7
cvt.s.w $f7, $f7
s.s $f7, 64($sp)
li $v0, 2
l.s $f8, 64($sp)
mov.s $f12, $f8
syscall
li $v0, 4
la $a0, newline
syscall
lw $s0, 52($sp)
mtc1 $s0, $f10
cvt.s.w $f10, $f10
s.s $f10, 64($sp)
li $v0, 2
l.s $f11, 64($sp)
mov.s $f12, $f11
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 3
mtc1 $s0, $f17
cvt.s.w $f17, $f17
li.s $f17, 3.0
l.s $f18, 60($sp)
l.s $f16, 68($sp)
add.s $f16, $f17, $f18
s.s $f16, 68($sp)
l.s $f19, 68($sp)
s.s $f19, 64($sp)
li $v0, 2
l.s $f31, 64($sp)
mov.s $f12, $f31
syscall
li $v0, 4
la $a0, newline
syscall
lw $s0, 52($sp)
mtc1 $s0, $f30
cvt.s.w $f30, $f30
s.s $f30, 52($sp)
l.s $f30, 52($sp)
l.s $f29, 60($sp)
l.s $f31, 72($sp)
add.s $f31, $f30, $f29
s.s $f31, 72($sp)
l.s $f30, 52($sp)
cvt.w.s $f30, $f30
mtc1 $s0, $f30
sw $s0, 52($sp)
l.s $f30, 72($sp)
s.s $f30, 64($sp)
li $v0, 2
l.s $f30, 64($sp)
mov.s $f12, $f30
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 12
lw $s1, 52($sp)
lw $s2, 56($sp)
add $s2, $s0, $s1
sw $s2, 56($sp)
lw $s0, 56($sp)
mtc1 $s0, $f29
cvt.s.w $f29, $f29
s.s $f29, 56($sp)
l.s $f29, 56($sp)
li.s $f31, 1.5
l.s $f30, 76($sp)
add.s $f30, $f29, $f31
s.s $f30, 76($sp)
l.s $f29, 56($sp)
cvt.w.s $f29, $f29
mtc1 $s0, $f29
sw $s0, 56($sp)
l.s $f31, 76($sp)
l.s $f30, 60($sp)
l.s $f29, 80($sp)
add.s $f29, $f31, $f30
s.s $f29, 80($sp)
li $s0, 3
mtc1 $s0, $f29
cvt.s.w $f29, $f29
l.s $f30, 80($sp)
li.s $f29, 3.0
l.s $f31, 84($sp)
add.s $f31, $f30, $f29
s.s $f31, 84($sp)
l.s $f30, 84($sp)
s.s $f30, 64($sp)
li $v0, 2
l.s $f30, 64($sp)
mov.s $f12, $f30
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 2
mtc1 $s0, $f31
cvt.s.w $f31, $f31
li.s $f31, 2.0
l.s $f28, 60($sp)
l.s $f30, 88($sp)
mul.s $f30, $f31, $f28
s.s $f30, 88($sp)
lw $s0, 52($sp)
mtc1 $s0, $f28
cvt.s.w $f28, $f28
s.s $f28, 52($sp)
l.s $f28, 52($sp)
l.s $f30, 88($sp)
l.s $f31, 92($sp)
div.s $f31, $f28, $f30
s.s $f31, 92($sp)
l.s $f28, 52($sp)
cvt.w.s $f28, $f28
mtc1 $s0, $f28
sw $s0, 52($sp)
li.s $f30, 12.4
l.s $f31, 92($sp)
l.s $f28, 96($sp)
add.s $f28, $f30, $f31
s.s $f28, 96($sp)
li $s0, 6
mtc1 $s0, $f28
cvt.s.w $f28, $f28
li.s $f31, 1.5
li.s $f28, 6.0
l.s $f30, 100($sp)
mul.s $f30, $f31, $f28
s.s $f30, 100($sp)
l.s $f30, 96($sp)
l.s $f27, 100($sp)
l.s $f31, 104($sp)
add.s $f31, $f30, $f27
s.s $f31, 104($sp)
li $s0, 3
mtc1 $s0, $f31
cvt.s.w $f31, $f31
l.s $f27, 60($sp)
li.s $f31, 3.0
l.s $f30, 108($sp)
div.s $f30, $f27, $f31
s.s $f30, 108($sp)
l.s $f30, 104($sp)
l.s $f26, 108($sp)
l.s $f27, 112($sp)
sub.s $f27, $f30, $f26
s.s $f27, 112($sp)
l.s $f30, 112($sp)
s.s $f30, 64($sp)
li $v0, 2
l.s $f30, 64($sp)
mov.s $f12, $f30
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
addiu $sp, $sp, 116
# end of epilogue
jr $ra
24($sp)
lw $s3, 28($sp)
lw $s4, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 116
# end of epilogue
jr $ra
