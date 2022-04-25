.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -204
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
li $s0, 0
sw $s0, 100($sp)
li.s $f4, 0.0
s.s $f4, 116($sp)
li.s $f5, 1.0
s.s $f5, 120($sp)
l.s $f6, 116($sp)
l.s $f7, 120($sp)
l.s $f8, 124($sp)
add.s $f8, $f6, $f7
s.s $f8, 124($sp)
l.s $f9, 124($sp)
s.s $f9, 116($sp)
l.s $f10, 116($sp)
l.s $f11, 120($sp)
l.s $f16, 128($sp)
add.s $f16, $f10, $f11
s.s $f16, 128($sp)
l.s $f17, 128($sp)
s.s $f17, 116($sp)
l.s $f18, 116($sp)
l.s $f19, 120($sp)
l.s $f20, 132($sp)
add.s $f20, $f18, $f19
s.s $f20, 132($sp)
l.s $f20, 132($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 136($sp)
add.s $f22, $f20, $f21
s.s $f22, 136($sp)
l.s $f20, 136($sp)
s.s $f20, 116($sp)
_L0:
li $s0, 0
sw $s0, 104($sp)
lw $t0, 100($sp)
li $t1, 10
bge $t0, $t1, _L1
li $s0, 1
sw $s0, 104($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 140($sp)
add.s $f22, $f20, $f21
s.s $f22, 140($sp)
l.s $f20, 140($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 144($sp)
add.s $f22, $f20, $f21
s.s $f22, 144($sp)
l.s $f20, 144($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 148($sp)
add.s $f22, $f20, $f21
s.s $f22, 148($sp)
l.s $f20, 148($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 152($sp)
add.s $f22, $f20, $f21
s.s $f22, 152($sp)
l.s $f20, 152($sp)
s.s $f20, 116($sp)
li $s0, 0
sw $s0, 108($sp)
lw $t0, 100($sp)
li $t1, 5
bge $t0, $t1, _L2
li $s0, 1
sw $s0, 108($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 156($sp)
add.s $f22, $f20, $f21
s.s $f22, 156($sp)
l.s $f20, 156($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 160($sp)
add.s $f22, $f20, $f21
s.s $f22, 160($sp)
l.s $f20, 160($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 164($sp)
add.s $f22, $f20, $f21
s.s $f22, 164($sp)
l.s $f20, 164($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 168($sp)
add.s $f22, $f20, $f21
s.s $f22, 168($sp)
l.s $f20, 168($sp)
s.s $f20, 116($sp)
j _L3
_L2:
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 172($sp)
sub.s $f22, $f20, $f21
s.s $f22, 172($sp)
l.s $f20, 172($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 176($sp)
sub.s $f22, $f20, $f21
s.s $f22, 176($sp)
l.s $f20, 176($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 180($sp)
sub.s $f22, $f20, $f21
s.s $f22, 180($sp)
l.s $f20, 180($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 184($sp)
sub.s $f22, $f20, $f21
s.s $f22, 184($sp)
l.s $f20, 184($sp)
s.s $f20, 116($sp)
_L3:
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 188($sp)
add.s $f22, $f20, $f21
s.s $f22, 188($sp)
l.s $f20, 188($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 192($sp)
add.s $f22, $f20, $f21
s.s $f22, 192($sp)
l.s $f20, 192($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 196($sp)
add.s $f22, $f20, $f21
s.s $f22, 196($sp)
l.s $f20, 196($sp)
s.s $f20, 116($sp)
l.s $f20, 116($sp)
l.s $f21, 120($sp)
l.s $f22, 200($sp)
add.s $f22, $f20, $f21
s.s $f22, 200($sp)
l.s $f20, 200($sp)
s.s $f20, 116($sp)
lw $s0, 100($sp)
li $s1, 1
lw $s2, 112($sp)
add $s2, $s0, $s1
sw $s2, 112($sp)
lw $s0, 112($sp)
sw $s0, 100($sp)
j _L0
_L1:
li $v0, 2
l.s $f20, 116($sp)
mov.s $f12, $f20
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
addiu $sp, $sp, 204
# end of epilogue
jr $ra
