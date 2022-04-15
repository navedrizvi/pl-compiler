package codegen;

import codegen.ir_instructions.*;
import org.antlr.v4.runtime.misc.MultiMap;

import java.util.*;

public class CFGBuilder {

    private final List<String> ir;
    private final Graph graph = new Graph();
    private Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG = new HashMap<>();
    private Map<String, List<String>> funcNameToIntList = new HashMap<>();
    private Map<String, List<String>> funcNameToFloatList = new HashMap<>();

    public CFGBuilder(List<String> ir) {
        this.ir = ir;
    }

    public Map<String, ArrayList<String>> build() {
        // create mapping of function to IR lines per function
        Map<String, ArrayList<String>> funcNameToFunc = getFuncNameToFunc();
        // for each function, create Basic Blocks and then CFG from the blocks
        for (Map.Entry<String, ArrayList<String>> entry: funcNameToFunc.entrySet()) {
            String funcName = entry.getKey();
            ArrayList<String> instructions = entry.getValue();

            // create CFG
            Map<BasicBlock, List<BasicBlock>> cfg = createCFG(instructions, funcName);
            funcNameToCFG.put(funcName, cfg);
            populateGraphForDOT(cfg);
        }

        return funcNameToFunc;
    }

    public Map<String, Map<BasicBlock, List<BasicBlock>>> getFuncNameToCFG() {
        return funcNameToCFG;
    }

    public Map<String, List<String>> getFuncNameToIntList() {
        return funcNameToIntList;
    }

    public Map<String, List<String>> getFuncNameToFloatList() {
        return funcNameToFloatList;
    }

    private void populateGraphForDOT(Map<BasicBlock, List<BasicBlock>> cfg) {
        for (Map.Entry<BasicBlock, List<BasicBlock>> entry : cfg.entrySet()) {
            BasicBlock key = entry.getKey();
            List<BasicBlock> values = entry.getValue();
            graph.addNode(key);
            for (BasicBlock bb: values) {
                graph.addEdge(key, bb);
            }
        }
    }

    private Map<BasicBlock, List<BasicBlock>> createCFG(List<String> instructions, String funcName) {
        BasicBlockBuilder builder = new BasicBlockBuilder(instructions, funcName);
        builder.build();
        return builder.generateCFG();
    }

    private Map<String, ArrayList<String>> getFuncNameToFunc() {
        Map<String, ArrayList<String>> funcNameToFunc = new HashMap<>();
        boolean insideFunction = false;
        String functioName = null;
        int functionStartIndex = 0;
        for (String instruction: ir) {
            if (instruction.startsWith("start_function")) {
                insideFunction = true;
                functioName = instruction.split(" ")[1];
                funcNameToFunc.put(functioName, new ArrayList<>());
                continue;
            }

            if (instruction.startsWith("end_function")) {
                insideFunction = false;
                functionStartIndex = 0;
                continue;
            }

            if (insideFunction) {
                functionStartIndex++;
                if (instruction.startsWith("int-list")) {
                    funcNameToIntList.put(functioName, Arrays.asList(instruction.replace("int-list: ", "").split(", ")));
                }

                if (instruction.startsWith("float-list")) {
                    funcNameToFloatList.put(functioName, Arrays.asList(instruction.replace("float-list: ", "").split(", ")));
                }

                if(functionStartIndex < 5)
                    continue;
                funcNameToFunc.get(functioName).add(instruction);
            }
        }
        return funcNameToFunc;
    }

    public Graph getGraph() {
        return graph;
    }
}
