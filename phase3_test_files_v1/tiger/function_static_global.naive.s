.data
newline: .asciiz "\n"
_0_sum: .word 0
.text
.globl main
subFromSum:
# start of prologue
addiu $sp, $sp, -60
# end of prologue
sw $a0, 52($sp)
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
lw $t0, _0_sum
lw $t1, 52($sp)
lw $t2, 56($sp)
sub $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 56($sp)
sw $t0, _0_sum
li $v0, 1
lw $a0, _0_sum
syscall
li $v0, 4
la $a0, newline
syscall
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
addiu $sp, $sp, 60
# end of epilogue
jr $ra
addToSum:
# start of prologue
addiu $sp, $sp, -60
# end of prologue
sw $a0, 52($sp)
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
lw $t0, _0_sum
lw $t1, 52($sp)
lw $t2, 56($sp)
add $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 56($sp)
sw $t0, _0_sum
li $v0, 1
lw $a0, _0_sum
syscall
li $v0, 4
la $a0, newline
syscall
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
addiu $sp, $sp, 60
# end of epilogue
jr $ra
main:
# start of prologue
addiu $sp, $sp, -56
# end of prologue
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
sw $ra, 48($sp)
li $t0, 5
sw $t0, _0_sum
li $v0, 1
lw $a0, _0_sum
syscall
li $v0, 4
la $a0, newline
syscall
li $a0, 10
jal addToSum
lw $t0, _0_sum
li $t1, 5
lw $t2, 52($sp)
add $t2, $t0, $t1
sw $t2, 52($sp)
lw $t0, 52($sp)
sw $t0, _0_sum
li $v0, 1
lw $a0, _0_sum
syscall
li $v0, 4
la $a0, newline
syscall
li $a0, 7
jal subFromSum
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
lw $ra, 48($sp)
addiu $sp, $sp, 56
# end of epilogue
jr $ra
