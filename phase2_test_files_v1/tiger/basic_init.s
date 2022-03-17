.data
_a: .word 4
_b: .word 6
_c: .word 6

.text
.globl main

main:
    addiu $sp, $sp, -24                             # reserve room on the stack
    sw $ra, 20($sp)                                 # save return address

    lw $t0 , _n                                     # t0=5

    move $a0 , $t0                                  # t0=hanoi(5)
    jal hanoi
    move $t0 , $v0

    move $a0 , $t0                                  # printi(t0)
    li $v0, 1
    syscall

    lw $ra, 20($sp)                                 # restore return address
    addiu $sp , $sp , 24                            # restore stack
    li $v0, 0                                       # return 0
    jr $ra





.data
msg: .asciiz “\nHello, World!\n”

.text
main:
    addiu $sp, $sp, -24
    sw $ra, 20($sp)

    addiu   $sp, $sp, 4   # restore the stack


li $v0, 4
la $a0, msg
syscall

li $v0, 10
syscall