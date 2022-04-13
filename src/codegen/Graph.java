package codegen;

import org.antlr.v4.runtime.misc.MultiMap;

import java.util.ArrayList;
import java.util.List;

public class Graph {
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
