import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TigerGraphListener extends TigerBaseListener {
    static class Graph {
        Set<String> nodes = new OrderedHashSet<String>(); // list of functions
        MultiMap<String, String> edges = new MultiMap<String, String>(); // caller->callee
//        int index = 0;

        public void addEdge(String source, String target) {
            edges.map(source, target);
        }

        public void addNode(String node) {
//            nodes.add(node + index + " [label = \"" + node + "\"]");
            nodes.add(node);
//            index++;
        }

        public String toString() {
            return "edges: " + edges.toString() + ", functions: " + nodes;
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

    private final static Set<String> USER_DEFINED_TOKENS = new HashSet<>(Arrays.asList("ID", "INTLIT", "FLOATLINT"));

    public TigerGraphListener(TigerParser parser, TigerLexer lexer) {
        this.parser = parser;
        this.lexer = lexer;
        this.ruleNames = parser.getRuleNames();
        this.vocabulary = lexer.getVocabulary();
        this.index = 0;
    }

    Graph graph = new Graph();

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) {
        String parentRuleName = ruleNames[ctx.getRuleIndex()];
        String parentNodeRuleName =  parentRuleName + index;
        String parentNodeRuleNameWithLabel = parentNodeRuleName  + " [label = \"" + parentRuleName + "\"]";
        graph.addNode(parentNodeRuleNameWithLabel);
        index++;
        if (ctx.children == null ) {
            return;
        }

//        System.out.println(ctx.children);
        for (ParseTree child: ctx.children) {
            Object payload = child.getPayload();
            if (child.getPayload() instanceof ParserRuleContext) {
                RuleContext ruleContext = (ParserRuleContext) payload;
                String ruleName = ruleNames[(ruleContext).getRuleIndex()];
                String nodeRuleName =  ruleName + index;
                String nodeRuleNameWithLabel = nodeRuleName  + " [label = \"" + ruleName + "\"]";
               // index++;
                graph.addNode(nodeRuleNameWithLabel);
                graph.addEdge(parentNodeRuleName, nodeRuleName);
            }
            else {
                Token token = (Token) payload;
                String symbol = vocabulary.getSymbolicName(token.getType());
                String tokenName = null;
                String nodeTokenName = null;
                String nodeTokenNameWithLabel = null;
                if (USER_DEFINED_TOKENS.contains(symbol)) {
                    tokenName = "\"" + symbol + ":" + token.getText() + "\"";
                    nodeTokenName = "\"" + symbol + ":" + token.getText() + index + "\"";;
                    nodeTokenNameWithLabel = nodeTokenName + " [label = \"" + tokenName.replace("\"", "") + "\"]";
                }
                else {
                    tokenName = symbol;
                    nodeTokenName = symbol + index;
                    nodeTokenNameWithLabel = nodeTokenName + " [label = \"" + tokenName + "\"]";
                }
                //index++;
                graph.addNode(nodeTokenNameWithLabel);
                graph.addEdge(parentNodeRuleName, nodeTokenName);
            }
        }
    }

    @Override public void exitEveryRule(ParserRuleContext ctx) {
        if (index == 0)
            return;
        index--;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
//    @Override public void exitEveryRule(ParserRuleContext ctx) {
//        String ruleName = ruleNames[ctx.getRuleIndex()];
//        System.out.println("At exit for: " + ruleName);
//        ParserRuleContext parentCtx = ctx.getParent();
//        if (parentCtx == null) {
//            System.out.println("Node " + ruleName + " is root");
//            return;
//        }
//        String parent = ruleNames[parentCtx.getRuleIndex()];
//        System.out.println("exitEveryRule: " + parent + " " + ruleName);
//        graph.addEdge(parent, ruleName);
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * <p>The default implementation does nothing.</p>
//     */
//    @Override public void visitTerminal(TerminalNode node) {
//        Token token = node.getSymbol();
//        ParseTree parent = node.getParent();
//        String symbol = vocabulary.getSymbolicName(token.getType());
//        String tokenName = null;
//        if (USER_DEFINED_TOKENS.contains(symbol))
//            tokenName = "\"" + symbol + ":" + token.getText() + "\"";
//        else
//            tokenName = symbol;
//        System.out.println("visitTerminal: " + ruleNames[((ParserRuleContext) parent.getPayload()).getRuleIndex()] + " " + tokenName);
//        graph.addEdge(ruleNames[((ParserRuleContext) parent.getPayload()).getRuleIndex()], tokenName);
//    }

}
