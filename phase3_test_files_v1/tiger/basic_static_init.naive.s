.data
newline: .asciiz "\n"
_0_a: .word 0
_0_c: .word 0
_0_b: .word 0
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, 0
# end of prologue
li $t0, 40
sw $t0, _0_a
li $t0, 60
sw $t0, _0_c
li $t0, 60
sw $t0, _0_b
li $t0, 50
sw $t0, _0_b
li $v0, 1
lw $a0, _0_a
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $a0, _0_b
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
lw $a0, _0_c
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 0
# end of epilogue
li $v0, 0
jr $ra
