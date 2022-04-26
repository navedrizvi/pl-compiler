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
l.s $f20, _0_run
lw $s0, 100($sp)
l.s $f21, 136($sp)
l.s $f22, 116($sp)
l.s $f23, 124($sp)
l.s $f24, 120($sp)
l.s $f25, 132($sp)
l.s $f26, 128($sp)
l.s $f27, _0_rise
la $s1, _0_p1
li.s $f4, 2.0
addi $s1, $s1, 0
s.s $f4, ($s1)
la $s1, _0_p1
li.s $f5, 1.0
addi $s1, $s1, 4
s.s $f5, ($s1)
la $s1, _0_p2
li.s $f6, 3.0
addi $s1, $s1, 0
s.s $f6, ($s1)
la $s1, _0_p2
li.s $f7, 3.0
addi $s1, $s1, 4
s.s $f7, ($s1)
la $s1, _0_p2
addi $s1, $s1, 4
lw $s2, ($s1)
move $f22, $s2
la $s1, _0_p1
addi $s1, $s1, 4
lw $s2, ($s1)
move $f24, $s2
sub.s $f23, $f22, $f24
s.s $f23, 124($sp)
mov.s $f27, $f23
la $s1, _0_p2
addi $s1, $s1, 0
lw $s2, ($s1)
move $f26, $s2
la $s1, _0_p1
addi $s1, $s1, 0
lw $s2, ($s1)
move $f25, $s2
sub.s $f21, $f26, $f25
s.s $f21, 136($sp)
mov.s $f20, $f21
li $s1, 0
move $s0, $s1
s.s $f20, _0_run
sw $s0, 100($sp)
s.s $f21, 136($sp)
s.s $f22, 116($sp)
s.s $f23, 124($sp)
s.s $f24, 120($sp)
s.s $f25, 132($sp)
s.s $f26, 128($sp)
s.s $f27, _0_rise
li.s $f8, 0.0
c.eq.s $f20, $f8
bc1f _L0
lw $s0, 100($sp)
lw $s1, 104($sp)
l.s $f27, _0_rise
li $s2, 1
move $s0, $s2
li $s2, 0
move $s1, $s2
sw $s0, 100($sp)
sw $s1, 104($sp)
s.s $f27, _0_rise
li.s $f9, 0.0
c.eq.s $f27, $f9
bc1f _L0
lw $s2, 100($sp)
lw $s1, 108($sp)
lw $s0, 104($sp)
lw $s3, 112($sp)
li $s4, 1
move $s0, $s4
or $s1, $s2, $s0
sw $s1, 108($sp)
li $s4, 0
move $s3, $s4
sw $s2, 100($sp)
sw $s1, 108($sp)
sw $s0, 104($sp)
sw $s3, 112($sp)
li $t0, 0
ble $s1, $t0, _L0
lw $s3, 112($sp)
li $s0, 1
move $s3, $s0
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
sw $s3, 112($sp)
_L0:
l.s $f26, _0_yintercept
l.s $f30, _0_run
l.s $f27, _0_slope
l.s $f25, 156($sp)
l.s $f24, 160($sp)
l.s $f23, _0_xintercept
l.s $f22, 164($sp)
l.s $f21, 140($sp)
l.s $f20, 144($sp)
l.s $f28, 148($sp)
l.s $f29, 152($sp)
l.s $f31, _0_rise
div.s $f21, $f31, $f30
s.s $f21, 140($sp)
mov.s $f27, $f21
la $s3, _0_p2
addi $s3, $s3, 4
lw $s0, ($s3)
move $f20, $s0
la $s3, _0_p2
addi $s3, $s3, 0
lw $s0, ($s3)
move $f28, $s0
mul.s $f29, $f27, $f28
s.s $f29, 152($sp)
sub.s $f25, $f20, $f29
s.s $f25, 156($sp)
mov.s $f26, $f25
li $s3, 0
mtc1 $s3, $f10
cvt.s.w $f10, $f10
li.s $f10, 0.0
sub.s $f24, $f10, $f26
s.s $f24, 160($sp)
div.s $f22, $f24, $f27
s.s $f22, 164($sp)
mov.s $f23, $f22
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
s.s $f26, _0_yintercept
s.s $f30, _0_run
s.s $f27, _0_slope
s.s $f25, 156($sp)
s.s $f24, 160($sp)
s.s $f23, _0_xintercept
s.s $f22, 164($sp)
s.s $f21, 140($sp)
s.s $f20, 144($sp)
s.s $f28, 148($sp)
s.s $f29, 152($sp)
s.s $f31, _0_rise
li $v0, 0
# start of epilogue
lw $s3, 16($sp)
lw $s0, 20($sp)
lw $s1, 24($sp)
lw $s2, 28($sp)
lw $s4, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 168
# end of epilogue
jr $ra
