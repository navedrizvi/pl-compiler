package codegen;

import java.util.*;

public class LivenessAnalysis {

    private Map<BasicBlock, List<BasicBlock>> cfg;
    private ArrayList<String> instructions;
    private List<String> intList;
    private List<String> floatList;
    private Map<String, Set<String>> inSet = new HashMap<>();
    private Map<String, Set<String>> outSet = new HashMap<>();
    private Map<String, Set<String>> defSet = new HashMap<>();
    private Map<String, Set<String>> useSet = new HashMap<>();

    public LivenessAnalysis(
            Map<BasicBlock, List<BasicBlock>> cfg, ArrayList<String> instructions,
            List<String> intList, List<String> floatList
    ) {
        this.cfg = cfg;
        this.instructions = instructions;
        this.intList = intList;
        this.floatList = floatList;
    }

    public void execute() {
        for (String instruction: instructions) {
            inSet.put(instruction, new HashSet<>());
            outSet.put(instruction, new HashSet<>());
            defSet.put(instruction, new HashSet<>());
            useSet.put(instruction, new HashSet<>());
        }

        createDefandUseSets();
        Map<String, Set<String>> successors = determineSuccessors();
//        // System.out.println(defSet);
//        // System.out.println(useSet);
//        // System.out.println(successors);

        Map<String, Set<String>> previousInSet = new HashMap<>();
        Map<String, Set<String>> previousOutSet = new HashMap<>();

        while (true) {
            for (String instruction: instructions) {
                previousInSet.put(instruction, inSet.get(instruction));
                previousOutSet.put(instruction, outSet.get(instruction));
                Set<String> newIntSet = new HashSet<>(outSet.get(instruction));
                newIntSet.removeAll(defSet.get(instruction));
                newIntSet.addAll(useSet.get(instruction));
                inSet.put(instruction, newIntSet);

                Set<String> r = new HashSet<>();
                for (String successor: successors.get(instruction)) {
                    r.addAll(inSet.get(successor));
                }
                outSet.put(instruction, r);
            }

            if (noChange(inSet, previousInSet, outSet, previousOutSet))
                break;
        }
    }

    public Map<String, Set<String>> getInSet() {
        return inSet;
    }

    public Map<String, Set<String>> getOutSet() {
        return outSet;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    private void createDefandUseSets() {
        for(String instruction: instructions) {
            defSet.put(instruction, new HashSet<>());
            String[] split = instruction.split(",");
            String operation = split[0];
            ArrayList<String> args = new ArrayList<>();
            for (String i : Arrays.asList(split).subList(1, split.length)) {
                if (!i.isEmpty())
                    args.add(i.trim());
            }
            switch (operation) {
                case "assign":
                    if (intList.contains(args.get(0)) || floatList.contains(args.get(0)))
                        defSet.get(instruction).add(args.get(0));
                    if (intList.contains(args.get(1)) || floatList.contains(args.get(1)))
                        useSet.get(instruction).add(args.get(1));
                    break;
                case "add":
                case "sub":
                case "mult":
                case "div":
                case "and":
                case "or":
                    if (intList.contains(args.get(0)) || floatList.contains(args.get(0)))
                        useSet.get(instruction).add(args.get(0));
                    if (intList.contains(args.get(1)) || floatList.contains(args.get(1)))
                        useSet.get(instruction).add(args.get(1));
                    if (intList.contains(args.get(2)) || floatList.contains(args.get(2)))
                        defSet.get(instruction).add(args.get(2));
                    break;
                case "breq":
                case "brneq":
                case "brlt":
                case "brgt":
                case "brleq":
                case "brgeq":
                    if (intList.contains(args.get(0)) || floatList.contains(args.get(0)))
                        useSet.get(instruction).add(args.get(0));
                    if (intList.contains(args.get(1)) || floatList.contains(args.get(1)))
                        useSet.get(instruction).add(args.get(1));
                    break;
                case "return":
                    if (!args.isEmpty() && (intList.contains(args.get(0)) || floatList.contains(args.get(0))))
                        useSet.get(instruction).add(args.get(0));
                    break;
                case "call":
                case "array_store":
                    for(String arg: args) {
                        if (intList.contains(arg) || floatList.contains(arg))
                            useSet.get(instruction).add(arg);
                    }
                    break;
                case "array_load":
                case "callr":
                    if (intList.contains(args.get(0)) || floatList.contains(args.get(0)))
                        defSet.get(instruction).add(args.get(0));
                    for(int i = 1; i < args.size(); i++) {
                        if (intList.contains(args.get(i)) || floatList.contains(args.get(i)))
                            useSet.get(instruction).add(args.get(i));
                    }
                    break;
            }
        }
    }

    private Map<String, Set<String>> determineSuccessors() {
        Map<String, Set<String>> successors = new HashMap<>();
        for(String instruction : instructions)
            successors.put(instruction, new HashSet<>());

        for(BasicBlock block : cfg.keySet()) {
            List<String> instructions = block.getInstructions();
            for (int i = 0; i < instructions.size(); i++) {
                String instruction = instructions.get(i);
                if(instruction.equals(block.getLastInstruction())) {
                    for (BasicBlock succ: cfg.get(block)) {
                        successors.get(instruction).add(succ.getLeader());
                    }
                }
                else {
                    successors.get(instruction).add(instructions.get(i+1));
                }
            }
        }

        return successors;
    }

    private boolean noChange(Map<String, Set<String>> inSet, Map<String, Set<String>> previousInSet, Map<String, Set<String>> outSet, Map<String, Set<String>> previousOutSet) {
        boolean done = true;

        for(String instruction : instructions) {
            if(!previousInSet.get(instruction).equals(inSet.get(instruction)))
                done = false;

            if(!previousOutSet.get(instruction).equals(outSet.get(instruction)))
                done = false;
        }

        return done;
    }
}

