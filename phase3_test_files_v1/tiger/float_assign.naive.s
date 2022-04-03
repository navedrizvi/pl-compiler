.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -12
# end of prologue

li.s $f4, 1.0
s.s $f4, 0($sp)
li.s $f5, 2.0
s.s $f5, 8($sp)
li.s $f6, 3.0
s.s $f6, 4($sp)


li $v0, 1

l.s $f7, 0($sp)
mov.s $f12, $f7

syscall
li $v0, 4
la $a0, newline

syscall
li $v0, 1

l.s $f7, 8($sp)
mov.s $f12, $f7

syscall
li $v0, 4
la $a0, newline
syscall

li $v0, 1

l.s $f8, 4($sp)
mov.s $f12, $f8
syscall

li $v0, 4
la $a0, newline
syscall

# start of epilogue
addiu $sp, $sp, 12
# end of epilogue
li $v0, 0
jr $ra