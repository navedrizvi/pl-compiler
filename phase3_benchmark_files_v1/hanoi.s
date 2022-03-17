.data                                               # static data section
_n: .word 5                                         # global _n = 5

.text                                               # code section
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

hanoi:                                              # hanoi(n): (n==0) ? return 0 : return 2 * hanoi(n-1) + 1
    addiu $sp , $sp , -24                           # reserve room on the stack
    sw $ra, 20($sp)                                 # save return address

    move $t0, $a0 # t0=n
    beqz $t0 , base_case                            # if(n==0) base_case else recursive_case

recursive_case:
    addi $t0 , $t0, -1                              # t0=n-1
    move $a0 , $t0                                  # t0=hanoi(n-1)
    jal hanoi
    move $t0, $v0

    add $t0, $t0, $t0                              # t0=2*hanoi(n-1)
    addi $t0, $t0, 1                               # t0=2*hanoi(n-1) + 1
    move $v0, $t0                                  # return t0
    j hanoi_exit

base_case: #return 0
    move $v0 , $zero

hanoi_exit:
    lw $ra, 20($sp)                               # restore return address
    addiu $sp, $sp, 24                            # restore stack
    jr $ra