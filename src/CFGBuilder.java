import codegen.ir_instructions.*;
import org.antlr.v4.runtime.misc.MultiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CFGBuilder {

    private final List<String> ir;

    private final Graph graph = new Graph();

    public CFGBuilder(List<String> ir) {
        this.ir = ir;
    }

    public void build() {
        // create mapping of function to IR lines per function
        Map<String, ArrayList<String>> funcNameToFunc = getFuncNameToFunc();
        // for each function, create Basic Blocks and then CFG from the blocks
        Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry: funcNameToFunc.entrySet()) {
            String funcName = entry.getKey();
            ArrayList<String> instructions = entry.getValue();

            // create CFG
            Map<BasicBlock, List<BasicBlock>> cfg = createCFG(instructions, funcName);
            funcNameToCFG.put(funcName, cfg);
            populateGraphForDOT(cfg);
        }
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

    static class Graph {
        List<BasicBlock> nodes = new ArrayList<>();
        MultiMap<BasicBlock, BasicBlock> edges = new MultiMap<>(); // caller -> callee

        public void addEdge(BasicBlock source, BasicBlock target) {
            edges.map(source, target);
        }

        public void addNode(BasicBlock node) {
            nodes.add(node);
        }

        public String toString() {
            return "nodes: " + nodes + "\nedges: " + edges.toString();
        }

        public String toDOT() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            for (BasicBlock node : nodes) { // print all nodes first
                buf.append(node.toNodeLabel());
                buf.append("\n");
            }
            buf.append("\n");
            for (BasicBlock src : edges.keySet()) {
                for (BasicBlock trg : edges.get(src)) {
                    buf.append("  ");
                    buf.append(src.toString());
                    buf.append(" -> ");
                    buf.append(trg.toString());
                    buf.append(";\n");
                }
            }
            buf.append("}\n");
            return buf.toString();
        }
    }
}
