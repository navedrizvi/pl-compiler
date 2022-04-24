.data
newline: .asciiz "\n"
_0_result: .word 0
.text
.globl main
fib:
# start of prologue
addiu $sp, $sp, -80
sw $a0, 48($sp)
s.s $f31, 16($sp)
s.s $f30, 20($sp)
s.s $f29, 24($sp)
s.s $f28, 28($sp)
s.s $f27, 32($sp)
s.s $f26, 36($sp)
s.s $f25, 40($sp)
s.s $f24, 44($sp)
sw $ra, 44($sp)
# end of prologue
li $s1, 0
move $t0, $s1
li $s1, 0
move $t1, $s1
li $s1, 0
sw $s1, 60($sp)
li $t2, 1
bgt $s0, $t2, _L0
li $s1, 1
sw $s1, 60($sp)
lw $v0, 48($sp)
# start of epilogue
l.s $f31, 16($sp)
l.s $f30, 20($sp)
l.s $f29, 24($sp)
l.s $f28, 28($sp)
l.s $f27, 32($sp)
l.s $f26, 36($sp)
l.s $f25, 40($sp)
l.s $f24, 44($sp)
lw $ra, 44($sp)
addiu $sp, $sp, 80
# end of epilogue
jr $ra
j _L1
_L0:
li $s1, 1
sub $t0, $s0, $s1
sw $t0, 64($sp)
move $a0, $t0
sw $t0, 52($sp)
sw $t1, 56($sp)
sw $s0, 48($sp)
sw $t0, 68($sp)
sw $t0, 64($sp)
sw $t0, 72($sp)
jal fib
lw $t0, 52($sp)
lw $t1, 56($sp)
lw $s0, 48($sp)
lw $t0, 68($sp)
lw $t0, 64($sp)
lw $t0, 72($sp)
move $t1, $v0
li $s1, 2
sub $t0, $s0, $s1
sw $t0, 68($sp)
move $a0, $t0
sw $t0, 52($sp)
sw $t1, 56($sp)
sw $s0, 48($sp)
sw $t0, 68($sp)
sw $t0, 64($sp)
sw $t0, 72($sp)
jal fib
lw $t0, 52($sp)
lw $t1, 56($sp)
lw $s0, 48($sp)
lw $t0, 68($sp)
lw $t0, 64($sp)
lw $t0, 72($sp)
move $t0, $v0
add $t0, $t1, $t0
sw $t0, 72($sp)
lw $v0, 72($sp)
# start of epilogue
l.s $f31, 16($sp)
l.s $f30, 20($sp)
l.s $f29, 24($sp)
l.s $f28, 28($sp)
l.s $f27, 32($sp)
l.s $f26, 36($sp)
l.s $f25, 40($sp)
l.s $f24, 44($sp)
lw $ra, 44($sp)
addiu $sp, $sp, 80
# end of epilogue
jr $ra
_L1:
main:
# start of prologue
addiu $sp, $sp, -60
s.s $f31, 16($sp)
s.s $f30, 20($sp)
s.s $f29, 24($sp)
s.s $f28, 28($sp)
s.s $f27, 32($sp)
s.s $f26, 36($sp)
s.s $f25, 40($sp)
s.s $f24, 44($sp)
sw $ra, 48($sp)
# end of prologue
li $a0, 12
jal fib
sw $v0, _0_result
li $v0, 1
lw $a0, _0_result
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 0
# start of epilogue
l.s $f31, 16($sp)
l.s $f30, 20($sp)
l.s $f29, 24($sp)
l.s $f28, 28($sp)
l.s $f27, 32($sp)
l.s $f26, 36($sp)
l.s $f25, 40($sp)
l.s $f24, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 60
# end of epilogue
jr $ra
