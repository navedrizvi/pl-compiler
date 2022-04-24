.data
newline: .asciiz "\n"
_0_result: .word 0
.text
.globl main
fib:
# start of prologue
addiu $sp, $sp, -84
sw $a0, 52($sp)
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
li $s0, 0
sw $s0, 56($sp)
li $s0, 0
sw $s0, 60($sp)
li $s0, 0
sw $s0, 64($sp)
lw $t0, 52($sp)
li $t1, 1
bgt $t0, $t1, _L0
li $s0, 1
sw $s0, 64($sp)
lw $v0, 52($sp)
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
addiu $sp, $sp, 84
# end of epilogue
jr $ra
j _L1
_L0:
lw $s0, 52($sp)
li $s1, 1
lw $s2, 68($sp)
sub $s2, $s0, $s1
sw $s2, 68($sp)
lw $a0, 68($sp)
jal fib
sw $v0, 60($sp)
lw $s0, 52($sp)
li $s1, 2
lw $s2, 72($sp)
sub $s2, $s0, $s1
sw $s2, 72($sp)
lw $a0, 72($sp)
jal fib
sw $v0, 56($sp)
lw $s0, 60($sp)
lw $s1, 56($sp)
lw $s2, 76($sp)
add $s2, $s0, $s1
sw $s2, 76($sp)
lw $v0, 76($sp)
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
addiu $sp, $sp, 84
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
