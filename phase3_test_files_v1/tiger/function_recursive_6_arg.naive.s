.data
newline: .asciiz "\n"
.text
.globl main
compute:
# start of prologue
addiu $sp, $sp, -144
# end of prologue
sw $a0, 60($sp)
sw $a1, 64($sp)
sw $a2, 68($sp)
sw $a3, 72($sp)
lw $t0, 160($sp)
sw $t0, 76($sp)
lw $t0, 164($sp)
sw $t0, 80($sp)
sw $s0, 24($sp)
sw $s1, 28($sp)
sw $s2, 32($sp)
sw $s3, 36($sp)
sw $s4, 40($sp)
sw $s5, 44($sp)
sw $s6, 48($sp)
sw $s7, 52($sp)
sw $ra, 56($sp)
lw $t0, 60($sp)
lw $t1, 64($sp)
lw $t2, 92($sp)
add $t2, $t0, $t1
sw $t2, 92($sp)
lw $t0, 92($sp)
lw $t1, 68($sp)
lw $t2, 96($sp)
add $t2, $t0, $t1
sw $t2, 96($sp)
lw $t0, 96($sp)
lw $t1, 72($sp)
lw $t2, 100($sp)
add $t2, $t0, $t1
sw $t2, 100($sp)
lw $t0, 100($sp)
lw $t1, 76($sp)
lw $t2, 104($sp)
add $t2, $t0, $t1
sw $t2, 104($sp)
lw $t0, 104($sp)
lw $t1, 80($sp)
lw $t2, 108($sp)
add $t2, $t0, $t1
sw $t2, 108($sp)
lw $t0, 108($sp)
sw $t0, 84($sp)
li $t0, 0
sw $t0, 112($sp)
lw $t0, 84($sp)
li $t1, 0
bgt $t0, $t1, _L0
li $t0, 1
sw $t0, 112($sp)
li $v0, 1
# start of epilogue
lw $s0, 24($sp)
lw $s1, 28($sp)
lw $s2, 32($sp)
lw $s3, 36($sp)
lw $s4, 40($sp)
lw $s5, 44($sp)
lw $s6, 48($sp)
lw $s7, 52($sp)
lw $ra, 56($sp)
addiu $sp, $sp, 144
# end of epilogue
jr $ra
_L0:
lw $t0, 60($sp)
li $t1, 1
lw $t2, 116($sp)
sub $t2, $t0, $t1
sw $t2, 116($sp)
lw $t0, 64($sp)
li $t1, 2
lw $t2, 120($sp)
sub $t2, $t0, $t1
sw $t2, 120($sp)
lw $t0, 68($sp)
li $t1, 3
lw $t2, 124($sp)
sub $t2, $t0, $t1
sw $t2, 124($sp)
lw $t0, 72($sp)
li $t1, 4
lw $t2, 128($sp)
sub $t2, $t0, $t1
sw $t2, 128($sp)
lw $t0, 76($sp)
li $t1, 5
lw $t2, 132($sp)
sub $t2, $t0, $t1
sw $t2, 132($sp)
lw $t0, 80($sp)
li $t1, 6
lw $t2, 136($sp)
sub $t2, $t0, $t1
sw $t2, 136($sp)
lw $a0, 116($sp)
lw $a1, 120($sp)
lw $a2, 124($sp)
lw $a3, 128($sp)
lw $t0, 132($sp)
sw $t0, 16($sp)
lw $t0, 136($sp)
sw $t0, 20($sp)
jal compute
sw $v0, 88($sp)
li $t0, 1
lw $t1, 88($sp)
lw $t2, 140($sp)
add $t2, $t0, $t1
sw $t2, 140($sp)
lw $v0, 140($sp)
# start of epilogue
lw $s0, 24($sp)
lw $s1, 28($sp)
lw $s2, 32($sp)
lw $s3, 36($sp)
lw $s4, 40($sp)
lw $s5, 44($sp)
lw $s6, 48($sp)
lw $s7, 52($sp)
lw $ra, 56($sp)
addiu $sp, $sp, 144
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -64
# end of prologue
sw $s0, 24($sp)
sw $s1, 28($sp)
sw $s2, 32($sp)
sw $s3, 36($sp)
sw $s4, 40($sp)
sw $s5, 44($sp)
sw $s6, 48($sp)
sw $s7, 52($sp)
sw $ra, 56($sp)
li $a0, 11
li $a1, 12
li $a2, 13
li $a3, 14
li $t0, 15
sw $t0, 16($sp)
li $t0, 16
sw $t0, 20($sp)
jal compute
sw $v0, 60($sp)
li $v0, 1
lw $t0, 60($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
lw $s0, 24($sp)
lw $s1, 28($sp)
lw $s2, 32($sp)
lw $s3, 36($sp)
lw $s4, 40($sp)
lw $s5, 44($sp)
lw $s6, 48($sp)
lw $s7, 52($sp)
lw $ra, 56($sp)
addiu $sp, $sp, 64
# end of epilogue
jr $ra
