.data
newline: .asciiz "\n"
_0_p2: .float 0.0, 0.0
_0_p1: .float 0.0, 0.0
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
la $s0, _0_p1
li.s $f4, 2.0
addi $s0, $s0, 0
s.s $f4, ($s0)
la $s0, _0_p1
li.s $f5, 1.0
addi $s0, $s0, 4
s.s $f5, ($s0)
la $s0, _0_p2
li.s $f6, 3.0
addi $s0, $s0, 0
s.s $f6, ($s0)
la $s0, _0_p2
li.s $f7, 3.0
addi $s0, $s0, 4
s.s $f7, ($s0)
la $s0, _0_p2
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 116($sp)
la $s0, _0_p1
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 120($sp)
l.s $f9, 116($sp)
l.s $f10, 120($sp)
l.s $f8, 124($sp)
sub.s $f8, $f9, $f10
s.s $f8, 124($sp)
l.s $f11, 124($sp)
s.s $f11, _0_rise
la $s0, _0_p2
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 128($sp)
la $s0, _0_p1
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 132($sp)
l.s $f17, 128($sp)
l.s $f18, 132($sp)
l.s $f16, 136($sp)
sub.s $f16, $f17, $f18
s.s $f16, 136($sp)
l.s $f19, 136($sp)
s.s $f19, _0_run
li $s0, 0
sw $s0, 100($sp)
l.s $f20, _0_run
li.s $f21, 0.0
c.eq.s $f20, $f21
bc1f _L0
li $s0, 1
sw $s0, 100($sp)
li $s0, 0
sw $s0, 104($sp)
l.s $f20, _0_rise
li.s $f21, 0.0
c.eq.s $f20, $f21
bc1f _L0
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
l.s $f21, _0_rise
l.s $f22, _0_run
l.s $f20, 140($sp)
div.s $f20, $f21, $f22
s.s $f20, 140($sp)
l.s $f21, 140($sp)
s.s $f21, _0_slope
la $s0, _0_p2
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 144($sp)
la $s0, _0_p2
addi $s0, $s0, 0
lw $s1, ($s0)
sw $s1, 148($sp)
l.s $f22, _0_slope
l.s $f20, 148($sp)
l.s $f21, 152($sp)
mul.s $f21, $f22, $f20
s.s $f21, 152($sp)
l.s $f20, 144($sp)
l.s $f21, 152($sp)
l.s $f22, 156($sp)
sub.s $f22, $f20, $f21
s.s $f22, 156($sp)
l.s $f20, 156($sp)
s.s $f20, _0_yintercept
li $s0, 0
mtc1 $s0, $f21
cvt.s.w $f21, $f21
li.s $f21, 0.0
l.s $f22, _0_yintercept
l.s $f20, 160($sp)
sub.s $f20, $f21, $f22
s.s $f20, 160($sp)
l.s $f22, 160($sp)
l.s $f20, _0_slope
l.s $f21, 164($sp)
div.s $f21, $f22, $f20
s.s $f21, 164($sp)
l.s $f22, 164($sp)
s.s $f22, _0_xintercept
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
