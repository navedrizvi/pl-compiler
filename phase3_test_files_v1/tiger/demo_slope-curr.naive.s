.data
newline: .asciiz "\n"
_0_rise: .float 0.0
_0_run: .float 0.0
_0_slope: .float 0.0
_0_yintercept: .float 0.0
_0_xintercept: .float 0.0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -168
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




# TODO0
la $s0, _0_p1
li $s1, 2.0
addi $s0, $s0, 0
sw $s1, ($s0)
la $s1, _0_p1
li $s0, 1.0
addi $s1, $s1, 4
sw $s0, ($s1)
la $s0, _0_p2
li $s1, 3.0
addi $s0, $s0, 0
sw $s1, ($s0)
la $s1, _0_p2
li $s0, 3.0



addi $s1, $s1, 4
sw $s0, ($s1)
la $s0, _0_p2
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 116($sp)
la $s0, _0_p1
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 120($sp)
l.s $f5, 116($sp)
l.s $f6, 120($sp)
l.s $f4, 124($sp)
sub.s $f4, $f5, $f6
s.s $f4, 124($sp)
l.s $f7, 124($sp)
s.s $f7, _0_rise
la $s0, _0_p2
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 128($sp)
la $s0, _0_p1
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 132($sp)
l.s $f9, 128($sp)
l.s $f10, 132($sp)
l.s $f8, 136($sp)
sub.s $f8, $f9, $f10
s.s $f8, 136($sp)
l.s $f11, 136($sp)
s.s $f11, _0_run
li $s0, 0
sw $s0, 100($sp)
lw $t0, _0_run
li $t1, 0.0
lw $s0, _0_run
mtc1 $s0, $f16
cvt.s.w $f16, $f16
c.eq.s $f16, $t1
bc1f _L0
l.s $f16, _0_run
cvt.w.s $f16, $f16
mtc1 $s0, $f16
sw $s0, _0_run
li $s0, 1
sw $s0, 100($sp)
li $s0, 0
sw $s0, 104($sp)
lw $t0, _0_rise
li $t1, 0.0
lw $s0, _0_rise
mtc1 $s0, $f17
cvt.s.w $f17, $f17
c.eq.s $f17, $t1
bc1f _L0
l.s $f17, _0_rise
cvt.w.s $f17, $f17
mtc1 $s0, $f17
sw $s0, _0_rise
li $s0, 1
sw $s0, 104($sp)
lw $s0, 100($sp)
lw $s1, 104($sp)
lw $s2, 108($sp)
or $s2, $s0, $s1
sw $s2, 108($sp)
li $s0, 0
sw $s0, 112($sp)
lw $t0, 108($sp)
li $t1, 0
ble $t0, $t1, _L0
li $s0, 1
sw $s0, 112($sp)
li $v0, 1
li $a0, 0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 17
li $a0, 1
syscall
li $v0, 4
la $a0, newline
syscall
_L0:
lw $s0, _0_rise
mtc1 $s0, $f19
cvt.s.w $f19, $f19
s.s $f19, _0_rise
lw $s0, _0_run
mtc1 $s0, $f20
cvt.s.w $f20, $f20
s.s $f20, _0_run
l.s $f19, _0_rise
l.s $f20, _0_run
l.s $f18, 140($sp)
div.s $f18, $f19, $f20
s.s $f18, 140($sp)
l.s $f19, _0_rise
cvt.w.s $f19, $f19
mtc1 $s0, $f19
sw $s0, _0_rise
l.s $f20, _0_run
cvt.w.s $f20, $f20
mtc1 $s0, $f20
sw $s0, _0_run
l.s $f20, 140($sp)
s.s $f20, _0_slope
la $s0, _0_p2
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 144($sp)
la $s0, _0_p2
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 148($sp)
lw $s0, _0_slope
mtc1 $s0, $f21
cvt.s.w $f21, $f21
s.s $f21, _0_slope
l.s $f21, _0_slope
l.s $f22, 148($sp)
l.s $f20, 152($sp)
mul.s $f20, $f21, $f22
s.s $f20, 152($sp)
l.s $f21, _0_slope
cvt.w.s $f21, $f21
mtc1 $s0, $f21
sw $s0, _0_slope
l.s $f22, 144($sp)
l.s $f20, 152($sp)
l.s $f21, 156($sp)
sub.s $f21, $f22, $f20
s.s $f21, 156($sp)
l.s $f22, 156($sp)
s.s $f22, _0_yintercept
li $s0, 0
mtc1 $s0, $f20
cvt.s.w $f20, $f20
lw $s0, _0_yintercept
mtc1 $s0, $f21
cvt.s.w $f21, $f21
s.s $f21, _0_yintercept
li.s $f20, 0.0
l.s $f21, _0_yintercept
l.s $f22, 160($sp)
sub.s $f22, $f20, $f21
s.s $f22, 160($sp)
l.s $f21, _0_yintercept
cvt.w.s $f21, $f21
mtc1 $s0, $f21
sw $s0, _0_yintercept
lw $s0, _0_slope
mtc1 $s0, $f22
cvt.s.w $f22, $f22
s.s $f22, _0_slope
l.s $f21, 160($sp)
l.s $f22, _0_slope
l.s $f20, 164($sp)
div.s $f20, $f21, $f22
s.s $f20, 164($sp)
l.s $f22, _0_slope
cvt.w.s $f22, $f22
mtc1 $s0, $f22
sw $s0, _0_slope
l.s $f21, 164($sp)
s.s $f21, _0_xintercept
li $v0, 2
l.s $f12, _0_slope
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 2
l.s $f12, _0_xintercept
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 2
l.s $f12, _0_yintercept
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
addiu $sp, $sp, 168
# end of epilogue
jr $ra
