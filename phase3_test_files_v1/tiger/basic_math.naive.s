.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -60
# end of prologue
li $t0, 5
sw $t0, 4($sp)
li $t0, 5
sw $t0, 8($sp)
li $t0, 200
li $t1, 100
lw $t2, 16($sp)
add $t2, $t0, $t1
sw $t2, 16($sp)
lw $t0, 16($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
li $t1, 50
lw $t2, 20($sp)
add $t2, $t0, $t1
sw $t2, 20($sp)
lw $t0, 20($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
lw $t1, 4($sp)
lw $t2, 24($sp)
add $t2, $t0, $t1
sw $t2, 24($sp)
lw $t0, 24($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 200
li $t1, 100
lw $t2, 28($sp)
sub $t2, $t0, $t1
sw $t2, 28($sp)
lw $t0, 28($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
li $t1, 50
lw $t2, 32($sp)
sub $t2, $t0, $t1
sw $t2, 32($sp)
lw $t0, 32($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
lw $t1, 4($sp)
lw $t2, 36($sp)
sub $t2, $t0, $t1
sw $t2, 36($sp)
lw $t0, 36($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 200
li $t1, 100
lw $t2, 40($sp)
mul $t2, $t0, $t1
sw $t2, 40($sp)
lw $t0, 40($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
li $t1, 50
lw $t2, 44($sp)
mul $t2, $t0, $t1
sw $t2, 44($sp)
lw $t0, 44($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
lw $t1, 4($sp)
lw $t2, 48($sp)
mul $t2, $t0, $t1
sw $t2, 48($sp)
lw $t0, 48($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
li $t0, 200
li $t1, 100
lw $t2, 52($sp)
div $t2, $t0, $t1
sw $t2, 52($sp)
lw $t0, 52($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
li $t1, 2
lw $t2, 56($sp)
div $t2, $t0, $t1
sw $t2, 56($sp)
lw $t0, 56($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
lw $t0, 8($sp)
lw $t1, 4($sp)
lw $t2, 60($sp)
div $t2, $t0, $t1
sw $t2, 60($sp)
lw $t0, 60($sp)
sw $t0, 12($sp)
li $v0, 1
lw $t0, 12($sp)
move $a0, $t0
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 60
# end of epilogue
li $v0, 0
jr $ra
