package codegen;

import java.util.*;

public class InterferenceGraph {

    Set<String> nodes = new HashSet<>();
    Map<String, Set<String>> edges = new HashMap<>();

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public void addNode(String node) {
        nodes.add(node);
    }

    public Set<String> getNodes() {
        return nodes;
    }

    public Set<String> getEdges(String node) {
        return edges.get(node);
    }

    public void addEdge(String nodeA, String nodeB) {
        if (!edges.containsKey(nodeA)) {
            edges.put(nodeA, new HashSet<>());
        }
        edges.get(nodeA).add(nodeB);

        if (!edges.containsKey(nodeB)) {
            edges.put(nodeB, new HashSet<>());
        }
        edges.get(nodeB).add(nodeA);
    }

    public Integer getNodeDegree(String node) {
        if (edges.get(node) != null)
            return edges.get(node).size();
        return 0;
    }

    public void removeNode(String nodeA) {
        nodes.remove(nodeA);
        edges.remove(nodeA);
        for (String key : edges.keySet()) {
            edges.get(key).remove(nodeA);
        }
    }

    public InterferenceGraph clone() {
        InterferenceGraph ig = new InterferenceGraph();
        for(Map.Entry<String, Set<String>> entry : edges.entrySet()) {
            ig.addNode(entry.getKey());
            for(String node : entry.getValue()) {
                ig.addNode(node);
                ig.addEdge(entry.getKey(), node);
            }
        }

        return ig;
    }

}
