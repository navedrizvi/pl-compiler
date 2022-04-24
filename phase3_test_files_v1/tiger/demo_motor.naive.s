.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -420
sw $s3, 16($sp)
sw $s2, 20($sp)
sw $s1, 24($sp)
sw $s0, 28($sp)
s.s $f23, 32($sp)
s.s $f22, 36($sp)
s.s $f21, 40($sp)
s.s $f20, 44($sp)
sw $ra, 48($sp)
# end of prologue
li $s3, 1
sw $s3, 52($sp)
li $s3, 1
sw $s3, 56($sp)
li $s3, 5
sw $s3, 60($sp)
li.s $f7, 320.0
s.s $f7, 120($sp)
li.s $f6, 9.81
s.s $f6, 140($sp)
li.s $f5, 0.009
s.s $f5, 144($sp)
li.s $f4, 0.001
s.s $f4, 148($sp)
li.s $f23, 1.225
s.s $f23, 128($sp)
li.s $f23, 0.2
s.s $f23, 132($sp)
li.s $f23, 0.28
s.s $f23, 172($sp)
li.s $f23, 0.05
s.s $f23, 184($sp)
li.s $f23, 0.16
s.s $f23, 188($sp)
li.s $f23, 1000.0
s.s $f23, 156($sp)
li.s $f23, 10.0
s.s $f23, 164($sp)
li.s $f23, 1025.0
s.s $f23, 160($sp)
li.s $f23, 2.1
s.s $f23, 152($sp)
li.s $f23, 11.6
s.s $f23, 192($sp)
li.s $f23, 900.0
s.s $f23, 216($sp)
li.s $f23, 140.25
s.s $f23, 224($sp)
li.s $f23, 1.0
s.s $f23, 196($sp)
li.s $f23, 0.0
s.s $f23, 180($sp)
li $s3, 0
sw $s3, 64($sp)
_L0:
lw $t3, 64($sp)
lw $t2, 60($sp)
bgt $t3, $t2, _L1
l.s $f23, 160($sp)
l.s $f22, 156($sp)
l.s $f21, 240($sp)
sub.s $f21, $f23, $f22
s.s $f21, 240($sp)
l.s $f23, 240($sp)
l.s $f22, 152($sp)
l.s $f21, 244($sp)
div.s $f21, $f23, $f22
s.s $f21, 244($sp)
l.s $f23, 244($sp)
s.s $f23, 136($sp)
l.s $f23, 136($sp)
l.s $f22, 164($sp)
l.s $f21, 248($sp)
sub.s $f21, $f23, $f22
s.s $f21, 248($sp)
l.s $f23, 248($sp)
l.s $f22, 152($sp)
l.s $f21, 252($sp)
div.s $f21, $f23, $f22
s.s $f21, 252($sp)
l.s $f23, 252($sp)
s.s $f23, 124($sp)
l.s $f23, 120($sp)
l.s $f22, 140($sp)
l.s $f21, 256($sp)
mul.s $f21, $f23, $f22
s.s $f21, 256($sp)
l.s $f23, 148($sp)
l.s $f22, 136($sp)
l.s $f21, 260($sp)
mul.s $f21, $f23, $f22
s.s $f21, 260($sp)
l.s $f23, 144($sp)
l.s $f22, 260($sp)
l.s $f21, 264($sp)
add.s $f21, $f23, $f22
s.s $f21, 264($sp)
l.s $f23, 256($sp)
l.s $f22, 264($sp)
l.s $f21, 268($sp)
mul.s $f21, $f23, $f22
s.s $f21, 268($sp)
l.s $f23, 268($sp)
s.s $f23, 116($sp)
li.s $f21, 0.5
l.s $f23, 128($sp)
l.s $f22, 272($sp)
mul.s $f22, $f21, $f23
s.s $f22, 272($sp)
l.s $f21, 272($sp)
l.s $f23, 132($sp)
l.s $f22, 276($sp)
mul.s $f22, $f21, $f23
s.s $f22, 276($sp)
li $s3, 1
sw $s3, 68($sp)
l.s $f21, 136($sp)
s.s $f21, 280($sp)
_L2:
lw $t3, 68($sp)
li $t2, 2
bge $t3, $t2, _L3
l.s $f21, 280($sp)
l.s $f23, 136($sp)
l.s $f22, 280($sp)
mul.s $f22, $f21, $f23
s.s $f22, 280($sp)
lw $s3, 68($sp)
li $s2, 1
lw $s1, 68($sp)
add $s1, $s3, $s2
sw $s1, 68($sp)
j _L2
_L3:
l.s $f21, 276($sp)
l.s $f23, 280($sp)
l.s $f22, 284($sp)
mul.s $f22, $f21, $f23
s.s $f22, 284($sp)
l.s $f21, 284($sp)
s.s $f21, 112($sp)
l.s $f21, 112($sp)
l.s $f23, 116($sp)
l.s $f22, 288($sp)
add.s $f22, $f21, $f23
s.s $f22, 288($sp)
l.s $f21, 120($sp)
l.s $f23, 124($sp)
l.s $f22, 292($sp)
mul.s $f22, $f21, $f23
s.s $f22, 292($sp)
l.s $f21, 288($sp)
l.s $f23, 292($sp)
l.s $f22, 296($sp)
add.s $f22, $f21, $f23
s.s $f22, 296($sp)
l.s $f21, 296($sp)
s.s $f21, 108($sp)
l.s $f21, 108($sp)
l.s $f23, 172($sp)
l.s $f22, 300($sp)
mul.s $f22, $f21, $f23
s.s $f22, 300($sp)
l.s $f21, 300($sp)
s.s $f21, 168($sp)
li $s3, 0
sw $s3, 72($sp)
lw $t3, 56($sp)
li $t2, 0
ble $t3, $t2, _L4
li $s3, 1
sw $s3, 72($sp)
li $s3, 1
sw $s3, 76($sp)
l.s $f21, 192($sp)
s.s $f21, 304($sp)
_L5:
lw $t3, 76($sp)
li $t2, 2
bge $t3, $t2, _L6
l.s $f21, 304($sp)
l.s $f23, 192($sp)
l.s $f22, 304($sp)
mul.s $f22, $f21, $f23
s.s $f22, 304($sp)
lw $s3, 76($sp)
li $s2, 1
lw $s1, 76($sp)
add $s1, $s3, $s2
sw $s1, 76($sp)
j _L5
_L6:
li.s $f22, 0.011
l.s $f21, 304($sp)
l.s $f23, 308($sp)
mul.s $f23, $f22, $f21
s.s $f23, 308($sp)
li.s $f23, 0.0033
l.s $f22, 192($sp)
l.s $f21, 312($sp)
mul.s $f21, $f23, $f22
s.s $f21, 312($sp)
l.s $f23, 308($sp)
l.s $f22, 312($sp)
l.s $f21, 316($sp)
add.s $f21, $f23, $f22
s.s $f21, 316($sp)
l.s $f23, 316($sp)
li.s $f21, 0.02
l.s $f22, 320($sp)
add.s $f22, $f23, $f21
s.s $f22, 320($sp)
l.s $f23, 320($sp)
s.s $f23, 212($sp)
l.s $f23, 212($sp)
l.s $f21, 216($sp)
l.s $f22, 324($sp)
div.s $f22, $f23, $f21
s.s $f22, 324($sp)
li.s $f22, 1.0
l.s $f23, 324($sp)
l.s $f21, 328($sp)
sub.s $f21, $f22, $f23
s.s $f21, 328($sp)
l.s $f22, 328($sp)
s.s $f22, 200($sp)
l.s $f22, 224($sp)
li.s $f21, 79.0
l.s $f23, 332($sp)
sub.s $f23, $f22, $f21
s.s $f23, 332($sp)
li $s3, 0
sw $s3, 80($sp)
l.s $f22, 332($sp)
li $t3, 0
c.le.s $f22, $t3
bc1t _L4
li $s3, 1
sw $s3, 80($sp)
li.s $f23, 7.6
l.s $f22, 332($sp)
l.s $f21, 336($sp)
mul.s $f21, $f23, $f22
s.s $f21, 336($sp)
l.s $f23, 336($sp)
li.s $f21, 600.0
l.s $f22, 340($sp)
add.s $f22, $f23, $f21
s.s $f22, 340($sp)
l.s $f23, 340($sp)
s.s $f23, 220($sp)
li.s $f22, 0.18
l.s $f23, 168($sp)
l.s $f21, 344($sp)
mul.s $f21, $f22, $f23
s.s $f21, 344($sp)
l.s $f22, 220($sp)
l.s $f23, 344($sp)
l.s $f21, 348($sp)
add.s $f21, $f22, $f23
s.s $f21, 348($sp)
li $s3, 0
sw $s3, 84($sp)
l.s $f22, 348($sp)
li $t3, 0
c.le.s $f22, $t3
bc1t _L4
li $s3, 1
sw $s3, 84($sp)
l.s $f22, 220($sp)
l.s $f23, 348($sp)
l.s $f21, 352($sp)
div.s $f21, $f22, $f23
s.s $f21, 352($sp)
l.s $f22, 352($sp)
s.s $f22, 204($sp)
l.s $f22, 216($sp)
l.s $f23, 224($sp)
l.s $f21, 356($sp)
div.s $f21, $f22, $f23
s.s $f21, 356($sp)
l.s $f22, 356($sp)
s.s $f22, 232($sp)
li $s3, 1
sw $s3, 88($sp)
l.s $f22, 232($sp)
s.s $f22, 360($sp)
_L7:
lw $t3, 88($sp)
li $t2, 2
bge $t3, $t2, _L8
l.s $f22, 360($sp)
l.s $f23, 232($sp)
l.s $f21, 360($sp)
mul.s $f21, $f22, $f23
s.s $f21, 360($sp)
lw $s3, 88($sp)
li $s2, 1
lw $s1, 88($sp)
add $s1, $s3, $s2
sw $s1, 88($sp)
j _L7
_L8:
l.s $f22, 188($sp)
l.s $f23, 360($sp)
l.s $f21, 364($sp)
mul.s $f21, $f22, $f23
s.s $f21, 364($sp)
l.s $f22, 364($sp)
s.s $f22, 228($sp)
l.s $f22, 228($sp)
l.s $f23, 216($sp)
l.s $f21, 368($sp)
div.s $f21, $f22, $f23
s.s $f21, 368($sp)
li.s $f21, 1.0
l.s $f22, 368($sp)
l.s $f23, 372($sp)
add.s $f23, $f21, $f22
s.s $f23, 372($sp)
li $s3, 0
sw $s3, 92($sp)
l.s $f21, 372($sp)
li $t3, 0
c.le.s $f21, $t3
bc1t _L4
li $s3, 1
sw $s3, 92($sp)
li.s $f23, 1.0
l.s $f21, 372($sp)
l.s $f22, 376($sp)
div.s $f22, $f23, $f21
s.s $f22, 376($sp)
l.s $f23, 376($sp)
s.s $f23, 208($sp)
l.s $f23, 200($sp)
l.s $f21, 204($sp)
l.s $f22, 380($sp)
mul.s $f22, $f23, $f21
s.s $f22, 380($sp)
l.s $f23, 380($sp)
l.s $f21, 208($sp)
l.s $f22, 384($sp)
mul.s $f22, $f23, $f21
s.s $f22, 384($sp)
l.s $f23, 384($sp)
s.s $f23, 196($sp)
li.s $f22, 3.0
l.s $f23, 184($sp)
l.s $f21, 388($sp)
mul.s $f21, $f22, $f23
s.s $f21, 388($sp)
li $s3, 1
sw $s3, 96($sp)
l.s $f22, 192($sp)
s.s $f22, 392($sp)
_L9:
lw $t3, 96($sp)
li $t2, 2
bge $t3, $t2, _L10
l.s $f22, 392($sp)
l.s $f23, 192($sp)
l.s $f21, 392($sp)
mul.s $f21, $f22, $f23
s.s $f21, 392($sp)
lw $s3, 96($sp)
li $s2, 1
lw $s1, 96($sp)
add $s1, $s3, $s2
sw $s1, 96($sp)
j _L9
_L10:
l.s $f22, 388($sp)
l.s $f23, 392($sp)
l.s $f21, 396($sp)
mul.s $f21, $f22, $f23
s.s $f21, 396($sp)
l.s $f22, 396($sp)
s.s $f22, 180($sp)
_L4:
li $s3, 0
sw $s3, 100($sp)
lw $t3, 52($sp)
li $t2, 0
ble $t3, $t2, _L11
li $s3, 1
sw $s3, 100($sp)
l.s $f22, 168($sp)
l.s $f23, 136($sp)
l.s $f21, 400($sp)
mul.s $f21, $f22, $f23
s.s $f21, 400($sp)
l.s $f22, 400($sp)
l.s $f23, 172($sp)
l.s $f21, 404($sp)
div.s $f21, $f22, $f23
s.s $f21, 404($sp)
l.s $f22, 404($sp)
s.s $f22, 236($sp)
l.s $f22, 236($sp)
l.s $f23, 196($sp)
l.s $f21, 408($sp)
mul.s $f21, $f22, $f23
s.s $f21, 408($sp)
l.s $f22, 408($sp)
l.s $f23, 180($sp)
l.s $f21, 412($sp)
add.s $f21, $f22, $f23
s.s $f21, 412($sp)
l.s $f22, 412($sp)
s.s $f22, 176($sp)
li $v0, 2
l.s $f22, 176($sp)
mov.s $f12, $f22
syscall
li $v0, 4
la $a0, newline
syscall
j _L12
_L11:
li $v0, 2
l.s $f22, 168($sp)
mov.s $f12, $f22
syscall
li $v0, 4
la $a0, newline
syscall
_L12:
l.s $f22, 224($sp)
li.s $f21, 1.0
l.s $f23, 416($sp)
sub.s $f23, $f22, $f21
s.s $f23, 416($sp)
l.s $f22, 416($sp)
s.s $f22, 224($sp)
lw $s3, 64($sp)
li $s2, 1
lw $s1, 64($sp)
add $s1, $s3, $s2
sw $s1, 64($sp)
j _L0
_L1:
li $v0, 0
# start of epilogue
lw $s3, 16($sp)
lw $s2, 20($sp)
lw $s1, 24($sp)
lw $s0, 28($sp)
l.s $f20, 32($sp)
l.s $f23, 36($sp)
l.s $f21, 40($sp)
l.s $f22, 44($sp)
lw $ra, 48($sp)
addiu $sp, $sp, 420
# end of epilogue
jr $ra
