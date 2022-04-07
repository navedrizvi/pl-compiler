.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -116
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
s.s $f4, 60($sp)
li $v0, 2
li $t0, 5
mtc1 $t0, $f5
cvt.s.w $f5, $f5
mov.s $f12, $f5
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 1
mtc1 $t0, $f7
cvt.s.w $f7, $f7
li.s $f6, $f7
s.s $f6, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, _2_a
mtc1 $t0, $f9
cvt.s.w $f9, $f9
li.s $f8, $f9
s.s $f8, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
li.s $f10, 3.0
l.s $f11, 60($sp)
l.s $f16, 68($sp)
add.s $f16, $f10, $f11
s.s $f16, 68($sp)
s.s $f17, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
l.s $f18, 52($sp)
l.s $f19, 60($sp)
l.s $f20, 72($sp)
add.s $f20, $f18, $f19
s.s $f20, 72($sp)
s.s $f20, 64($sp)
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
l.s $f20, 56($sp)
li.s $f21, 1.5
l.s $f22, 76($sp)
add.s $f22, $f20, $f21
s.s $f22, 76($sp)
l.s $f20, 76($sp)
l.s $f21, 60($sp)
l.s $f22, 80($sp)
add.s $f22, $f20, $f21
s.s $f22, 80($sp)
l.s $f20, 80($sp)
li.s $f21, 3.0
l.s $f22, 84($sp)
add.s $f22, $f20, $f21
s.s $f22, 84($sp)
s.s $f20, 64($sp)
li $v0, 2
l.s $f12, 64($sp)
syscall
li $v0, 4
la $a0, newline
syscall
li.s $f20, 2.0
l.s $f21, 60($sp)
l.s $f22, 88($sp)
mul.s $f22, $f20, $f21
s.s $f22, 88($sp)
l.s $f20, 52($sp)
l.s $f21, 88($sp)
l.s $f22, 92($sp)
div.s $f22, $f20, $f21
s.s $f22, 92($sp)
li.s $f20, 12.4
l.s $f21, 92($sp)
l.s $f22, 96($sp)
add.s $f22, $f20, $f21
s.s $f22, 96($sp)
li.s $f20, 1.5
li.s $f21, 6.0
l.s $f22, 100($sp)
mul.s $f22, $f20, $f21
s.s $f22, 100($sp)
l.s $f20, 96($sp)
l.s $f21, 100($sp)
l.s $f22, 104($sp)
add.s $f22, $f20, $f21
s.s $f22, 104($sp)
l.s $f20, 60($sp)
li.s $f21, 3.0
l.s $f22, 108($sp)
div.s $f22, $f20, $f21
s.s $f22, 108($sp)
l.s $f20, 104($sp)
l.s $f21, 108($sp)
l.s $f22, 112($sp)
sub.s $f22, $f20, $f21
s.s $f22, 112($sp)
s.s $f20, 64($sp)
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
addiu $sp, $sp, 116
# end of epilogue
jr $ra

ue
jr $ra
e
jr $ra
$sp)
addiu $sp, $sp, 116
# end of epilogue
jr $ra
