.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -156
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
lw $s6, 52($sp)
lw $s2, 64($sp)
lw $s3, 72($sp)
lw $s1, 60($sp)
lw $s4, 68($sp)
lw $s0, 56($sp)
lw $s5, 76($sp)
li $s7, 0
move $s6, $s7
li $s7, 0
move $s0, $s7
li $s7, 1
move $s1, $s7
add $s2, $s0, $s1
sw $s2, 64($sp)
move $s0, $s2
add $s4, $s0, $s1
sw $s4, 68($sp)
move $s0, $s4
add $s3, $s0, $s1
sw $s3, 72($sp)
move $s0, $s3
add $s5, $s0, $s1
sw $s5, 76($sp)
move $s0, $s5
sw $s6, 52($sp)
sw $s2, 64($sp)
sw $s3, 72($sp)
sw $s1, 60($sp)
sw $s4, 68($sp)
sw $s0, 56($sp)
sw $s5, 76($sp)
_L0:
lw $s5, 52($sp)
lw $s0, 80($sp)
li $s4, 0
move $s0, $s4
sw $s5, 52($sp)
sw $s0, 80($sp)
li $s4, 10
bge $s5, $s4, _L1
lw $s4, 88($sp)
lw $s1, 84($sp)
lw $s3, 96($sp)
lw $s2, 92($sp)
lw $s6, 100($sp)
lw $s7, 52($sp)
lw $s5, 60($sp)
lw $s0, 56($sp)
lw $t0, 80($sp)
li $t1, 1
move $t0, $t1
add $s1, $s0, $s5
sw $s1, 84($sp)
move $s0, $s1
add $s4, $s0, $s5
sw $s4, 88($sp)
move $s0, $s4
add $s2, $s0, $s5
sw $s2, 92($sp)
move $s0, $s2
add $s3, $s0, $s5
sw $s3, 96($sp)
move $s0, $s3
li $t1, 0
move $s6, $t1
sw $s4, 88($sp)
sw $s1, 84($sp)
sw $s3, 96($sp)
sw $s2, 92($sp)
sw $s6, 100($sp)
sw $s7, 52($sp)
sw $s5, 60($sp)
sw $s0, 56($sp)
sw $t0, 80($sp)
li $t1, 5
bge $s7, $t1, _L2
lw $s1, 100($sp)
lw $s7, 104($sp)
lw $s6, 108($sp)
lw $s2, 112($sp)
lw $s3, 116($sp)
lw $s5, 60($sp)
lw $s0, 56($sp)
li $s4, 1
move $s1, $s4
add $s7, $s0, $s5
sw $s7, 104($sp)
move $s0, $s7
add $s6, $s0, $s5
sw $s6, 108($sp)
move $s0, $s6
add $s2, $s0, $s5
sw $s2, 112($sp)
move $s0, $s2
add $s3, $s0, $s5
sw $s3, 116($sp)
move $s0, $s3
sw $s1, 100($sp)
sw $s7, 104($sp)
sw $s6, 108($sp)
sw $s2, 112($sp)
sw $s3, 116($sp)
sw $s5, 60($sp)
sw $s0, 56($sp)
j _L3
_L2:
lw $s3, 120($sp)
lw $s2, 124($sp)
lw $s6, 128($sp)
lw $s7, 132($sp)
lw $s5, 60($sp)
lw $s0, 56($sp)
sub $s3, $s0, $s5
sw $s3, 120($sp)
move $s0, $s3
sub $s2, $s0, $s5
sw $s2, 124($sp)
move $s0, $s2
sub $s6, $s0, $s5
sw $s6, 128($sp)
move $s0, $s6
sub $s7, $s0, $s5
sw $s7, 132($sp)
move $s0, $s7
sw $s3, 120($sp)
sw $s2, 124($sp)
sw $s6, 128($sp)
sw $s7, 132($sp)
sw $s5, 60($sp)
sw $s0, 56($sp)
_L3:
lw $s7, 136($sp)
lw $s6, 140($sp)
lw $s2, 52($sp)
lw $s3, 148($sp)
lw $s1, 152($sp)
lw $s5, 60($sp)
lw $s0, 56($sp)
lw $s4, 144($sp)
add $s7, $s0, $s5
sw $s7, 136($sp)
move $s0, $s7
add $s6, $s0, $s5
sw $s6, 140($sp)
move $s0, $s6
add $s4, $s0, $s5
sw $s4, 144($sp)
move $s0, $s4
add $s3, $s0, $s5
sw $s3, 148($sp)
move $s0, $s3
li $t0, 1
add $s1, $s2, $t0
sw $s1, 152($sp)
move $s2, $s1
sw $s7, 136($sp)
sw $s6, 140($sp)
sw $s2, 52($sp)
sw $s3, 148($sp)
sw $s1, 152($sp)
sw $s5, 60($sp)
sw $s0, 56($sp)
sw $s4, 144($sp)
j _L0
_L1:
lw $s4, 56($sp)
li $v0, 1
move $a0, $s4
syscall
li $v0, 4
la $a0, newline
syscall
sw $s4, 56($sp)
li $v0, 0
# start of epilogue
lw $s0, 16($sp)
lw $s5, 20($sp)
lw $s1, 24($sp)
lw $s3, 28($sp)
lw $s2, 32($sp)
lw $s6, 36($sp)
lw $s7, 40($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 156
# end of epilogue
jr $ra
