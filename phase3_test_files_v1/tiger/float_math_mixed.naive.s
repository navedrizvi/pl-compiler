.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -164
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
s.s $f20, 48($sp)
s.s $f21, 52($sp)
s.s $f22, 56($sp)
s.s $f23, 60($sp)
s.s $f24, 64($sp)
s.s $f25, 68($sp)
s.s $f26, 72($sp)
s.s $f27, 76($sp)
sw $ra, 96($sp)
# end of prologue
li $s0, 1
sw $s0, 100($sp)
li.s $f4, 2.4
s.s $f4, 108($sp)
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
s.s $f7, 112($sp)
li $v0, 2
l.s $f8, 112($sp)
mov.s $f12, $f8
syscall
li $v0, 4
la $a0, newline
syscall
lw $s0, 100($sp)
mtc1 $s0, $f10
cvt.s.w $f10, $f10
s.s $f10, 112($sp)
li $v0, 2
l.s $f11, 112($sp)
mov.s $f12, $f11
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 3
mtc1 $s0, $f18
cvt.s.w $f18, $f18
li.s $f18, 3.0
l.s $f16, 108($sp)
l.s $f17, 116($sp)
add.s $f17, $f18, $f16
s.s $f17, 116($sp)
l.s $f19, 116($sp)
s.s $f19, 112($sp)
li $v0, 2
l.s $f20, 112($sp)
mov.s $f12, $f20
syscall
li $v0, 4
la $a0, newline
syscall
lw $s0, 100($sp)
mtc1 $s0, $f22
cvt.s.w $f22, $f22
s.s $f22, 100($sp)
l.s $f22, 100($sp)
l.s $f20, 108($sp)
l.s $f21, 120($sp)
add.s $f21, $f22, $f20
s.s $f21, 120($sp)
l.s $f22, 100($sp)
cvt.w.s $f22, $f22
mtc1 $s0, $f22
sw $s0, 100($sp)
l.s $f22, 120($sp)
s.s $f22, 112($sp)
li $v0, 2
l.s $f22, 112($sp)
mov.s $f12, $f22
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 12
lw $s1, 100($sp)
lw $s2, 104($sp)
add $s2, $s0, $s1
sw $s2, 104($sp)
lw $s0, 104($sp)
mtc1 $s0, $f20
cvt.s.w $f20, $f20
s.s $f20, 104($sp)
l.s $f20, 104($sp)
li.s $f21, 1.5
l.s $f22, 124($sp)
add.s $f22, $f20, $f21
s.s $f22, 124($sp)
l.s $f20, 104($sp)
cvt.w.s $f20, $f20
mtc1 $s0, $f20
sw $s0, 104($sp)
l.s $f20, 124($sp)
l.s $f21, 108($sp)
l.s $f22, 128($sp)
add.s $f22, $f20, $f21
s.s $f22, 128($sp)
li $s0, 3
mtc1 $s0, $f22
cvt.s.w $f22, $f22
l.s $f20, 128($sp)
li.s $f22, 3.0
l.s $f21, 132($sp)
add.s $f21, $f20, $f22
s.s $f21, 132($sp)
l.s $f20, 132($sp)
s.s $f20, 112($sp)
li $v0, 2
l.s $f20, 112($sp)
mov.s $f12, $f20
syscall
li $v0, 4
la $a0, newline
syscall
li $s0, 2
mtc1 $s0, $f21
cvt.s.w $f21, $f21
li.s $f21, 2.0
l.s $f20, 108($sp)
l.s $f22, 136($sp)
mul.s $f22, $f21, $f20
s.s $f22, 136($sp)
lw $s0, 100($sp)
mtc1 $s0, $f22
cvt.s.w $f22, $f22
s.s $f22, 100($sp)
l.s $f22, 100($sp)
l.s $f21, 136($sp)
l.s $f20, 140($sp)
div.s $f20, $f22, $f21
s.s $f20, 140($sp)
l.s $f22, 100($sp)
cvt.w.s $f22, $f22
mtc1 $s0, $f22
sw $s0, 100($sp)
li.s $f20, 12.4
l.s $f22, 140($sp)
l.s $f21, 144($sp)
add.s $f21, $f20, $f22
s.s $f21, 144($sp)
li $s0, 6
mtc1 $s0, $f21
cvt.s.w $f21, $f21
li.s $f22, 1.5
li.s $f21, 6.0
l.s $f20, 148($sp)
mul.s $f20, $f22, $f21
s.s $f20, 148($sp)
l.s $f22, 144($sp)
l.s $f21, 148($sp)
l.s $f20, 152($sp)
add.s $f20, $f22, $f21
s.s $f20, 152($sp)
li $s0, 3
mtc1 $s0, $f20
cvt.s.w $f20, $f20
l.s $f22, 108($sp)
li.s $f20, 3.0
l.s $f21, 156($sp)
div.s $f21, $f22, $f20
s.s $f21, 156($sp)
l.s $f22, 152($sp)
l.s $f20, 156($sp)
l.s $f21, 160($sp)
sub.s $f21, $f22, $f20
s.s $f21, 160($sp)
l.s $f22, 160($sp)
s.s $f22, 112($sp)
li $v0, 2
l.s $f22, 112($sp)
mov.s $f12, $f22
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
l.s $f31, 48($sp)
l.s $f30, 52($sp)
l.s $f29, 56($sp)
l.s $f28, 60($sp)
l.s $f27, 64($sp)
l.s $f26, 68($sp)
l.s $f25, 72($sp)
l.s $f24, 76($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 164
# end of epilogue
jr $ra
