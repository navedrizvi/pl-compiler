.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -112
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
li $t0, 1
sw $t0, 52($sp)
li.s $f4, 2.4
s.s $f4, 60($sp)
lw $t0, 52($sp)
mtc1 $t0, $f6
cvt.s.w $f6, $f6
s.s $f6, 52($sp)
l.s $f6, 52($sp)
l.s $f7, 60($sp)
l.s $f5, 68($sp)
add.s $f5, $f6, $f7
s.s $f5, 68($sp)
l.s $f6, 52($sp)
cvt.w.s $f6, $f6
mtc1 $t0, $f6
sw $t0, 52($sp)
l.s $f8, 68($sp)
s.s $f8, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 12
lw $t1, 52($sp)
lw $t2, 56($sp)
add $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 56($sp)
mtc1 $t0, $f10
cvt.s.w $f10, $f10
s.s $f10, 56($sp)
l.s $f10, 56($sp)
li.s $f11, 1.5
l.s $f9, 72($sp)
add.s $f9, $f10, $f11
s.s $f9, 72($sp)
l.s $f10, 56($sp)
cvt.w.s $f10, $f10
mtc1 $t0, $f10
sw $t0, 56($sp)
l.s $f17, 72($sp)
l.s $f18, 60($sp)
l.s $f16, 76($sp)
add.s $f16, $f17, $f18
s.s $f16, 76($sp)
li $t0, 3
mtc1 $t0, $f21
cvt.s.w $f21, $f21
l.s $f20, 76($sp)
li.s $f21, 3.0
l.s $f19, 80($sp)
add.s $f19, $f20, $f21
s.s $f19, 80($sp)
l.s $f20, 80($sp)
s.s $f20, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 2
mtc1 $t0, $f21
cvt.s.w $f21, $f21
li.s $f21, 2.0
l.s $f22, 60($sp)
l.s $f20, 84($sp)
mul.s $f20, $f21, $f22
s.s $f20, 84($sp)
lw $t0, 52($sp)
mtc1 $t0, $f22
cvt.s.w $f22, $f22
s.s $f22, 52($sp)
l.s $f22, 52($sp)
l.s $f20, 84($sp)
l.s $f21, 88($sp)
div.s $f21, $f22, $f20
s.s $f21, 88($sp)
l.s $f22, 52($sp)
cvt.w.s $f22, $f22
mtc1 $t0, $f22
sw $t0, 52($sp)
li.s $f20, 12.4
l.s $f21, 88($sp)
l.s $f22, 92($sp)
add.s $f22, $f20, $f21
s.s $f22, 92($sp)
li $t0, 6
mtc1 $t0, $f22
cvt.s.w $f22, $f22
li.s $f21, 1.5
li.s $f22, 6.0
l.s $f20, 96($sp)
mul.s $f20, $f21, $f22
s.s $f20, 96($sp)
l.s $f22, 92($sp)
l.s $f20, 96($sp)
l.s $f21, 100($sp)
add.s $f21, $f22, $f20
s.s $f21, 100($sp)
li $t0, 3
mtc1 $t0, $f21
cvt.s.w $f21, $f21
l.s $f20, 60($sp)
li.s $f21, 3.0
l.s $f22, 104($sp)
div.s $f22, $f20, $f21
s.s $f22, 104($sp)
l.s $f21, 100($sp)
l.s $f22, 104($sp)
l.s $f20, 108($sp)
sub.s $f20, $f21, $f22
s.s $f20, 108($sp)
l.s $f21, 108($sp)
s.s $f21, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
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
addiu $sp, $sp, 112
# end of epilogue
jr $ra
