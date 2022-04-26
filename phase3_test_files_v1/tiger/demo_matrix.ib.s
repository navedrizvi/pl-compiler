.data
newline: .asciiz "\n"
_0_n: .word 0
_0_m: .word 0
_0_A: .float 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
_0_b: .float 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
_0_x: .float 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
.text
.globl main
naive_mod:
# start of prologue
addiu $sp, $sp, -120
s.s $f12, 104($sp)
s.s $f13, 108($sp)
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
l.s $f20, 112($sp)
l.s $f21, 104($sp)
mov.s $f20, $f21
s.s $f20, 112($sp)
s.s $f21, 104($sp)
_L0:
lw $s0, 100($sp)
l.s $f21, 108($sp)
l.s $f20, 112($sp)
li $s1, 0
move $s0, $s1
sw $s0, 100($sp)
s.s $f21, 108($sp)
s.s $f20, 112($sp)
c.le.s $f20, $f21
bc1t _L1
lw $s0, 100($sp)
l.s $f22, 108($sp)
l.s $f20, 112($sp)
l.s $f21, 116($sp)
li $s1, 1
move $s0, $s1
sub.s $f21, $f20, $f22
s.s $f21, 116($sp)
mov.s $f20, $f21
sw $s0, 100($sp)
s.s $f22, 108($sp)
s.s $f20, 112($sp)
s.s $f21, 116($sp)
j _L0
_L1:
l.s $f21, 112($sp)
s.s $f21, 112($sp)
lw $v0, 112($sp)
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
addiu $sp, $sp, 120
# end of epilogue
jr $ra
init_data:
# start of prologue
addiu $sp, $sp, -172
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
lw $s0, _0_m
lw $s1, 100($sp)
lw $s2, _0_n
li $s3, 8
move $s0, $s3
li $s3, 16
move $s2, $s3
li $s3, 0
move $s1, $s3
sw $s0, _0_m
sw $s1, 100($sp)
sw $s2, _0_n
_L2:
lw $s2, 100($sp)
lw $s1, 108($sp)
sw $s2, 100($sp)
sw $s1, 108($sp)
bgt $s2, $s1, _L3
l.s $f20, 144($sp)
l.s $f21, 140($sp)
l.s $f22, 152($sp)
l.s $f23, 148($sp)
l.s $f24, 156($sp)
lw $s0, _0_n
l.s $f25, 128($sp)
l.s $f26, 132($sp)
lw $s1, 100($sp)
lw $s3, _0_m
lw $s2, 104($sp)
l.s $f27, 136($sp)
lw $s4, 108($sp)
mul $s2, $s3, $s0
sw $s2, 104($sp)
li $s5, 1
sub $s4, $s2, $s5
sw $s4, 108($sp)
move $s5, $s1
mtc1 $s5, $f5
cvt.s.w $f5, $f5















move $s1, $f5
li.s $f4, 3.0
move $f5, $s1
mul.s $f27, $f4, $f5
s.s $f27, 136($sp)
move $f5, $s1








cvt.w.s $f5, $f5
mtc1 $s5, $f5
move $s1, $s5
li $s5, 1
mtc1 $s5, $f6
cvt.s.w $f6, $f6
li.s $f6, 1.0
add.s $f21, $f27, $f6
s.s $f21, 140($sp)
mov.s $f12, $f21
li.s $f13, 19.0
s.s $f20, 144($sp)
s.s $f21, 140($sp)
s.s $f22, 152($sp)
s.s $f23, 148($sp)
s.s $f24, 156($sp)
sw $s0, _0_n
s.s $f25, 128($sp)
s.s $f26, 132($sp)
sw $s1, 100($sp)
sw $s3, _0_m
sw $s2, 104($sp)
s.s $f27, 136($sp)
sw $s4, 108($sp)
jal naive_mod
l.s $f20, 144($sp)
l.s $f21, 140($sp)
l.s $f22, 152($sp)
l.s $f23, 148($sp)
l.s $f24, 156($sp)
lw $s0, _0_n
l.s $f25, 128($sp)
l.s $f26, 132($sp)
lw $s1, 100($sp)
lw $s3, _0_m
lw $s2, 104($sp)
l.s $f27, 136($sp)
lw $s4, 108($sp)
mov.s $f25, $f0
move $s5, $s1
mtc1 $s5, $f7
cvt.s.w $f7, $f7



move $s1, $f7
move $f7, $s1
li.s $f8, 5.0
add.s $f20, $f7, $f8
s.s $f20, 144($sp)
move $f7, $s1
cvt.w.s $f7, $f7
mtc1 $s5, $f7



