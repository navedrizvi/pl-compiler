.data
newline: .asciiz "\n"
.text
.globl main
main:
# start of prologue
addiu $sp, $sp, -468
sw $s0, 16($sp)
sw $s1, 20($sp)
sw $s2, 24($sp)
sw $s3, 28($sp)
sw $s4, 32($sp)
sw $s5, 36($sp)
sw $s6, 40($sp)
sw $s7, 44($sp)
s.s $f20, 48($sp)
s.s $f21, 52($sp)
s.s $f22, 56($sp)
s.s $f23, 60($sp)
s.s $f24, 64($sp)
s.s $f25, 68($sp)
s.s $f26, 72($sp)
s.s $f27, 76($sp)
sw $ra, 96($sp)
# end of prologue
li $s0, 1
sw $s0, 100($sp)
li $s0, 1
sw $s0, 104($sp)
li $s0, 5
sw $s0, 108($sp)
li.s $f4, 320.0
s.s $f4, 168($sp)
li.s $f5, 9.81
s.s $f5, 188($sp)
li.s $f6, 0.009
s.s $f6, 192($sp)
li.s $f7, 0.001
s.s $f7, 196($sp)
li.s $f8, 1.225
s.s $f8, 176($sp)
li.s $f9, 0.2
s.s $f9, 180($sp)
li.s $f10, 0.28
s.s $f10, 220($sp)
li.s $f11, 0.05
s.s $f11, 232($sp)
li.s $f16, 0.16
s.s $f16, 236($sp)
li.s $f17, 1000.0
s.s $f17, 204($sp)
li.s $f18, 10.0
s.s $f18, 212($sp)
li.s $f19, 1025.0
s.s $f19, 208($sp)
li.s $f20, 2.1
s.s $f20, 200($sp)
li.s $f20, 11.6
s.s $f20, 240($sp)
li.s $f20, 900.0
s.s $f20, 264($sp)
li.s $f20, 140.25
s.s $f20, 272($sp)
li.s $f20, 1.0
s.s $f20, 244($sp)
li.s $f20, 0.0
s.s $f20, 228($sp)
li $s0, 0
sw $s0, 112($sp)
_L0:
lw $t0, 112($sp)
lw $t1, 108($sp)
bgt $t0, $t1, _L1
l.s $f21, 208($sp)
l.s $f22, 204($sp)
l.s $f20, 288($sp)
sub.s $f20, $f21, $f22
s.s $f20, 288($sp)
l.s $f22, 288($sp)
l.s $f20, 200($sp)
l.s $f21, 292($sp)
div.s $f21, $f22, $f20
s.s $f21, 292($sp)
l.s $f22, 292($sp)
s.s $f22, 184($sp)
l.s $f20, 184($sp)
l.s $f21, 212($sp)
l.s $f22, 296($sp)
sub.s $f22, $f20, $f21
s.s $f22, 296($sp)
l.s $f21, 296($sp)
l.s $f22, 200($sp)
l.s $f20, 300($sp)
div.s $f20, $f21, $f22
s.s $f20, 300($sp)
l.s $f21, 300($sp)
s.s $f21, 172($sp)
l.s $f22, 168($sp)
l.s $f20, 188($sp)
l.s $f21, 304($sp)
mul.s $f21, $f22, $f20
s.s $f21, 304($sp)
l.s $f20, 196($sp)
l.s $f21, 184($sp)
l.s $f22, 308($sp)
mul.s $f22, $f20, $f21
s.s $f22, 308($sp)
l.s $f21, 192($sp)
l.s $f22, 308($sp)
l.s $f20, 312($sp)
add.s $f20, $f21, $f22
s.s $f20, 312($sp)
l.s $f22, 304($sp)
l.s $f20, 312($sp)
l.s $f21, 316($sp)
mul.s $f21, $f22, $f20
s.s $f21, 316($sp)
l.s $f22, 316($sp)
s.s $f22, 164($sp)
li.s $f20, 0.5
l.s $f21, 176($sp)
l.s $f22, 320($sp)
mul.s $f22, $f20, $f21
s.s $f22, 320($sp)
l.s $f21, 320($sp)
l.s $f22, 180($sp)
l.s $f20, 324($sp)
mul.s $f20, $f21, $f22
s.s $f20, 324($sp)
li $s0, 1
sw $s0, 116($sp)
l.s $f21, 184($sp)
s.s $f21, 328($sp)
_L2:
lw $t0, 116($sp)
li $t1, 2
bge $t0, $t1, _L3
l.s $f22, 328($sp)
l.s $f20, 184($sp)
l.s $f21, 328($sp)
mul.s $f21, $f22, $f20
s.s $f21, 328($sp)
lw $s0, 116($sp)
li $s1, 1
lw $s2, 116($sp)
add $s2, $s0, $s1
sw $s2, 116($sp)
j _L2
_L3:
l.s $f20, 324($sp)
l.s $f21, 328($sp)
l.s $f22, 332($sp)
mul.s $f22, $f20, $f21
s.s $f22, 332($sp)
l.s $f20, 332($sp)
s.s $f20, 160($sp)
l.s $f21, 160($sp)
l.s $f22, 164($sp)
l.s $f20, 336($sp)
add.s $f20, $f21, $f22
s.s $f20, 336($sp)
l.s $f22, 168($sp)
l.s $f20, 172($sp)
l.s $f21, 340($sp)
mul.s $f21, $f22, $f20
s.s $f21, 340($sp)
l.s $f20, 336($sp)
l.s $f21, 340($sp)
l.s $f22, 344($sp)
add.s $f22, $f20, $f21
s.s $f22, 344($sp)
l.s $f20, 344($sp)
s.s $f20, 156($sp)
l.s $f21, 156($sp)
l.s $f22, 220($sp)
l.s $f20, 348($sp)
mul.s $f20, $f21, $f22
s.s $f20, 348($sp)
l.s $f21, 348($sp)
s.s $f21, 216($sp)
li $s0, 0
sw $s0, 120($sp)
lw $t0, 104($sp)
li $t1, 0
ble $t0, $t1, _L4
li $s0, 1
sw $s0, 120($sp)
li $s0, 1
sw $s0, 124($sp)
l.s $f21, 240($sp)
s.s $f21, 352($sp)
_L5:
lw $t0, 124($sp)
li $t1, 2
bge $t0, $t1, _L6
l.s $f22, 352($sp)
l.s $f20, 240($sp)
l.s $f21, 352($sp)
mul.s $f21, $f22, $f20
s.s $f21, 352($sp)
lw $s0, 124($sp)
li $s1, 1
lw $s2, 124($sp)
add $s2, $s0, $s1
sw $s2, 124($sp)
j _L5
_L6:
li.s $f20, 0.011
l.s $f21, 352($sp)
l.s $f22, 356($sp)
mul.s $f22, $f20, $f21
s.s $f22, 356($sp)
li.s $f21, 0.0033
l.s $f22, 240($sp)
l.s $f20, 360($sp)
mul.s $f20, $f21, $f22
s.s $f20, 360($sp)
l.s $f22, 356($sp)
l.s $f20, 360($sp)
l.s $f21, 364($sp)
add.s $f21, $f22, $f20
s.s $f21, 364($sp)
l.s $f20, 364($sp)
li.s $f21, 0.02
l.s $f22, 368($sp)
add.s $f22, $f20, $f21
s.s $f22, 368($sp)
l.s $f20, 368($sp)
s.s $f20, 260($sp)
l.s $f21, 260($sp)
l.s $f22, 264($sp)
l.s $f20, 372($sp)
div.s $f20, $f21, $f22
s.s $f20, 372($sp)
li.s $f22, 1.0
l.s $f20, 372($sp)
l.s $f21, 376($sp)
sub.s $f21, $f22, $f20
s.s $f21, 376($sp)
l.s $f22, 376($sp)
s.s $f22, 248($sp)
l.s $f20, 272($sp)
li.s $f21, 79.0
l.s $f22, 380($sp)
sub.s $f22, $f20, $f21
s.s $f22, 380($sp)
li $s0, 0
sw $s0, 128($sp)
l.s $f20, 380($sp)
li $t0, 0
li $s0, 0
mtc1 $s0, $f21
cvt.s.w $f21, $f21
c.le.s $f20, $f21
bc1t _L4
li.s $f21, 0.0
cvt.w.s $f21, $f21
mtc1 $s0, $f21
sw $s0, 0
li $s0, 1
sw $s0, 128($sp)
li.s $f21, 7.6
l.s $f22, 380($sp)
l.s $f20, 384($sp)
mul.s $f20, $f21, $f22
s.s $f20, 384($sp)
l.s $f22, 384($sp)
li.s $f20, 600.0
l.s $f21, 388($sp)
add.s $f21, $f22, $f20
s.s $f21, 388($sp)
l.s $f22, 388($sp)
s.s $f22, 268($sp)
li.s $f20, 0.18
l.s $f21, 216($sp)
l.s $f22, 392($sp)
mul.s $f22, $f20, $f21
s.s $f22, 392($sp)
l.s $f21, 268($sp)
l.s $f22, 392($sp)
l.s $f20, 396($sp)
add.s $f20, $f21, $f22
s.s $f20, 396($sp)
li $s0, 0
sw $s0, 132($sp)
l.s $f21, 396($sp)
li $t0, 0
li $s0, 0
mtc1 $s0, $f22
cvt.s.w $f22, $f22
c.le.s $f21, $f22
bc1t _L4
li.s $f22, 0.0
cvt.w.s $f22, $f22
mtc1 $s0, $f22
sw $s0, 0
li $s0, 1
sw $s0, 132($sp)
l.s $f22, 268($sp)
l.s $f20, 396($sp)
l.s $f21, 400($sp)
div.s $f21, $f22, $f20
s.s $f21, 400($sp)
l.s $f22, 400($sp)
s.s $f22, 252($sp)
l.s $f20, 264($sp)
l.s $f21, 272($sp)
l.s $f22, 404($sp)
div.s $f22, $f20, $f21
s.s $f22, 404($sp)
l.s $f20, 404($sp)
s.s $f20, 280($sp)
li $s0, 1
sw $s0, 136($sp)
l.s $f20, 280($sp)
s.s $f20, 408($sp)
_L7:
lw $t0, 136($sp)
li $t1, 2
bge $t0, $t1, _L8
l.s $f21, 408($sp)
l.s $f22, 280($sp)
l.s $f20, 408($sp)
mul.s $f20, $f21, $f22
s.s $f20, 408($sp)
lw $s0, 136($sp)
li $s1, 1
lw $s2, 136($sp)
add $s2, $s0, $s1
sw $s2, 136($sp)
j _L7
_L8:
l.s $f22, 236($sp)
l.s $f20, 408($sp)
l.s $f21, 412($sp)
mul.s $f21, $f22, $f20
s.s $f21, 412($sp)
l.s $f22, 412($sp)
s.s $f22, 276($sp)
l.s $f20, 276($sp)
l.s $f21, 264($sp)
l.s $f22, 416($sp)
div.s $f22, $f20, $f21
s.s $f22, 416($sp)
li.s $f21, 1.0
l.s $f22, 416($sp)
l.s $f20, 420($sp)
add.s $f20, $f21, $f22
s.s $f20, 420($sp)
li $s0, 0
sw $s0, 140($sp)
l.s $f21, 420($sp)
li $t0, 0
li $s0, 0
mtc1 $s0, $f22
cvt.s.w $f22, $f22
c.le.s $f21, $f22
bc1t _L4
li.s $f22, 0.0
cvt.w.s $f22, $f22
mtc1 $s0, $f22
sw $s0, 0
li $s0, 1
sw $s0, 140($sp)
li.s $f22, 1.0
l.s $f20, 420($sp)
l.s $f21, 424($sp)
div.s $f21, $f22, $f20
s.s $f21, 424($sp)
l.s $f22, 424($sp)
s.s $f22, 256($sp)
l.s $f20, 248($sp)
l.s $f21, 252($sp)
l.s $f22, 428($sp)
mul.s $f22, $f20, $f21
s.s $f22, 428($sp)
l.s $f21, 428($sp)
l.s $f22, 256($sp)
l.s $f20, 432($sp)
mul.s $f20, $f21, $f22
s.s $f20, 432($sp)
l.s $f21, 432($sp)
s.s $f21, 244($sp)
li.s $f22, 3.0
l.s $f20, 232($sp)
l.s $f21, 436($sp)
mul.s $f21, $f22, $f20
s.s $f21, 436($sp)
li $s0, 1
sw $s0, 144($sp)
l.s $f22, 240($sp)
s.s $f22, 440($sp)
_L9:
lw $t0, 144($sp)
li $t1, 2
bge $t0, $t1, _L10
l.s $f20, 440($sp)
l.s $f21, 240($sp)
l.s $f22, 440($sp)
mul.s $f22, $f20, $f21
s.s $f22, 440($sp)
lw $s0, 144($sp)
li $s1, 1
lw $s2, 144($sp)
add $s2, $s0, $s1
sw $s2, 144($sp)
j _L9
_L10:
l.s $f21, 436($sp)
l.s $f22, 440($sp)
l.s $f20, 444($sp)
mul.s $f20, $f21, $f22
s.s $f20, 444($sp)
l.s $f21, 444($sp)
s.s $f21, 228($sp)
_L4:
li $s0, 0
sw $s0, 148($sp)
lw $t0, 100($sp)
li $t1, 0
ble $t0, $t1, _L11
li $s0, 1
sw $s0, 148($sp)
l.s $f22, 216($sp)
l.s $f20, 184($sp)
l.s $f21, 448($sp)
mul.s $f21, $f22, $f20
s.s $f21, 448($sp)
l.s $f20, 448($sp)
l.s $f21, 220($sp)
l.s $f22, 452($sp)
div.s $f22, $f20, $f21
s.s $f22, 452($sp)
l.s $f20, 452($sp)
s.s $f20, 284($sp)
l.s $f21, 284($sp)
l.s $f22, 244($sp)
l.s $f20, 456($sp)
mul.s $f20, $f21, $f22
s.s $f20, 456($sp)
l.s $f22, 456($sp)
l.s $f20, 228($sp)
l.s $f21, 460($sp)
add.s $f21, $f22, $f20
s.s $f21, 460($sp)
l.s $f22, 460($sp)
s.s $f22, 224($sp)
li $v0, 2
l.s $f22, 224($sp)
mov.s $f12, $f22
syscall
li $v0, 4
la $a0, newline
syscall
j _L12
_L11:
li $v0, 2
l.s $f22, 216($sp)
mov.s $f12, $f22
syscall
li $v0, 4
la $a0, newline
syscall
_L12:
l.s $f20, 272($sp)
li.s $f21, 1.0
l.s $f22, 464($sp)
sub.s $f22, $f20, $f21
s.s $f22, 464($sp)
l.s $f20, 464($sp)
s.s $f20, 272($sp)
lw $s0, 112($sp)
li $s1, 1
lw $s2, 112($sp)
add $s2, $s0, $s1
sw $s2, 112($sp)
j _L0
_L1:
li $v0, 0
# start of epilogue
lw $s0, 16($sp)
lw $s1, 20($sp)
lw $s2, 24($sp)
lw $s3, 28($sp)
lw $s4, 32($sp)
lw $s5, 36($sp)
lw $s6, 40($sp)
lw $s7, 44($sp)
l.s $f31, 48($sp)
l.s $f30, 52($sp)
l.s $f29, 56($sp)
l.s $f28, 60($sp)
l.s $f27, 64($sp)
l.s $f26, 68($sp)
l.s $f25, 72($sp)
l.s $f24, 76($sp)
lw $ra, 96($sp)
addiu $sp, $sp, 468
# end of epilogue
jr $ra
