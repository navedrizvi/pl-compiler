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
lw $s0, 100($sp)
l.s $f22, 124($sp)
l.s $f23, 132($sp)
l.s $f21, 120($sp)
l.s $f24, 128($sp)
l.s $f20, 116($sp)
l.s $f25, 136($sp)
li $s1, 0
move $s0, $s1
li.s $f4, 0.0
mov.s $f20, $f4
li.s $f5, 1.0
mov.s $f21, $f5
add.s $f22, $f20, $f21
s.s $f22, 124($sp)
mov.s $f20, $f22
add.s $f24, $f20, $f21
s.s $f24, 128($sp)
mov.s $f20, $f24
add.s $f23, $f20, $f21
s.s $f23, 132($sp)
mov.s $f20, $f23
add.s $f25, $f20, $f21
s.s $f25, 136($sp)
mov.s $f20, $f25
sw $s0, 100($sp)
s.s $f22, 124($sp)
s.s $f23, 132($sp)
s.s $f21, 120($sp)
s.s $f24, 128($sp)
s.s $f20, 116($sp)
s.s $f25, 136($sp)
_L0:
lw $s0, 100($sp)
lw $s1, 104($sp)
li $s2, 0
move $s1, $s2
sw $s0, 100($sp)
sw $s1, 104($sp)
li $t0, 10
bge $s0, $t0, _L1
l.s $f24, 144($sp)
l.s $f21, 140($sp)
l.s $f23, 152($sp)
l.s $f22, 148($sp)
lw $s1, 108($sp)
lw $s0, 100($sp)
l.s $f20, 120($sp)
l.s $f25, 116($sp)
lw $s2, 104($sp)
li $s3, 1
move $s2, $s3
add.s $f21, $f25, $f20
s.s $f21, 140($sp)
mov.s $f25, $f21
add.s $f24, $f25, $f20
s.s $f24, 144($sp)
mov.s $f25, $f24
add.s $f22, $f25, $f20
s.s $f22, 148($sp)
mov.s $f25, $f22
add.s $f23, $f25, $f20
s.s $f23, 152($sp)
mov.s $f25, $f23
li $s3, 0
move $s1, $s3
s.s $f24, 144($sp)
s.s $f21, 140($sp)
s.s $f23, 152($sp)
s.s $f22, 148($sp)
sw $s1, 108($sp)
sw $s0, 100($sp)
s.s $f20, 120($sp)
s.s $f25, 116($sp)
sw $s2, 104($sp)
li $t0, 5
bge $s0, $t0, _L2
lw $s2, 108($sp)
l.s $f22, 156($sp)
l.s $f23, 160($sp)
l.s $f21, 164($sp)
l.s $f24, 168($sp)
l.s $f20, 120($sp)
l.s $f25, 116($sp)
li $s0, 1
move $s2, $s0
add.s $f22, $f25, $f20
s.s $f22, 156($sp)
mov.s $f25, $f22
add.s $f23, $f25, $f20
s.s $f23, 160($sp)
mov.s $f25, $f23
add.s $f21, $f25, $f20
s.s $f21, 164($sp)
mov.s $f25, $f21
add.s $f24, $f25, $f20
s.s $f24, 168($sp)
mov.s $f25, $f24
sw $s2, 108($sp)
s.s $f22, 156($sp)
s.s $f23, 160($sp)
s.s $f21, 164($sp)
s.s $f24, 168($sp)
s.s $f20, 120($sp)
s.s $f25, 116($sp)
j _L3
_L2:
l.s $f24, 172($sp)
l.s $f21, 176($sp)
l.s $f23, 180($sp)
l.s $f22, 184($sp)
l.s $f20, 120($sp)
l.s $f25, 116($sp)
sub.s $f24, $f25, $f20
s.s $f24, 172($sp)
mov.s $f25, $f24
sub.s $f21, $f25, $f20
s.s $f21, 176($sp)
mov.s $f25, $f21
sub.s $f23, $f25, $f20
s.s $f23, 180($sp)
mov.s $f25, $f23
sub.s $f22, $f25, $f20
s.s $f22, 184($sp)
mov.s $f25, $f22
s.s $f24, 172($sp)
s.s $f21, 176($sp)
s.s $f23, 180($sp)
s.s $f22, 184($sp)
s.s $f20, 120($sp)
s.s $f25, 116($sp)
_L3:
l.s $f22, 188($sp)
l.s $f23, 192($sp)
lw $s2, 100($sp)
l.s $f21, 200($sp)
lw $s0, 112($sp)
l.s $f20, 120($sp)
l.s $f25, 116($sp)
l.s $f24, 196($sp)
add.s $f22, $f25, $f20
s.s $f22, 188($sp)
mov.s $f25, $f22
add.s $f23, $f25, $f20
s.s $f23, 192($sp)
mov.s $f25, $f23
add.s $f24, $f25, $f20
s.s $f24, 196($sp)
mov.s $f25, $f24
add.s $f21, $f25, $f20
s.s $f21, 200($sp)
mov.s $f25, $f21
li $s1, 1
add $s0, $s2, $s1
sw $s0, 112($sp)
move $s2, $s0
s.s $f22, 188($sp)
s.s $f23, 192($sp)
sw $s2, 100($sp)
s.s $f21, 200($sp)
sw $s0, 112($sp)
s.s $f20, 120($sp)
s.s $f25, 116($sp)
s.s $f24, 196($sp)
j _L0
_L1:
l.s $f24, 116($sp)
li $v0, 2
l.s $f6, 116($sp)
mov.s $f12, $f6
syscall
li $v0, 4
la $a0, newline
syscall
s.s $f24, 116($sp)
li $v0, 0
# start of epilogue
lw $s0, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
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
l.s $f22, 72($sp)
l.s $f23, 76($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 204
# end of epilogue
jr $ra