move $s1, $s5
mov.s $f12, $f20
li.s $f13, 23.0
s.s $f20, 144($sp)
s.s $f21, 140($sp)
s.s $f22, 152($sp)
s.s $f23, 148($sp)
s.s $f24, 156($sp)
sw $s0, _0_n
s.s $f25, 128($sp)
s.s $f26, 132($sp)
sw $s1, 100($sp)
sw $s3, _0_m
sw $s2, 104($sp)
s.s $f27, 136($sp)
sw $s4, 108($sp)
jal naive_mod
l.s $f20, 144($sp)
l.s $f21, 140($sp)
l.s $f22, 152($sp)
l.s $f23, 148($sp)
l.s $f24, 156($sp)
lw $s0, _0_n
l.s $f25, 128($sp)
l.s $f26, 132($sp)
lw $s1, 100($sp)
lw $s3, _0_m
lw $s2, 104($sp)
l.s $f27, 136($sp)
lw $s4, 108($sp)
mov.s $f26, $f0
mul.s $f23, $f25, $f26
s.s $f23, 148($sp)
li.s $f9, 10.0
div.s $f22, $f23, $f9
s.s $f22, 152($sp)
li.s $f10, 8.0
sub.s $f24, $f22, $f10
s.s $f24, 156($sp)
la $s5, _0_A
move $s6, $s1
li $s7, 4
mul $s7, $s6, $s7
addu $s5, $s5, $s7
mov.s $f11, $f24
s.s $f11, ($s5)
li $s5, 1
add $s1, $s1, $s5
sw $s1, 100($sp)
s.s $f20, 144($sp)
s.s $f21, 140($sp)
s.s $f22, 152($sp)
s.s $f23, 148($sp)
s.s $f24, 156($sp)
sw $s0, _0_n
s.s $f25, 128($sp)
s.s $f26, 132($sp)
sw $s1, 100($sp)
sw $s3, _0_m
sw $s2, 104($sp)
s.s $f27, 136($sp)
sw $s4, 108($sp)
j _L2
_L3:
lw $s4, 100($sp)
li $s2, 0
move $s4, $s2
sw $s4, 100($sp)
_L4:
lw $s4, 100($sp)
lw $s2, 116($sp)
sw $s4, 100($sp)
sw $s2, 116($sp)
bgt $s4, $s2, _L5
lw $s2, _0_m
lw $s4, 100($sp)
l.s $f26, 164($sp)
lw $s3, 116($sp)
l.s $f27, 160($sp)
lw $s1, 120($sp)
li $s0, 1
sub $s3, $s2, $s0
sw $s3, 116($sp)
move $s0, $s4
mtc1 $s0, $f16
cvt.s.w $f16, $f16


move $s4, $f16
move $f16, $s4


li.s $f17, 3.5
sub.s $f27, $f16, $f17
s.s $f27, 160($sp)


move $f16, $s4
cvt.w.s $f16, $f16
mtc1 $s0, $f16
move $s4, $s0


