.data
newline: .asciiz "\n"
_0_n: .word 0
_0_m: .word 0
__0_A[128]: .float 0.0
__0_b[16]: .float 0.0
__0_x[8]: .float 0.0
.text
.globl main
naive_mod:
# start of prologue
addiu $sp, $sp, -72
sw $a0, 56($sp)
sw $a1, 60($sp)
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
lw $s0, 56($sp)
sw $s0, 64($sp)
_L0:
li $s0, 0
sw $s0, 52($sp)
lw $s0, 64($sp)
lw $s1, 60($sp)
ble $s0, $s1, _L1
li $s0, 1
sw $s0, 52($sp)
lw $s0, 64($sp)
lw $s1, 60($sp)
lw $s2, 68($sp)
sub $s2, $s0, $s1
sw $s2, 68($sp)
lw $s0, 68($sp)
sw $s0, 64($sp)
j _L0
_L1:
lw $v0, 64($sp)
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
addiu $sp, $sp, 72
# end of epilogue
jr $ra
init_data:
# start of prologue
addiu $sp, $sp, -124
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
li $s0, 8
sw $s0, _0_m
li $s0, 16
sw $s0, _0_n
li $s0, 0
sw $s0, 52($sp)
_L2:
lw $s0, 52($sp)
lw $s1, 60($sp)
bgt $s0, $s1, _L3
lw $s0, _0_m
lw $s1, _0_n
lw $s2, 56($sp)
mul $s2, $s0, $s1
sw $s2, 56($sp)
lw $s0, 56($sp)
li $s1, 1
lw $s2, 60($sp)
sub $s2, $s0, $s1
sw $s2, 60($sp)
lw $s0, 52($sp)
mtc1 $s0, $f5
cvt.s.w $f5, $f5
s.s $f5, 52($sp)
lw $s0, 88($sp)
mtc1 $s0, $f6
cvt.s.w $f6, $f6
s.s $f6, 88($sp)
li.s $f4, 3.0
l.s $f5, 52($sp)
l.s $f6, 88($sp)
mul.s $f6, $f4, $f5
s.s $f6, 88($sp)
l.s $f5, 52($sp)
cvt.w.s $f5, $f5
mtc1 $s0, $f5
sw $s0, 52($sp)
lw $s0, 88($sp)
li $s1, 1
lw $s2, 92($sp)
add $s2, $s0, $s1
sw $s2, 92($sp)
lw $a0, 92($sp)
li.s $f13, 19.0
jal naive_mod
sw $v0, 80($sp)
lw $s0, 52($sp)
mtc1 $s0, $f8
cvt.s.w $f8, $f8
s.s $f8, 52($sp)
lw $s0, 96($sp)
mtc1 $s0, $f9
cvt.s.w $f9, $f9
s.s $f9, 96($sp)
l.s $f8, 52($sp)
li.s $f7, 5.0
l.s $f9, 96($sp)
add.s $f9, $f8, $f7
s.s $f9, 96($sp)
l.s $f8, 52($sp)
cvt.w.s $f8, $f8
mtc1 $s0, $f8
sw $s0, 52($sp)
lw $a0, 96($sp)
li.s $f13, 23.0
jal naive_mod
sw $v0, 84($sp)
lw $s0, 80($sp)
lw $s1, 84($sp)
lw $s2, 100($sp)
mul $s2, $s0, $s1
sw $s2, 100($sp)
lw $s0, 100($sp)
mtc1 $s0, $f11
cvt.s.w $f11, $f11
s.s $f11, 100($sp)
lw $s0, 104($sp)
mtc1 $s0, $f16
cvt.s.w $f16, $f16
s.s $f16, 104($sp)
l.s $f11, 100($sp)
li.s $f10, 10.0
l.s $f16, 104($sp)
div.s $f16, $f11, $f10
s.s $f16, 104($sp)
l.s $f11, 100($sp)
cvt.w.s $f11, $f11
mtc1 $s0, $f11
sw $s0, 100($sp)
lw $s0, 104($sp)
mtc1 $s0, $f18
cvt.s.w $f18, $f18
s.s $f18, 104($sp)
lw $s0, 108($sp)
mtc1 $s0, $f19
cvt.s.w $f19, $f19
s.s $f19, 108($sp)
l.s $f18, 104($sp)
li.s $f17, 8.0
l.s $f19, 108($sp)
sub.s $f19, $f18, $f17
s.s $f19, 108($sp)
l.s $f18, 104($sp)
cvt.w.s $f18, $f18
mtc1 $s0, $f18
sw $s0, 104($sp)
la $s0, _0_A
lw $s1, 108($sp)
la $s2, _0_A
lw $s3, 108($sp)
lw $s4, 52($sp)
li $s5, 4
mul $s5, $s4, $s5
addu $s2, $s2, $s5
sw $s3, ($s2)
lw $s2, 52($sp)
li $s3, 1
lw $s4, 52($sp)
add $s4, $s2, $s3
sw $s4, 52($sp)
j _L2
_L3:
li $s2, 0
sw $s2, 52($sp)
_L4:
lw $s2, 52($sp)
lw $s3, 68($sp)
bgt $s2, $s3, _L5
lw $s2, _0_m
li $s3, 1
lw $s4, 68($sp)
sub $s4, $s2, $s3
sw $s4, 68($sp)
lw $s2, 52($sp)
mtc1 $s2, $f21
cvt.s.w $f21, $f21
s.s $f21, 52($sp)
lw $s2, 112($sp)
mtc1 $s2, $f22
cvt.s.w $f22, $f22
s.s $f22, 112($sp)
l.s $f21, 52($sp)
li.s $f20, 3.5
l.s $f22, 112($sp)
sub.s $f22, $f21, $f20
s.s $f22, 112($sp)
l.s $f21, 52($sp)
cvt.w.s $f21, $f21
mtc1 $s2, $f21
sw $s2, 52($sp)
li $s2, 1
sw $s2, 72($sp)
lw $s2, 112($sp)
sw $s2, 116($sp)
_L6:
lw $s2, 72($sp)
li $s3, 2
bge $s2, $s3, _L7
lw $s2, 116($sp)
lw $s3, 112($sp)
lw $s4, 116($sp)
mul $s4, $s2, $s3
sw $s4, 116($sp)
lw $s2, 72($sp)
li $s3, 1
lw $s4, 72($sp)
add $s4, $s2, $s3
sw $s4, 72($sp)
j _L6
_L7:
lw $s2, 116($sp)
li $s3, 6
lw $s4, 120($sp)
sub $s4, $s2, $s3
sw $s4, 120($sp)
la $s2, _0_x
lw $s3, 120($sp)
la $s4, _0_x
lw $s5, 120($sp)
lw $s6, 52($sp)
li $s7, 4
mul $s7, $s6, $s7
addu $s4, $s4, $s7
sw $s5, ($s4)
lw $s4, 52($sp)
li $s5, 1
lw $s6, 52($sp)
add $s6, $s4, $s5
sw $s6, 52($sp)
j _L4
_L5:
# start of epilogue
lw $s4, 16($sp)
lw $s5, 20($sp)
lw $s6, 24($sp)
lw $s7, 28($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 124
# end of epilogue
jr $ra
matrix_vector_mult:
# start of prologue
addiu $sp, $sp, -104
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
li $s0, 0
sw $s0, 56($sp)
_L8:
lw $s0, 56($sp)
lw $s1, 60($sp)
bgt $s0, $s1, _L9
lw $s0, _0_n
li $s1, 1
lw $s2, 60($sp)
sub $s2, $s0, $s1
sw $s2, 60($sp)
la $s0, _0_b
li $s1, 0.0
la $s2, _0_b
li $s3, 0.0
lw $s4, 56($sp)
li $s5, 4
mul $s5, $s4, $s5
addu $s2, $s2, $s5
sw $s3, ($s2)
li $s2, 0
sw $s2, 52($sp)
_L10:
lw $s2, 52($sp)
lw $s3, 64($sp)
bgt $s2, $s3, _L11
lw $s2, _0_m
li $s3, 1
lw $s4, 64($sp)
sub $s4, $s2, $s3
sw $s4, 64($sp)
la $s2, _0_b
la $s3, _0_b
lw $s4, 56($sp)
li $s5, 4
mul $s5, $s4, $s5
addu $s3, $s3, $s5
lw $s6, ($s3)
sw $s6, 84($sp)
la $s3, _0_x
la $s6, _0_x
lw $s4, 52($sp)
li $s5, 4
mul $s5, $s4, $s5
addu $s6, $s6, $s5
lw $s7, ($s6)
sw $s7, 88($sp)
lw $s6, _0_m
lw $s7, 56($sp)
lw $s4, 68($sp)
mul $s4, $s6, $s7
sw $s4, 68($sp)
lw $s6, 68($sp)
lw $s7, 52($sp)
lw $s4, 72($sp)
add $s4, $s6, $s7
sw $s4, 72($sp)
la $s6, _0_A
la $s7, _0_A
lw $s4, 72($sp)
li $s5, 4
mul $s5, $s4, $s5
addu $s7, $s7, $s5
lw $t0, ($s7)
sw $t0, 92($sp)
lw $s7, 88($sp)
lw $s4, 92($sp)
lw $s5, 96($sp)
mul $s5, $s7, $s4
sw $s5, 96($sp)
lw $s7, 84($sp)
lw $s4, 96($sp)
lw $s5, 100($sp)
add $s5, $s7, $s4
sw $s5, 100($sp)
la $s7, _0_b
lw $s4, 100($sp)
la $s5, _0_b
lw $t0, 100($sp)
lw $t1, 56($sp)
li $t2, 4
mul $t2, $t1, $t2
addu $s5, $s5, $t2
sw $t0, ($s5)
lw $s5, 52($sp)
li $t0, 1
lw $t1, 52($sp)
add $t1, $s5, $t0
sw $t1, 52($sp)
j _L10
_L11:
lw $s5, 56($sp)
li $t0, 1
lw $t1, 56($sp)
add $t1, $s5, $t0
sw $t1, 56($sp)
j _L8
_L9:
# start of epilogue
lw $s5, 16($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 104
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -68
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
jal init_data
jal matrix_vector_mult
li $s0, 0
sw $s0, 52($sp)
_L12:
lw $s0, 52($sp)
lw $s1, 56($sp)
bgt $s0, $s1, _L13
lw $s0, _0_n
li $s1, 1
lw $s2, 56($sp)
sub $s2, $s0, $s1
sw $s2, 56($sp)
la $s0, _0_b
la $s1, _0_b
lw $s2, 52($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s4, ($s1)
sw $s4, 64($sp)
li $v0, 2
l.s $f4, 64($sp)
mov.s $f12, $f4
syscall
li $v0, 4
la $a0, newline
syscall
lw $s1, 52($sp)
li $s4, 1
lw $s2, 52($sp)
add $s2, $s1, $s4
sw $s2, 52($sp)
j _L12
_L13:
li $v0, 0
# start of epilogue
lw $s1, 16($sp)
lw $s4, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s5, 32($sp)
lw $s6, 36($sp)
lw $s7, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 68
# end of epilogue
jr $ra
