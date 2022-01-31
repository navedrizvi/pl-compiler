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

        public void addEdge(String source, String target) {
            edges.map(source, target);
        }

        public void addNode(String node) {
            nodes.add(node);
        }

        public String toString() {
            return "edges: " + edges.toString() + ", functions: " + nodes;
        }

        public String toDOT() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            for (String node : nodes) { // print all nodes first
                buf.append(node);
                buf.append("; ");
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

    private final static Set<String> USER_DEFINED_TOKENS = new HashSet<>(Arrays.asList("ID", "INTLIT", "FLOATLINT"));

    public TigerGraphListener(TigerParser parser, TigerLexer lexer) {
        this.parser = parser;
        this.lexer = lexer;
        this.ruleNames = parser.getRuleNames();
        this.vocabulary = lexer.getVocabulary();
    }

    Graph graph = new Graph();

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) {
        String ruleName = ruleNames[ctx.getRuleIndex()];
        graph.addNode(ruleName);
        if (ctx.children == null ) {
            return;
        }

        for (ParseTree child: ctx.children) {
            Object payload = child.getPayload();
            if (child.getPayload() instanceof ParserRuleContext) {
                RuleContext ruleContext = (ParserRuleContext) payload;
                ruleName = ruleNames[(ruleContext).getRuleIndex()];
                graph.addNode(ruleName);
            }
            else {
                Token token = (Token) payload;
                String symbol = vocabulary.getSymbolicName(token.getType());
                String tokenName = null;
                if (USER_DEFINED_TOKENS.contains(symbol))
                    tokenName = symbol + ":" + token.getText();
                else
                    tokenName = symbol;
                graph.addNode(tokenName);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }

}
