.data
newline: .asciiz "\n"
_0_a: .word 0, 0, 0, 0, 0
_0_i: .word 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -16
# end of prologue
li $t0, 0
sw $t0, _0_i
_L0:
lw $t0, _0_i
li $t1, 4
bgt $t0, $t1, _L1
lw $t0, _0_i
lw $t1, _0_i
lw $t2, 0($sp)
add $t2, $t0, $t1
sw $t2, 0($sp)
la $t0, _0_a
lw $t1, 0($sp)
la $t2, _0_a
lw $t3, 0($sp)
lw $t4, _0_i
li $t5, 4
mul $t5, $t4, $t5
addu $t2, $t2, $t5
sw $t3, ($t2)
lw $t2, _0_i
li $t3, 1
lw $t4, _0_i
add $t4, $t2, $t3
sw $t4, _0_i
j _L0
_L1:
li $t2, 0
sw $t2, _0_i
_L2:
lw $t2, _0_i
li $t3, 4
bgt $t2, $t3, _L3
la $t2, _0_a
la $t3, _0_a
lw $t4, _0_i
li $t5, 4
mul $t5, $t4, $t5
addu $t3, $t3, $t5
lw $t6, ($t3)
sw $t6, 8($sp)
li $v0, 1
lw $t3, 8($sp)
move $a0, $t3
syscall
li $v0, 4
la $a0, newline
syscall
lw $t3, _0_i
li $t6, 1
lw $t4, _0_i
add $t4, $t3, $t6
sw $t4, _0_i
j _L2
_L3:
# start of epilogue
addiu $sp, $sp, 16
# end of epilogue
li $v0, 0
jr $ra
