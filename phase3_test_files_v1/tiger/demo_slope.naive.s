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
addiu $sp, $sp, -120
sw $s3, 16($sp)
sw $s2, 20($sp)
sw $s1, 24($sp)
sw $s0, 28($sp)
s.s $f23, 32($sp)
s.s $f22, 36($sp)
s.s $f21, 40($sp)
s.s $f20, 44($sp)
sw $ra, 48($sp)
# end of prologue

la $s3, _0_p1
li $s2, 2.0
addi $s3, $s3, 0
sw $s2, ($s3)
la $s2, _0_p1
li $s3, 1.0
addi $s2, $s2, 4
sw $s3, ($s2)
la $s3, _0_p2
li $s2, 3.0
addi $s3, $s3, 0
sw $s2, ($s3)
la $s2, _0_p2
li $s3, 3.0





addi $s2, $s2, 4
sw $s3, ($s2)
la $s3, _0_p2
addi $s3, $s3, 4
lw $s2, ($s3)
sw $s2, 68($sp)
la $s3, _0_p1
addi $s3, $s3, 4
lw $s2, ($s3)
sw $s2, 72($sp)
l.s $f7, 68($sp)
l.s $f6, 72($sp)
l.s $f5, 76($sp)
sub.s $f5, $f7, $f6
s.s $f5, 76($sp)
l.s $f4, 76($sp)
s.s $f4, _0_rise
la $s3, _0_p2
addi $s3, $s3, 0
lw $s2, ($s3)
sw $s2, 80($sp)
la $s3, _0_p1
addi $s3, $s3, 0
lw $s2, ($s3)
sw $s2, 84($sp)
l.s $f23, 80($sp)
l.s $f22, 84($sp)
l.s $f21, 88($sp)
sub.s $f21, $f23, $f22
s.s $f21, 88($sp)
l.s $f23, 88($sp)
s.s $f23, _0_run
li $s3, 0
sw $s3, 52($sp)
lw $t3, _0_run
li $t2, 0.0
lw $s3, _0_run
mtc1 $s3, $f23
cvt.s.w $f23, $f23
s.s $f23, _0_run
c.eq.s $f23, $t2
bc1f _L0
l.s $f23, _0_run
cvt.w.s $f23, $f23
mtc1 $s3, $f23
sw $s3, _0_run
li $s3, 1
sw $s3, 52($sp)
li $s3, 0
sw $s3, 56($sp)
lw $t3, _0_rise
li $t2, 0.0
lw $s3, _0_rise
mtc1 $s3, $f23
cvt.s.w $f23, $f23
s.s $f23, _0_rise
c.eq.s $f23, $t2
bc1f _L0
l.s $f23, _0_rise
cvt.w.s $f23, $f23
mtc1 $s3, $f23
sw $s3, _0_rise
li $s3, 1
sw $s3, 56($sp)
lw $s3, 52($sp)
lw $s2, 56($sp)
lw $s1, 60($sp)
or $s1, $s3, $s2
sw $s1, 60($sp)
li $s3, 0
sw $s3, 64($sp)
lw $t3, 60($sp)
li $t2, 0
ble $t3, $t2, _L0
li $s3, 1
sw $s3, 64($sp)
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
lw $s3, _0_rise
mtc1 $s3, $f22
cvt.s.w $f22, $f22
s.s $f22, _0_rise
lw $s3, _0_run
mtc1 $s3, $f21
cvt.s.w $f21, $f21
s.s $f21, _0_run
l.s $f22, _0_rise
l.s $f21, _0_run
l.s $f23, 92($sp)
div.s $f23, $f22, $f21
s.s $f23, 92($sp)
l.s $f22, _0_rise
cvt.w.s $f22, $f22
mtc1 $s3, $f22
sw $s3, _0_rise
l.s $f21, _0_run
cvt.w.s $f21, $f21
mtc1 $s3, $f21
sw $s3, _0_run
l.s $f22, 92($sp)
s.s $f22, _0_slope
la $s3, _0_p2
addi $s3, $s3, 4
lw $s2, ($s3)
sw $s2, 96($sp)
la $s3, _0_p2
addi $s3, $s3, 0
lw $s2, ($s3)
sw $s2, 100($sp)
lw $s3, _0_slope
mtc1 $s3, $f23
cvt.s.w $f23, $f23
s.s $f23, _0_slope
l.s $f23, _0_slope
l.s $f22, 100($sp)
l.s $f21, 104($sp)
mul.s $f21, $f23, $f22
s.s $f21, 104($sp)
l.s $f23, _0_slope
cvt.w.s $f23, $f23
mtc1 $s3, $f23
sw $s3, _0_slope
l.s $f23, 96($sp)
l.s $f22, 104($sp)
l.s $f21, 108($sp)
sub.s $f21, $f23, $f22
s.s $f21, 108($sp)
l.s $f23, 108($sp)
s.s $f23, _0_yintercept
li $s3, 0
mtc1 $s3, $f22
cvt.s.w $f22, $f22
lw $s3, _0_yintercept
mtc1 $s3, $f21
cvt.s.w $f21, $f21
s.s $f21, _0_yintercept
li.s $f22, 0.0
l.s $f21, _0_yintercept
l.s $f23, 112($sp)
sub.s $f23, $f22, $f21
s.s $f23, 112($sp)
l.s $f21, _0_yintercept
cvt.w.s $f21, $f21
mtc1 $s3, $f21
sw $s3, _0_yintercept
lw $s3, _0_slope
mtc1 $s3, $f20
cvt.s.w $f20, $f20
s.s $f20, _0_slope
l.s $f21, 112($sp)
l.s $f20, _0_slope
l.s $f23, 116($sp)
div.s $f23, $f21, $f20
s.s $f23, 116($sp)
l.s $f20, _0_slope
cvt.w.s $f20, $f20
mtc1 $s3, $f20
sw $s3, _0_slope
l.s $f21, 116($sp)
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
lw $s3, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
l.s $f23, 32($sp)
l.s $f20, 36($sp)
l.s $f21, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 120
# end of epilogue
jr $ra
