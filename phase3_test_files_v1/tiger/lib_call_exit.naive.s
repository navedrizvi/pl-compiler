.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, 0
# end of prologue
li $v0, 1
li $a0, 5
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 17
li $a0, 1
syscall
li $v0, 4
la $a0, newline
syscall
li $v0, 1
li $a0, 6
syscall
li $v0, 4
la $a0, newline
syscall
# start of epilogue
addiu $sp, $sp, 0
# end of epilogue
li $v0, 0
jr $ra
