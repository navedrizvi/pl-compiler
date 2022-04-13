package codegen;

import java.util.*;

public class BasicBlockBuilder {

    private List<String> instructions;
    List<BasicBlock> basicBlocks = new ArrayList<>();
    private String funcName;

    public BasicBlockBuilder(List<String> instructions, String funcName) {
        this.instructions = instructions;
        this.funcName = funcName;
    }

    public void build() {
        // Identify leaders
        List<Integer> leaders = findLeaders();
        int bbIndex = 1;
        for(int i = 1; i < leaders.size(); i++) {
            List<String> instructionsForBB = new ArrayList<>();
            List<Integer> instructionsIndexForBB = new ArrayList<>();
            for(int j = leaders.get(i-1); j < leaders.get(i); j++) {
                instructionsForBB.add(instructions.get(j));
                instructionsIndexForBB.add(j);
            }
            BasicBlock bb = new BasicBlock(instructionsForBB, instructionsIndexForBB, bbIndex, funcName);
            basicBlocks.add(bb);
            bbIndex++;
        }
        // last leader
        List<String > instructionsForBB = new ArrayList<>();
        List<Integer> instructionsIndexForBB = new ArrayList<>();
        for(int j = leaders.get(leaders.size()-1); j < instructions.size(); j++) {
            instructionsForBB.add(instructions.get(j));
            instructionsIndexForBB.add(j);
        }
        BasicBlock bb = new BasicBlock(instructionsForBB, instructionsIndexForBB, bbIndex, funcName);
        basicBlocks.add(bb);
    }

    public Map<BasicBlock, List<BasicBlock>> generateCFG() {
        Map<BasicBlock, List<BasicBlock>> map = new LinkedHashMap<>();
        for (BasicBlock outerBB: basicBlocks) {
            map.put(outerBB, new ArrayList<>());
            for (BasicBlock innerBB: basicBlocks) {
                // Rule A: branch from last statement of outerBB to first statement of innerBB
                String outerBBLastInstruction = outerBB.getLastInstruction();
                String innerBBFirstInstruction = innerBB.getLeader();
                if (isBranch(outerBBLastInstruction) && isLabel(innerBBFirstInstruction)) {
                    String[] outerBBList = outerBBLastInstruction.split(",");
                    String outerBBLabel = outerBBList[outerBBList.length-1].trim();
                    String innerBBLabel = innerBBFirstInstruction.split(":")[0].trim();
                    if (outerBBLabel.equals(innerBBLabel)) {
                        map.get(outerBB).add(innerBB);
                    }
                }

                // Rule B: Control flow can fall through from B1 to B2 if B2
                // immediately follows B1 and B1 does not end with an unconditional branch
                if ((innerBB.getInstructionIndexes().get(innerBB.getInstructions().indexOf(innerBBFirstInstruction)) - outerBB.getInstructionIndexes().get(outerBB.getInstructions().indexOf(outerBBLastInstruction)) == 1)
                        && !outerBBLastInstruction.contains("goto")
                ) {
                    map.get(outerBB).add(innerBB);
                }
            }
        }
        return map;
    }

    private List<Integer> findLeaders() {
        List<Integer> leaders = new ArrayList<>();
        for(int i = 0; i < instructions.size(); i++) {
            // Rule 1: first statement
            if (i == 0) {
                leaders.add(i);
            }
            String instruction = instructions.get(i);
            // Rule 2: label: L*:
            if (isLabel(instruction)) {
                leaders.add(i);
            }

            // Rule 3: if statement is currently a branch statement or return statement
            // next statement after that is a leader unless that statement after is a label or
            // current statement is last line
            // current statement is branch or return statement AND not the last line AND next line is not a label
            if (isBranchOrReturn(instruction) && (i != instructions.size() - 1) && (!isLabel(instructions.get(i+1)))) {
                leaders.add(i+1);
            }

        }
        return leaders;
    }

    private boolean isLabel(String instruction) {
        return instruction.startsWith("_L") && instruction.endsWith(":");
    }

    private boolean isBranchOrReturn(String instruction) {
        Set<String> ops = Set.of( "return", "goto", "breq", "brneq", "brlt", "brgt", "brleq", "brgeq");
        String op = instruction.split(",")[0].trim();
        if (ops.contains(op))
            return true;
        return false;
    }

    private boolean isBranch(String instruction) {
        Set<String> ops = Set.of("goto", "breq", "brneq", "brlt", "brgt", "brleq", "brgeq");
        String op = instruction.split(",")[0].trim();
        if (ops.contains(op))
            return true;
        return false;
    }
}