li $s0, 1
move $s1, $s0
mov.s $f26, $f27
sw $s2, _0_m
sw $s4, 100($sp)
s.s $f26, 164($sp)
sw $s3, 116($sp)
s.s $f27, 160($sp)
sw $s1, 120($sp)
_L6:
lw $s1, 120($sp)
sw $s1, 120($sp)
li $t0, 2
bge $s1, $t0, _L7
l.s $f27, 164($sp)
l.s $f26, 160($sp)
lw $s1, 120($sp)
mul.s $f27, $f27, $f26
s.s $f27, 164($sp)
li $s3, 1
add $s1, $s1, $s3
sw $s1, 120($sp)
s.s $f27, 164($sp)
s.s $f26, 160($sp)
sw $s1, 120($sp)
j _L6
_L7:
lw $s1, 100($sp)
l.s $f27, 164($sp)
l.s $f26, 168($sp)
li $s3, 6
mtc1 $s3, $f18
cvt.s.w $f18, $f18
li.s $f18, 6.0
sub.s $f26, $f27, $f18
s.s $f26, 168($sp)
la $s3, _0_x
move $s4, $s1
li $s2, 4
mul $s2, $s4, $s2
addu $s3, $s3, $s2
mov.s $f19, $f26
s.s $f19, ($s3)
li $s3, 1
add $s1, $s1, $s3
sw $s1, 100($sp)
sw $s1, 100($sp)
s.s $f27, 164($sp)
s.s $f26, 168($sp)
j _L4
_L5:
# start of epilogue
lw $s1, 16($sp)
lw $s3, 20($sp)
lw $s4, 24($sp)
lw $s2, 28($sp)
lw $s0, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
l.s $f31, 48($sp)
l.s $f30, 52($sp)
l.s $f29, 56($sp)
l.s $f28, 60($sp)
l.s $f20, 64($sp)
l.s $f21, 68($sp)
l.s $f22, 72($sp)
l.s $f23, 76($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 172
# end of epilogue
jr $ra
matrix_vector_mult:
# start of prologue
addiu $sp, $sp, -152
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
lw $s0, 104($sp)
li $s1, 0
move $s0, $s1
sw $s0, 104($sp)
_L8:
lw $s0, 104($sp)
lw $s1, 108($sp)
sw $s0, 104($sp)
sw $s1, 108($sp)
bgt $s0, $s1, _L9
lw $s1, 104($sp)
lw $s0, 108($sp)
lw $s2, 100($sp)
lw $s3, _0_n
li $s4, 1
sub $s0, $s3, $s4
sw $s0, 108($sp)
la $s4, _0_b
move $s5, $s1
li $s6, 4
mul $s6, $s5, $s6
addu $s4, $s4, $s6
li.s $f4, 0.0
s.s $f4, ($s4)
li $s4, 0
move $s2, $s4
sw $s1, 104($sp)
sw $s0, 108($sp)
sw $s2, 100($sp)
sw $s3, _0_n
_L10:
lw $s3, 112($sp)
lw $s2, 100($sp)
sw $s3, 112($sp)
sw $s2, 100($sp)
bgt $s2, $s3, _L11
lw $s5, 112($sp)
l.s $f20, 132($sp)
lw $s3, 104($sp)
lw $s0, _0_m
l.s $f21, 148($sp)
lw $s1, 116($sp)
lw $s2, 100($sp)
lw $s4, 120($sp)
l.s $f22, 140($sp)
l.s $f23, 144($sp)
l.s $f24, 136($sp)
li $s6, 1
sub $s5, $s0, $s6
sw $s5, 112($sp)
la $s6, _0_b
move $s7, $s3
li $t0, 4
mul $t0, $s7, $t0
addu $s6, $s6, $t0
l.s $f5, ($s6)
mov.s $f20, $f5
la $s6, _0_x
move $s7, $s2
li $t0, 4
mul $t0, $s7, $t0
addu $s6, $s6, $t0
l.s $f6, ($s6)
mov.s $f24, $f6
mul $s1, $s0, $s3
sw $s1, 116($sp)
add $s4, $s1, $s2
sw $s4, 120($sp)
la $s6, _0_A
move $s7, $s4
li $t0, 4
mul $t0, $s7, $t0
addu $s6, $s6, $t0
l.s $f7, ($s6)
mov.s $f22, $f7
mul.s $f23, $f24, $f22
s.s $f23, 144($sp)
add.s $f21, $f20, $f23
s.s $f21, 148($sp)
la $s6, _0_b
move $s7, $s3
li $t0, 4
mul $t0, $s7, $t0
addu $s6, $s6, $t0
mov.s $f8, $f21
s.s $f8, ($s6)
li $s6, 1
add $s2, $s2, $s6
sw $s2, 100($sp)
sw $s5, 112($sp)
s.s $f20, 132($sp)
sw $s3, 104($sp)
sw $s0, _0_m
s.s $f21, 148($sp)
sw $s1, 116($sp)
sw $s2, 100($sp)
sw $s4, 120($sp)
s.s $f22, 140($sp)
s.s $f23, 144($sp)
s.s $f24, 136($sp)
j _L10
_L11:
lw $s4, 104($sp)
li $s2, 1
add $s4, $s4, $s2
sw $s4, 104($sp)
sw $s4, 104($sp)
j _L8
_L9:
# start of epilogue
lw $s4, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
lw $s3, 32($sp)
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
l.s $f20, 76($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 152
# end of epilogue
jr $ra
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
lw $s0, 100($sp)
sw $s0, 100($sp)
jal init_data
lw $s0, 100($sp)
sw $s0, 100($sp)
jal matrix_vector_mult
lw $s0, 100($sp)
li $s1, 0
move $s0, $s1
sw $s0, 100($sp)
_L12:
lw $s0, 104($sp)
lw $s1, 100($sp)
sw $s0, 104($sp)
sw $s1, 100($sp)
bgt $s1, $s0, _L13
l.s $f20, 112($sp)
lw $s0, 104($sp)
lw $s1, 100($sp)
lw $s2, _0_n
li $s3, 1
sub $s0, $s2, $s3
sw $s0, 104($sp)
la $s3, _0_b
move $s4, $s1
li $s5, 4
mul $s5, $s4, $s5
addu $s3, $s3, $s5
l.s $f4, ($s3)
mov.s $f20, $f4
li $v0, 2
l.s $f5, 112($sp)
mov.s $f12, $f5
syscall
li $v0, 4
la $a0, newline
syscall
li $s3, 1
add $s1, $s1, $s3
sw $s1, 100($sp)
s.s $f20, 112($sp)
sw $s0, 104($sp)
sw $s1, 100($sp)
sw $s2, _0_n
j _L12
_L13:
li $v0, 0
# start of epilogue
lw $s2, 16($sp)
lw $s1, 20($sp)
lw $s0, 24($sp)
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
addiu $sp, $sp, 116
# end of epilogue
jr $ra
