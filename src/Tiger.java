import java.util.Arrays;
import java.io.File;
import java.io.IOException;
// TODO need to ensure nio is available in Docker container
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.*;

public class Tiger {
    private static boolean srcFileExists(String fpath) {
        File f = new File(fpath);
        return f.exists();
    }

    private static void writeFileWithContent(String fpath, String contents) {
        // File destination = new File(fpath);
        Path targetPath = Paths.get(fpath);
        try {
            Files.write(targetPath, contents.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error in creating new file"); 
            // minor TODO what error to return here, or silently exit?
        }
    }

    private static TigerLexer getLexer(String fileName) {
        /* Req 4: When the -l flag is provided, write the stream of tokens to a file. The output file should have the same name and path as the input file with the extension changed to .tokens. Output one tuple per line using the syntax <token type, "token value">.
            ref: https://stackoverflow.com/a/49981691 (TODO also describes handling parser error, but only handle lexer for now until Parser is implemented)
        */
        try {
            LexicalErrorListener errorListener = new LexicalErrorListener();
            CharStream input = CharStreams.fromFileName(fileName); // minor TODO refactor to pass this as an arg to avoid addl. overhead
            TigerLexer lexer = new TigerLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            return lexer;
        }
        catch (IOException e) {
            // minor style TODO. this is duplicate logic of srcFileExists. try doing this one time in a refactor for neatness
            System.out.println("Error in program arguments: source file not found");
            System.exit(1);
            return null;
        }
    }

    private static TigerParser getTigerParser(CommonTokenStream tokens) {
        ParserErrorListener errorListener = new ParserErrorListener();
        TigerParser parser = new TigerParser((TokenStream) tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        return parser;
    }

    private static void checkScannerErrors(TigerLexer lexer) {
        while (true) {
            Token token = lexer.nextToken();
            if (token.getType() == Token.EOF) {
                break;
            }
        }
        lexer.reset();
    }


    private static void writeTokenFile(TigerLexer lexer, String fileName) {
        /* Req 4: When the -l flag is provided, write the stream of tokens to a file. The output file should have the same name and path as the input file with the extension changed to .tokens. Output one tuple per line using the syntax <token type, "token value">.
            ref: https://stackoverflow.com/a/22531110
        */
        String tokenFileToCreateFname = fileName.replace(".tiger", ".tokens");
        String tokenFileToCreateContent = "";
        while (true) {
            Token token = lexer.nextToken();
            if (token.getType() == Token.EOF) {
                break;
            }
            String tokenTupleStr = "<" + TigerLexer.VOCABULARY.getSymbolicName(token.getType()) + "," + " \"" + token.getText() + "\">\n";
            // System.out.println(tokenTupleStr); // for debugging
            tokenFileToCreateContent += tokenTupleStr;
        }
        writeFileWithContent(tokenFileToCreateFname, tokenFileToCreateContent);
        lexer.reset();
    }

    private static String parseTreeToGraph(TigerParser parser, TigerLexer lexer, ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        TigerGraphListener tigerGraphListener = new TigerGraphListener(parser, lexer);
        walker.walk(tigerGraphListener, tree);
        return tigerGraphListener.graph.toDOT();
    }

    private static void writeGraphToFile(String fileName, String graph) {
        String outputFile = fileName.replace(".tiger", ".tree.gv");
        writeFileWithContent(outputFile, graph);
    }

    public static void main(String[] args) {
        // TODO should we print descriptive error messages before error exit? we are right now for sake of debugging
        if (!(args.length >= 2)) {
            System.out.println("Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)");
            System.exit(1); // Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)
        }

        /* Ensure args are valid */
        // minor TODO confirm do we need to support input stream, or only file?
        String[] validArgFlags = new String[] {"-l", "-p"};
        boolean lFlagProvided = false; // if provided, write a `<source_fname>.tokens` file with tokens per Req. 4
        boolean pFlagProvided = false; // if provided, write a `<source_fname>.tree.gv` file with parse tree in GraphViz DOT format per Req. 6

        // validate first 2 args
        String fileName = args[1];
        if (!args[0].equals("-i")) {
            System.out.println("Error in program arguments: necessary arg -i not provided");
            System.exit(1); // Error in program arguments: necessary arg not provided.
        }
        else {
            // if -i arg, check the next arg is presumably the source tiger file
            if (!fileName.endsWith(".tiger")) {
                System.out.println("Error in program arguments: file doesn't end with '.tiger'");
                System.exit(1); // Error in program arguments: file doesn't end with '.tiger'. TODO confirm this is correct error to throw
            }
            else if (!srcFileExists(fileName)) {
                System.out.println("Error in program arguments: source file not found");
                System.exit(1); // Error in program arguments: source file not found
            }
        }

        // start from 3rd idx b/c first 2 args are verified
        for (int i=2; i < args.length; i++) {
            if (!Arrays.asList(validArgFlags).contains(args[i])) {
                System.out.println("Error in program arguments: unknown argument " + args[i]);
                System.exit(1); // Error in program arguments: unknown argument
            }
            if (args[i].equals(("-l"))) {
                lFlagProvided = true;
            }

            if (args[i].equals(("-p"))) {
                pFlagProvided = true;
            }
        }

        TigerLexer lexer = getLexer(fileName);

        if (lFlagProvided) {
            writeTokenFile(lexer, fileName);
        }
        else {
            checkScannerErrors(lexer);
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TigerParser parser = getTigerParser(tokens); //new TigerParser((TokenStream) tokens);

        if (pFlagProvided) {
            ParseTree tree = parser.main(); // Note: this will throw parser error
            String parseTreeAsGraph = parseTreeToGraph(parser, lexer, tree);
//            StringBuilder buf = new StringBuilder();
//            buf.append("digraph G {\n");
//            buf.append("A -> B -> C\n");
//            buf.append("}\n");
            writeGraphToFile(fileName, parseTreeAsGraph);
        }
        else {
            parser.main(); // Note: this will throw parser error
        }

        System.exit(0); // compiling was successful/no errors encountered
    }
}
