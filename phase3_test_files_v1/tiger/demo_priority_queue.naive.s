.data
newline: .asciiz "\n"
_0_MAX_SIZE: .word 0
_0_keys: .word 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
_0_values: .word 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
_0_size: .word 0
.text
.globl main
swap:
# start of prologue
addiu $sp, $sp, -88
sw $a0, 52($sp)
sw $a1, 56($sp)
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
la $s0, _0_keys
la $s1, _0_keys
lw $s2, 56($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s4, ($s1)
sw $s4, 68($sp)
lw $s1, 68($sp)
sw $s1, 64($sp)
la $s1, _0_values
la $s4, _0_values
lw $s2, 56($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s4, $s4, $s3
lw $s5, ($s4)
sw $s5, 72($sp)
lw $s4, 72($sp)
sw $s4, 60($sp)
la $s4, _0_keys
la $s5, _0_keys
lw $s2, 52($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s5, $s5, $s3
lw $s6, ($s5)
sw $s6, 76($sp)
la $s5, _0_keys
lw $s6, 76($sp)
la $s2, _0_keys
lw $s3, 76($sp)
lw $s7, 56($sp)
li $t0, 4
mul $t0, $s7, $t0
addu $s2, $s2, $t0
sw $s3, ($s2)
la $s2, _0_values
la $s3, _0_values
lw $s7, 52($sp)
li $t0, 4
mul $t0, $s7, $t0
addu $s3, $s3, $t0
lw $t1, ($s3)
sw $t1, 80($sp)
la $s3, _0_values
lw $s7, 80($sp)
la $t1, _0_values
lw $t0, 80($sp)
lw $t2, 56($sp)
li $t3, 4
mul $t3, $t2, $t3
addu $t1, $t1, $t3
sw $t0, ($t1)
la $t1, _0_keys
lw $t0, 64($sp)
la $t2, _0_keys
lw $t3, 64($sp)
lw $t4, 52($sp)
li $t5, 4
mul $t5, $t4, $t5
addu $t2, $t2, $t5
sw $t3, ($t2)
la $t2, _0_values
lw $t3, 60($sp)
la $t4, _0_values
lw $t5, 60($sp)
lw $t6, 52($sp)
li $t7, 4
mul $t7, $t6, $t7
addu $t4, $t4, $t7
sw $t5, ($t4)
# start of epilogue
lw $ra, 48($sp)
addiu $sp, $sp, 88
# end of epilogue
jr $ra
up_heap:
# start of prologue
addiu $sp, $sp, -100
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
# end of prologue
li $s0, 1
sw $s0, 56($sp)
lw $s0, 52($sp)
li $s1, 2
lw $s2, 64($sp)
div $s2, $s0, $s1
sw $s2, 64($sp)
lw $s0, 64($sp)
sw $s0, 60($sp)
_L0:
li $s0, 0
sw $s0, 68($sp)
lw $s0, 60($sp)
li $s1, 0
ble $s0, $s1, _L1
li $s0, 1
sw $s0, 68($sp)
li $s0, 0
sw $s0, 72($sp)
lw $s0, 56($sp)
li $s1, 0
beq $s0, $s1, _L1
li $s0, 1
sw $s0, 72($sp)
lw $s0, 68($sp)
lw $s1, 72($sp)
lw $s2, 76($sp)
and $s2, $s0, $s1
sw $s2, 76($sp)
la $s0, _0_keys
la $s1, _0_keys
lw $s2, 60($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s4, ($s1)
sw $s4, 80($sp)
la $s1, _0_keys
la $s4, _0_keys
lw $s2, 52($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s4, $s4, $s3
lw $s5, ($s4)
sw $s5, 84($sp)
li $s4, 0
sw $s4, 88($sp)
lw $s4, 80($sp)
lw $s5, 84($sp)
ble $s4, $s5, _L2
li $s4, 1
sw $s4, 88($sp)
lw $a0, 60($sp)
lw $a1, 52($sp)
jal swap
lw $s4, 60($sp)
sw $s4, 52($sp)
lw $s4, 52($sp)
li $s5, 2
lw $s2, 92($sp)
div $s2, $s4, $s5
sw $s2, 92($sp)
lw $s4, 92($sp)
sw $s4, 60($sp)
j _L3
_L2:
li $s4, 0
sw $s4, 56($sp)
_L3:
j _L0
_L1:
# start of epilogue
lw $s4, 16($sp)
lw $s5, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s6, 32($sp)
lw $s7, 36($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 100
# end of epilogue
jr $ra
down_heap:
# start of prologue
addiu $sp, $sp, -152
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
# end of prologue
lw $s0, 52($sp)
li $s1, 2
lw $s2, 72($sp)
mul $s2, $s0, $s1
sw $s2, 72($sp)
lw $s0, 72($sp)
sw $s0, 64($sp)
lw $s0, 64($sp)
li $s1, 1
lw $s2, 76($sp)
add $s2, $s0, $s1
sw $s2, 76($sp)
lw $s0, 76($sp)
sw $s0, 68($sp)
li $s0, 0
sw $s0, 60($sp)
li $s0, 0
sw $s0, 56($sp)
li $s0, 0
sw $s0, 80($sp)
lw $s0, 64($sp)
lw $s1, _0_size
bgt $s0, $s1, _L4
li $s0, 1
sw $s0, 80($sp)
la $s0, _0_keys
la $s1, _0_keys
lw $s2, 52($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s4, ($s1)
sw $s4, 84($sp)
la $s1, _0_keys
la $s4, _0_keys
lw $s2, 64($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s4, $s4, $s3
lw $s5, ($s4)
sw $s5, 88($sp)
li $s4, 0
sw $s4, 92($sp)
lw $s4, 84($sp)
lw $s5, 88($sp)
ble $s4, $s5, _L5
li $s4, 1
sw $s4, 92($sp)
li $s4, 1
sw $s4, 60($sp)
_L5:
_L4:
li $s4, 0
sw $s4, 96($sp)
lw $s4, 68($sp)
lw $s5, _0_size
bgt $s4, $s5, _L6
li $s4, 1
sw $s4, 96($sp)
la $s4, _0_keys
la $s5, _0_keys
lw $s2, 52($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s5, $s5, $s3
lw $s6, ($s5)
sw $s6, 100($sp)
la $s5, _0_keys
la $s6, _0_keys
lw $s2, 68($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s6, $s6, $s3
lw $s7, ($s6)
sw $s7, 104($sp)
li $s6, 0
sw $s6, 108($sp)
lw $s6, 100($sp)
lw $s7, 104($sp)
ble $s6, $s7, _L7
li $s6, 1
sw $s6, 108($sp)
li $s6, 1
sw $s6, 56($sp)
_L7:
_L6:
lw $s6, 56($sp)
lw $s7, 60($sp)
lw $s2, 112($sp)
or $s2, $s6, $s7
sw $s2, 112($sp)
li $s6, 0
sw $s6, 116($sp)
lw $s6, 112($sp)
li $s7, 0
ble $s6, $s7, _L8
li $s6, 1
sw $s6, 116($sp)
lw $s6, 56($sp)
lw $s7, 60($sp)
lw $s2, 124($sp)
and $s2, $s6, $s7
sw $s2, 124($sp)
li $s6, 0
sw $s6, 128($sp)
lw $s6, 124($sp)
li $s7, 0
ble $s6, $s7, _L9
li $s6, 1
sw $s6, 128($sp)
la $s6, _0_keys
la $s7, _0_keys
lw $s2, 64($sp)
li $s3, 4
mul $s3, $s2, $s3
addu $s7, $s7, $s3
lw $t0, ($s7)
sw $t0, 132($sp)
la $s7, _0_keys
la $s2, _0_keys
lw $s3, 68($sp)
li $t0, 4
mul $t0, $s3, $t0
addu $s2, $s2, $t0
lw $t1, ($s2)
sw $t1, 136($sp)
li $s2, 0
sw $s2, 140($sp)
lw $s2, 132($sp)
lw $s3, 136($sp)
bge $s2, $s3, _L11
li $s2, 1
sw $s2, 140($sp)
lw $s2, 64($sp)
sw $s2, 120($sp)
j _L12
_L11:
lw $s2, 68($sp)
sw $s2, 120($sp)
_L12:
j _L10
_L9:
li $s2, 0
sw $s2, 144($sp)
lw $s2, 60($sp)
li $s3, 0
ble $s2, $s3, _L13
li $s2, 1
sw $s2, 144($sp)
lw $s2, 64($sp)
sw $s2, 120($sp)
lw $s2, 68($sp)
sw $s2, 120($sp)
_L14:
j _L10
_L13:
_L10:
lw $a0, 52($sp)
lw $a1, 120($sp)
jal swap
lw $a0, 120($sp)
jal down_heap
_L8:
# start of epilogue
lw $s2, 16($sp)
lw $s3, 20($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 152
# end of epilogue
jr $ra
peek:
# start of prologue
addiu $sp, $sp, -64
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
la $s0, _0_values
addi $s0, $s0, 4
lw $s1, ($s0)
sw $s1, 56($sp)
lw $s0, 56($sp)
sw $s0, 52($sp)
lw $v0, 52($sp)
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
addiu $sp, $sp, 64
# end of epilogue
jr $ra
push:
# start of prologue
addiu $sp, $sp, -72
sw $a0, 52($sp)
sw $a1, 56($sp)
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
sw $s0, 60($sp)
lw $s0, _0_size
lw $s1, _0_MAX_SIZE
bne $s0, $s1, _L15
li $s0, 1
sw $s0, 60($sp)
li $v0, 17
li $a0, 1
syscall
li $v0, 4
la $a0, newline
syscall
_L15:
lw $s0, _0_size
li $s1, 1
lw $s2, 64($sp)
add $s2, $s0, $s1
sw $s2, 64($sp)
lw $s0, 64($sp)
sw $s0, _0_size
la $s0, _0_keys
lw $s1, 52($sp)
la $s2, _0_keys
lw $s3, 52($sp)
lw $s4, _0_size
li $s5, 4
mul $s5, $s4, $s5
addu $s2, $s2, $s5
sw $s3, ($s2)
la $s2, _0_values
lw $s3, 56($sp)
la $s4, _0_values
lw $s5, 56($sp)
lw $s6, _0_size
li $s7, 4
mul $s7, $s6, $s7
addu $s4, $s4, $s7
sw $s5, ($s4)
lw $a0, _0_size
jal up_heap
# start of epilogue
lw $s4, 16($sp)
lw $s5, 20($sp)
lw $s6, 24($sp)
lw $s7, 28($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 72
# end of epilogue
jr $ra
pop:
# start of prologue
addiu $sp, $sp, -72
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
sw $s0, 52($sp)
lw $s0, _0_size
li $s1, 0
bne $s0, $s1, _L16
li $s0, 1
sw $s0, 52($sp)
li $v0, 17
li $a0, 2
syscall
li $v0, 4
la $a0, newline
syscall
_L16:
la $s0, _0_keys
la $s1, _0_keys
lw $s2, _0_size
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s4, ($s1)
sw $s4, 56($sp)
la $s1, _0_keys
lw $s4, 56($sp)
addi $s1, $s1, 4
sw $s4, ($s1)
la $s4, _0_values
la $s1, _0_values
lw $s2, _0_size
li $s3, 4
mul $s3, $s2, $s3
addu $s1, $s1, $s3
lw $s5, ($s1)
sw $s5, 60($sp)
la $s1, _0_values
lw $s5, 60($sp)
addi $s1, $s1, 4
sw $s5, ($s1)
lw $s5, _0_size
li $s1, 1
lw $s2, 64($sp)
sub $s2, $s5, $s1
sw $s2, 64($sp)
lw $s5, 64($sp)
sw $s5, _0_size
li $a0, 1
jal down_heap
# start of epilogue
lw $s5, 16($sp)
lw $s1, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s6, 32($sp)
lw $s7, 36($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 72
# end of epilogue
jr $ra
init_data:
# start of prologue
addiu $sp, $sp, -60
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
li $a0, 5
li $a1, 108
jal push
li $a0, 8
li $a1, 87
jal push
li $a0, 18
li $a1, 100
jal push
li $a0, 22
li $a1, 33
jal push
li $a0, 6
li $a1, 111
jal push
li $a0, 7
li $a1, 32
jal push
li $a0, 11
li $a1, 111
jal push
li $a0, 13
li $a1, 114
jal push
li $a0, 15
li $a1, 108
jal push
li $a0, 0
li $a1, 72
jal push
li $a0, 1
li $a1, 101
jal push
li $a0, 2
li $a1, 108
jal push
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
addiu $sp, $sp, -72
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
la $s1, _0_keys
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
li $s0, 0
la $s1, _0_values
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
addi $s1, $s1, 4
sw $s0, ($s1)
li $s0, 0
sw $s0, _0_size
li $s0, 20
sw $s0, _0_MAX_SIZE
jal init_data
lw $s0, _0_size
sw $s0, 52($sp)
li $s0, 1
sw $s0, 56($sp)
_L17:
lw $s0, 56($sp)
lw $s1, 52($sp)
bgt $s0, $s1, _L18
jal peek
sw $v0, 60($sp)
li $v0, 1
lw $s0, 60($sp)
move $a0, $s0
syscall
li $v0, 4
la $a0, newline
syscall
jal pop
lw $s0, 56($sp)
li $s1, 1
lw $s2, 56($sp)
add $s2, $s0, $s1
sw $s2, 56($sp)
j _L17
_L18:
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
addiu $sp, $sp, 72
# end of epilogue
jr $ra
