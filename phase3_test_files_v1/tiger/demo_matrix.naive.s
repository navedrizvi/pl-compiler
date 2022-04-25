.data
newline: .asciiz "\n"
_0_n: .word 0
_0_m: .word 0
.text
.globl main
naive_mod:
# start of prologue
addiu $sp, $sp, -72
s.s $f12, 56($sp)
s.s $f13, 60($sp)
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
l.s $f7, 56($sp)
s.s $f7, 64($sp)
_L0:
li $s3, 0
sw $s3, 52($sp)
l.s $f6, 64($sp)
l.s $f5, 60($sp)
c.le.s $f6, $f5
bc1t _L1
li $s3, 1
sw $s3, 52($sp)
l.s $f4, 64($sp)
l.s $f23, 60($sp)
l.s $f22, 68($sp)
sub.s $f22, $f4, $f23
s.s $f22, 68($sp)
l.s $f23, 68($sp)
s.s $f23, 64($sp)
j _L0
_L1:
lw $v0, 64($sp)
# start of epilogue
lw $s3, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
l.s $f20, 32($sp)
l.s $f21, 36($sp)
l.s $f22, 40($sp)
l.s $f23, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 72
# end of epilogue
jr $ra
init_data:
# start of prologue
addiu $sp, $sp, -124
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
li $s3, 8
sw $s3, _0_m
li $s3, 16
sw $s3, _0_n
li $s3, 0
sw $s3, 52($sp)
_L2:
lw $t3, 52($sp)
lw $t2, 60($sp)
bgt $t3, $t2, _L3
lw $s3, _0_m
lw $s2, _0_n
lw $s1, 56($sp)
mul $s1, $s3, $s2
sw $s1, 56($sp)
lw $s3, 56($sp)
li $s2, 1
lw $s1, 60($sp)
sub $s1, $s3, $s2
sw $s1, 60($sp)
lw $s3, 52($sp)
mtc1 $s3, $f5
cvt.s.w $f5, $f5
s.s $f5, 52($sp)
li.s $f6, 3.0
l.s $f5, 52($sp)
l.s $f7, 88($sp)
mul.s $f7, $f6, $f5
s.s $f7, 88($sp)
l.s $f5, 52($sp)
cvt.w.s $f5, $f5
mtc1 $s3, $f5
sw $s3, 52($sp)
li $s3, 1
mtc1 $s3, $f22
cvt.s.w $f22, $f22
l.s $f4, 88($sp)
li.s $f22, 1.0
l.s $f23, 92($sp)
add.s $f23, $f4, $f22
s.s $f23, 92($sp)
l.s $f12, 92($sp)
li.s $f13, 19.0
jal naive_mod
sw $v0, 80($sp)
lw $s3, 52($sp)
mtc1 $s3, $f21
cvt.s.w $f21, $f21
s.s $f21, 52($sp)
l.s $f21, 52($sp)
li.s $f20, 5.0
l.s $f23, 96($sp)
add.s $f23, $f21, $f20
s.s $f23, 96($sp)
l.s $f21, 52($sp)
cvt.w.s $f21, $f21
mtc1 $s3, $f21
sw $s3, 52($sp)
l.s $f12, 96($sp)
li.s $f13, 23.0
jal naive_mod
sw $v0, 84($sp)
l.s $f21, 80($sp)
l.s $f20, 84($sp)
l.s $f23, 100($sp)
mul.s $f23, $f21, $f20
s.s $f23, 100($sp)
l.s $f21, 100($sp)
li.s $f23, 10.0
l.s $f20, 104($sp)
div.s $f20, $f21, $f23
s.s $f20, 104($sp)
l.s $f21, 104($sp)
li.s $f20, 8.0
l.s $f23, 108($sp)
sub.s $f23, $f21, $f20
s.s $f23, 108($sp)
la $s3, _0_A
lw $s2, 108($sp)
la $s1, _0_A
lw $s0, 108($sp)
lw $t3, 52($sp)
li $t2, 4
mul $t2, $t3, $t2
addu $s1, $s1, $t2
sw $s0, ($s1)
lw $s1, 52($sp)
li $s0, 1
lw $t3, 52($sp)
add $t3, $s1, $s0
sw $t3, 52($sp)
j _L2
_L3:
li $s1, 0
sw $s1, 52($sp)
_L4:
lw $t3, 52($sp)
lw $t2, 68($sp)
bgt $t3, $t2, _L5
lw $s1, _0_m
li $s0, 1
lw $t3, 68($sp)
sub $t3, $s1, $s0
sw $t3, 68($sp)
lw $s1, 52($sp)
mtc1 $s1, $f20
cvt.s.w $f20, $f20
s.s $f20, 52($sp)
l.s $f20, 52($sp)
li.s $f23, 3.5
l.s $f21, 112($sp)
sub.s $f21, $f20, $f23
s.s $f21, 112($sp)
l.s $f20, 52($sp)
cvt.w.s $f20, $f20
mtc1 $s1, $f20
sw $s1, 52($sp)
li $s1, 1
sw $s1, 72($sp)
l.s $f20, 112($sp)
s.s $f20, 116($sp)
_L6:
lw $t3, 72($sp)
li $t2, 2
bge $t3, $t2, _L7
l.s $f20, 116($sp)
l.s $f23, 112($sp)
l.s $f21, 116($sp)
mul.s $f21, $f20, $f23
s.s $f21, 116($sp)
lw $s1, 72($sp)
li $s0, 1
lw $t3, 72($sp)
add $t3, $s1, $s0
sw $t3, 72($sp)
j _L6
_L7:
li $s1, 6
mtc1 $s1, $f21
cvt.s.w $f21, $f21
l.s $f20, 116($sp)
li.s $f21, 6.0
l.s $f23, 120($sp)
sub.s $f23, $f20, $f21
s.s $f23, 120($sp)
la $s1, _0_x
lw $s0, 120($sp)
la $t3, _0_x
lw $t2, 120($sp)
lw $t1, 52($sp)
li $t0, 4
mul $t0, $t1, $t0
addu $t3, $t3, $t0
sw $t2, ($t3)
lw $t3, 52($sp)
li $t2, 1
lw $t1, 52($sp)
add $t1, $t3, $t2
sw $t1, 52($sp)
j _L4
_L5:
# start of epilogue
l.s $f23, 16($sp)
l.s $f20, 20($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 124
# end of epilogue
jr $ra
matrix_vector_mult:
# start of prologue
addiu $sp, $sp, -104
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
li $s3, 0
sw $s3, 56($sp)
_L8:
lw $t3, 56($sp)
lw $t2, 60($sp)
bgt $t3, $t2, _L9
lw $s3, _0_n
li $s2, 1
lw $s1, 60($sp)
sub $s1, $s3, $s2
sw $s1, 60($sp)
la $s3, _0_b
li $s2, 0.0
la $s1, _0_b
li $s0, 0.0
lw $t3, 56($sp)
li $t2, 4
mul $t2, $t3, $t2
addu $s1, $s1, $t2
sw $s0, ($s1)
li $s1, 0
sw $s1, 52($sp)
_L10:
lw $t3, 52($sp)
lw $t2, 64($sp)
bgt $t3, $t2, _L11
lw $s1, _0_m
li $s0, 1
lw $t3, 64($sp)
sub $t3, $s1, $s0
sw $t3, 64($sp)
la $s1, _0_b
la $s0, _0_b
lw $t3, 56($sp)
li $t2, 4
mul $t2, $t3, $t2
addu $s0, $s0, $t2
lw $t1, ($s0)
sw $t1, 84($sp)
la $s0, _0_x
la $t1, _0_x
lw $t3, 52($sp)
li $t2, 4
mul $t2, $t3, $t2
addu $t1, $t1, $t2
lw $t0, ($t1)
sw $t0, 88($sp)
lw $t1, _0_m
lw $t0, 56($sp)
lw $t3, 68($sp)
mul $t3, $t1, $t0
sw $t3, 68($sp)
lw $t1, 68($sp)
lw $t0, 52($sp)
lw $t3, 72($sp)
add $t3, $t1, $t0
sw $t3, 72($sp)
la $t1, _0_A
la $t0, _0_A
lw $t3, 72($sp)
li $t2, 4
mul $t2, $t3, $t2
addu $t0, $t0, $t2
lw $t9, ($t0)
sw $t9, 92($sp)
l.s $f7, 88($sp)
l.s $f6, 92($sp)
l.s $f5, 96($sp)
mul.s $f5, $f7, $f6
s.s $f5, 96($sp)
l.s $f4, 84($sp)
l.s $f23, 96($sp)
l.s $f22, 100($sp)
add.s $f22, $f4, $f23
s.s $f22, 100($sp)
la $t0, _0_b
lw $t3, 100($sp)
la $t2, _0_b
lw $t9, 100($sp)
lw $t8, 56($sp)
li $v1, 4
mul $v1, $t8, $v1
addu $t2, $t2, $v1
sw $t9, ($t2)
lw $t2, 52($sp)
li $t9, 1
lw $t8, 52($sp)
add $t8, $t2, $t9
sw $t8, 52($sp)
j _L10
_L11:
lw $t2, 56($sp)
li $t9, 1
lw $t8, 56($sp)
add $t8, $t2, $t9
sw $t8, 56($sp)
j _L8
_L9:
# start of epilogue
l.s $f20, 16($sp)
l.s $f21, 20($sp)
l.s $f22, 24($sp)
l.s $f23, 28($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 104
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -68
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
jal init_data
jal matrix_vector_mult
li $s3, 0
sw $s3, 52($sp)
_L12:
lw $t3, 52($sp)
lw $t2, 56($sp)
bgt $t3, $t2, _L13
lw $s3, _0_n
li $s2, 1
lw $s1, 56($sp)
sub $s1, $s3, $s2
sw $s1, 56($sp)
la $s3, _0_b
la $s2, _0_b
lw $s1, 52($sp)
li $s0, 4
mul $s0, $s1, $s0
addu $s2, $s2, $s0
lw $t3, ($s2)
sw $t3, 64($sp)
li $v0, 2
l.s $f7, 64($sp)
mov.s $f12, $f7
syscall
li $v0, 4
la $a0, newline
syscall
lw $s2, 52($sp)
li $s1, 1
lw $s0, 52($sp)
add $s0, $s2, $s1
sw $s0, 52($sp)
j _L12
_L13:
li $v0, 0
# start of epilogue
lw $s2, 16($sp)
lw $s1, 20($sp)
lw $s0, 24($sp)
l.s $f20, 28($sp)
l.s $f21, 32($sp)
l.s $f22, 36($sp)
l.s $f23, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 68
# end of epilogue
jr $ra
