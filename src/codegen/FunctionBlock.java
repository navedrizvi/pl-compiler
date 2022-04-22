package codegen;

import java.util.*;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;
import common.SymbolTable;

public class FunctionBlock {
    private String functionName;
    private String returnType;
    // todo can use tuple instead
    private List<String> functionArgs;
    private List<String> staticIntList;
    private List<String> staticFloatList;
    private String[] intList;
    private String[] floatList;
    private IRInstruction[] instructions;
    private int maxArgs;
    private SymbolTable symbolTable;
    private Map<String, List<String>> globalFunctionToArgs;
    Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG;
    Map<String, LivenessAnalysis> funcNameToLivenessAnaylsis;
    int registerLimit;

    public FunctionBlock(
            String functionName, String returnType, List<String> functionArgs, List<String> staticIntList,
            List<String> staticFloatList, String[] intList, String[] floatList, IRInstruction[] instructions,
            int maxArgs, SymbolTable symbolTable, int registerLimit
    ) {
        this.functionName = functionName;
        this.returnType = returnType;
        this.functionArgs = functionArgs;
        this.intList = intList;
        this.floatList = floatList;
        this.instructions = instructions;
        this.staticIntList = staticIntList;
        this.staticFloatList = staticFloatList;
        this.maxArgs = maxArgs;
        this.symbolTable = symbolTable;
        this.registerLimit = registerLimit;
    }

    public void setGlobalFunctionToArgs(Map<String, List<String>> functionToArgs) {
        this.globalFunctionToArgs = functionToArgs;
    }

    public Map<String, List<String>> getGlobalFunctionToArgs() {
        return globalFunctionToArgs;
    }

    public void setFuncNameToCFG(Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG) {
        this.funcNameToCFG = funcNameToCFG;
    }

    public void setFuncNameToLivenessAnaylsis(Map<String, LivenessAnalysis> funcNameToLivenessAnaylsis) {
        this.funcNameToLivenessAnaylsis = funcNameToLivenessAnaylsis;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<String> getFunctionArgs() {
        return functionArgs;
    }

    public List<String> getStaticIntList() {
        return staticIntList;
    }

    public List<String> getStaticFloatList() {
        return staticFloatList;
    }

    public String[] getIntList() {
        return intList;
    }

    public String[] getFloatList() {
        return floatList;
    }

    public int getMaxArgs() {
        return maxArgs;
    }

    public List<MipsInstruction> getNaiveMips() {
        MipsCodeGenerator naiveMips = new MipsCodeGenerator(instructions, this, symbolTable, this.registerLimit);
        List<MipsInstruction> out = naiveMips.generateMipsInstructionsForNaive();
        return out;
    }

    public List<MipsInstruction> getIntraBlockMips() {
        Map<BasicBlock, Map<String, Integer>> sortedHistogramByCountDesc = generateSortedHistogramByCountDesc();
        MipsCodeGenerator intraBlockMips = new MipsCodeGenerator(instructions, this, symbolTable, this.registerLimit);
        List<MipsInstruction> out = intraBlockMips.generateMipsInstructionsForIntraBlock(sortedHistogramByCountDesc);
        return out;
    }

    public List<MipsInstruction> getBriggsMips() {
        InterferenceGraph interferenceGraph = buildInterferenceGraph();
        MipsCodeGenerator intraBlockMips = new MipsCodeGenerator(instructions, this, symbolTable, this.registerLimit);
        List<MipsInstruction> out = intraBlockMips.generateMipsInstructionsForBriggs(interferenceGraph);
        return out;
    }

    private InterferenceGraph buildInterferenceGraph() {
        InterferenceGraph interferenceGraph = new InterferenceGraph();
        LivenessAnalysis livenessAnalysis = funcNameToLivenessAnaylsis.get(functionName);

        for (String instruction : livenessAnalysis.getInstructions()) {
            Set<String> inSet = livenessAnalysis.getInSet().get(instruction);
            for(String variable1 : inSet) {
                interferenceGraph.addNode(variable1);
                for (String variable2 : inSet) {
                    interferenceGraph.addNode(variable2);

                    if (variable1.equals(variable2))
                        continue;

                    if (Arrays.asList(intList).contains(variable1) && Arrays.asList(intList).contains(variable2)) {
                        interferenceGraph.addEdge(variable1, variable2);
                    }

                    if (Arrays.asList(floatList).contains(variable1) && Arrays.asList(floatList).contains(variable2)) {
                        interferenceGraph.addEdge(variable1, variable2);
                    }
                }
            }

            Set<String> outSet = livenessAnalysis.getOutSet().get(instruction);
            for(String variable1 : outSet) {
                interferenceGraph.addNode(variable1);
                for (String variable2 : outSet) {
                    interferenceGraph.addNode(variable2);

                    if (variable1.equals(variable2))
                        continue;

                    if (Arrays.asList(intList).contains(variable1) && Arrays.asList(intList).contains(variable2)) {
                        interferenceGraph.addEdge(variable1, variable2);
                    }

                    if (Arrays.asList(floatList).contains(variable1) && Arrays.asList(floatList).contains(variable2)) {
                        interferenceGraph.addEdge(variable1, variable2);
                    }
                }
            }
        }

        return interferenceGraph;
    }

    private Map<BasicBlock, Map<String, Integer>> generateSortedHistogramByCountDesc() {
        // Generate frequencies
        Map<BasicBlock, List<BasicBlock>> cfg = funcNameToCFG.get(functionName);
        Map<BasicBlock, Map<String, Integer>> histogram = generateHistogram(cfg);

        // Sort frequencies by highest to lowest
        Map<BasicBlock, Map<String, Integer>> sortedHistogramByCountDesc = sortHistogramByCountDesc(histogram);

        return sortedHistogramByCountDesc;
    }

    private Map<BasicBlock, Map<String, Integer>> sortHistogramByCountDesc(Map<BasicBlock, Map<String, Integer>> histogram) {
        Map<BasicBlock, Map<String, Integer>> sortedHistogramByCountDesc = new LinkedHashMap<>();
        for (Map.Entry<BasicBlock, Map<String, Integer>> block: histogram.entrySet()) {
            Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();
            block.getValue().entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
            sortedHistogramByCountDesc.put(block.getKey(), reverseSortedMap);
        }
        return sortedHistogramByCountDesc;
    }

    private Map<BasicBlock, Map<String, Integer>> generateHistogram(Map<BasicBlock, List<BasicBlock>> cfg) {
        Map<BasicBlock, Map<String, Integer>> histogram = new LinkedHashMap<>();

        for (BasicBlock block : cfg.keySet()) {
            histogram.put(block, generateFrequencies(block));
        }

        return histogram;
    }

    private Map<String, Integer> generateFrequencies(BasicBlock block) {
        Map<String, Integer> freq = new HashMap<>();
        for(String instruction: block.getInstructions()) {
            String[] split = instruction.split(",");
            ArrayList<String> args = new ArrayList<>();
            for (String i : Arrays.asList(split).subList(1, split.length)) {
                if (!i.isEmpty())
                    args.add(i.trim());
            }
            count(freq, args);
        }
        return freq;
    }

    private void count(Map<String, Integer> freq, ArrayList<String> args) {
        for(String arg: args) {
            if (Arrays.asList(intList).contains(arg) || staticIntList.contains(arg) || Arrays.asList(floatList).contains(arg) || staticFloatList.contains(arg)) {
                Integer count = freq.get(arg);
                if (count == null)
                    freq.put(arg, 1);
                else
                    freq.put(arg, count + 1);
            }
        }
    }
}
