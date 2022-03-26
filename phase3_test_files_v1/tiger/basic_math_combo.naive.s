.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -2812
# end of prologue
li $t0, 5
sw $t0, 0($sp)
li $t0, 50
sw $t0, 4($sp)
li $t0, 100
lw $t1, 0($sp)
lw $t2, 12($sp)
add $t2, $t0, $t1
sw $t2, 12($sp)
lw $t0, 12($sp)
lw $t1, 4($sp)
lw $t2, 16($sp)
add $t2, $t0, $t1
sw $t2, 16($sp)
lw $t0, 16($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 100
lw $t1, 0($sp)
lw $t2, 20($sp)
sub $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 20($sp)
lw $t1, 4($sp)
lw $t2, 24($sp)
sub $t2, $t0, $t1
sw $t2, 24($sp)
lw $t0, 24($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 100
lw $t1, 0($sp)
lw $t2, 28($sp)
mul $t2, $t0, $t1
sw $t2, 28($sp)
lw $t0, 28($sp)
lw $t1, 4($sp)
lw $t2, 32($sp)
mul $t2, $t0, $t1
sw $t2, 32($sp)
lw $t0, 32($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 500
lw $t1, 0($sp)
lw $t2, 36($sp)
div $t2, $t0, $t1
sw $t2, 36($sp)
lw $t0, 36($sp)
lw $t1, 4($sp)
lw $t2, 40($sp)
div $t2, $t0, $t1
sw $t2, 40($sp)
lw $t0, 40($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 100
li $t1, 50
lw $t2, 44($sp)
sub $t2, $t0, $t1
sw $t2, 44($sp)
lw $t0, 44($sp)
li $t1, 25
lw $t2, 48($sp)
add $t2, $t0, $t1
sw $t2, 48($sp)
lw $t0, 48($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 100
li $t1, 50
lw $t2, 52($sp)
div $t2, $t0, $t1
sw $t2, 52($sp)
lw $t0, 52($sp)
li $t1, 25
lw $t2, 56($sp)
mul $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 56($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 0($sp)
lw $t1, 4($sp)
lw $t2, 60($sp)
mul $t2, $t0, $t1
sw $t2, 60($sp)
lw $t0, 60($sp)
lw $t1, 0($sp)
lw $t2, 64($sp)
add $t2, $t0, $t1
sw $t2, 64($sp)
lw $t0, 64($sp)
lw $t1, 4($sp)
lw $t2, 68($sp)
add $t2, $t0, $t1
sw $t2, 68($sp)
lw $t0, 68($sp)
lw $t1, 0($sp)
lw $t2, 72($sp)
sub $t2, $t0, $t1
sw $t2, 72($sp)
lw $t0, 4($sp)
lw $t1, 0($sp)
lw $t2, 76($sp)
div $t2, $t0, $t1
sw $t2, 76($sp)
lw $t0, 72($sp)
lw $t1, 76($sp)
lw $t2, 80($sp)
sub $t2, $t0, $t1
sw $t2, 80($sp)
lw $t0, 80($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 200
li $t1, 4
lw $t2, 84($sp)
div $t2, $t0, $t1
sw $t2, 84($sp)
li $t0, 25
li $t1, 5
lw $t2, 88($sp)
div $t2, $t0, $t1
sw $t2, 88($sp)
lw $t0, 84($sp)
lw $t1, 88($sp)
lw $t2, 92($sp)
sub $t2, $t0, $t1
sw $t2, 92($sp)
lw $t0, 92($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 4($sp)
lw $t1, 0($sp)
lw $t2, 96($sp)
mul $t2, $t0, $t1
sw $t2, 96($sp)
li $t0, 100
lw $t1, 96($sp)
lw $t2, 100($sp)
sub $t2, $t0, $t1
sw $t2, 100($sp)
lw $t0, 100($sp)
li $t1, 7
lw $t2, 104($sp)
add $t2, $t0, $t1
sw $t2, 104($sp)
lw $t0, 104($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 100
lw $t1, 4($sp)
lw $t2, 108($sp)
sub $t2, $t0, $t1
sw $t2, 108($sp)
lw $t0, 0($sp)
li $t1, 7
lw $t2, 112($sp)
add $t2, $t0, $t1
sw $t2, 112($sp)
lw $t0, 108($sp)
lw $t1, 112($sp)
lw $t2, 116($sp)
mul $t2, $t0, $t1
sw $t2, 116($sp)
lw $t0, 116($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 10
lw $t1, 4($sp)
lw $t2, 120($sp)
sub $t2, $t0, $t1
sw $t2, 120($sp)
lw $t0, 0($sp)
li $t1, 3
lw $t2, 124($sp)
sub $t2, $t0, $t1
sw $t2, 124($sp)
lw $t0, 124($sp)
li $t1, 2
lw $t2, 128($sp)
div $t2, $t0, $t1
sw $t2, 128($sp)
lw $t0, 120($sp)
lw $t1, 128($sp)
lw $t2, 132($sp)
mul $t2, $t0, $t1
sw $t2, 132($sp)
lw $t0, 132($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 7
li $t1, 1
lw $t2, 136($sp)
sub $t2, $t0, $t1
sw $t2, 136($sp)
li $t0, 3
lw $t1, 136($sp)
lw $t2, 140($sp)
mul $t2, $t0, $t1
sw $t2, 140($sp)
li $t0, 60
lw $t1, 140($sp)
lw $t2, 144($sp)
div $t2, $t0, $t1
sw $t2, 144($sp)
li $t0, 20
lw $t1, 144($sp)
lw $t2, 148($sp)
add $t2, $t0, $t1
sw $t2, 148($sp)
lw $t0, 148($sp)
sw $t0, 8($sp)
li $v0, 1
lw $t0, 8($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 2812
# end of epilogue
li $v0, 0
jr $ra
