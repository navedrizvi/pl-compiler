import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class TigerGraphListener extends TigerBaseListener {
    static class Graph {
        List<String> nodes = new ArrayList<>();
        MultiMap<String, String> edges = new MultiMap<>(); // caller->callee

        public void addEdge(String source, String target) {
            edges.map(source, target);
        }

        public void addNode(String node) {
            nodes.add(node);
        }

        public String toString() {
            return "nodes: " + nodes + "\nedges: " + edges.toString();
        }

        public String toDOT() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            for (String node : nodes) { // print all nodes first
                buf.append(node);
                buf.append("\n");
            }
            buf.append("\n");
            for (String src : edges.keySet()) {
                for (String trg : edges.get(src)) {
                    buf.append("  ");
                    buf.append(src);
                    buf.append(" -> ");
                    buf.append(trg);
                    buf.append(";\n");
               }
            }
            buf.append("}\n");
            return buf.toString();
        }
    }

    TigerParser parser;
    TigerLexer lexer;
    String[] ruleNames;
    Vocabulary vocabulary;
    int index;
    ParseTreeProperty<String> values = new ParseTreeProperty<>();
    Graph graph = new Graph();

    private final static Set<String> USER_DEFINED_TOKENS = new HashSet<>(Arrays.asList("ID", "INTLIT", "FLOATLIT"));

    public TigerGraphListener(TigerParser parser, TigerLexer lexer) {
        this.parser = parser;
        this.lexer = lexer;
        this.ruleNames = parser.getRuleNames();
        this.vocabulary = lexer.getVocabulary();
        this.index = 0;
    }

    public void setValue(ParseTree node, String value) { values.put(node, value); }

    public String getValue(ParseTree node) { return values.get(node); }

    @Override public void enterEveryRule(ParserRuleContext ctx) {
        String ruleName = ruleNames[ctx.getRuleIndex()];
        String node =  "node_" + index;
        String nodeWithLabel = node  + " [label = \"" + ruleName + "\"]";
        graph.addNode(nodeWithLabel);
        ParserRuleContext parent = ctx.getParent();
        // Not a root node
        if (parent != null)
            graph.addEdge(getValue(parent), node);

        setValue(ctx, node);
        index++;
    }

    @Override public void visitTerminal(TerminalNode terminalNode) {
        Token token = terminalNode.getSymbol();
        ParseTree parent = terminalNode.getParent();
        String symbol = vocabulary.getSymbolicName(token.getType());
        String node =  "node_" + index;
        String tokenName = null;
        if (USER_DEFINED_TOKENS.contains(symbol))
            tokenName = symbol + ":" + token.getText();
        else
            tokenName = symbol;

        String nodeWithLabel = node + " [label = \"" + tokenName + "\"]";
        graph.addNode(nodeWithLabel);
        // Parent of a terminal node will be a rule (type: ParserRuleContext)
        graph.addEdge(getValue(((ParserRuleContext) parent.getPayload())), node);
        index++;
    }
}
