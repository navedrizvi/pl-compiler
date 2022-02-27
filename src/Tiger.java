import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Tiger {
    private static boolean srcFileExists(String fpath) {
        File f = new File(fpath);
        return f.exists();
    }

    private static void writeFileWithContent(String fpath, String content) {
        // File destination = new File(fpath);
        Path targetPath = Paths.get(fpath);
        try {
            Files.write(targetPath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error in creating new file"); 
            // minor TODO what error to return here, or silently exit?
        }
    }

    private static TigerLexer getLexer(String fileName) {
        /* Req 4: When the -l flag is provided, write the stream of tokens to a file. The output file should have the same name and path as the input file with the extension changed to .tokens. Output one tuple per line using the syntax <token type, "token value">.
            ref: https://stackoverflow.com/a/49981691
        */
        try {
            LexicalErrorListener errorListener = new LexicalErrorListener();
            CharStream input = CharStreams.fromFileName(fileName);
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
            if (token.getType() == Token.EOF)
                break;
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
            if (token.getType() == Token.EOF)
                break;
            String tokenTupleStr = "<" + TigerLexer.VOCABULARY.getSymbolicName(token.getType()) + "," + " \"" + token.getText() + "\">\n";
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

    private static String getSTAsFormattedString(List<SymbolTable> stAsList) {
        StringBuilder buf = new StringBuilder();
        int scope = 1;
//        buf.append("Scope " + scope + ":\n");
        for (SymbolTable st: stAsList) {
            //System.out.println(st.getLevel() + " " + st.getST());
            String tabs = "";
            String scopeTabs = "";
            for (int i = 0; i < st.getLevel() + 1; i++) {
                tabs += "\t";
            }
            for (int i = 0; i < st.getLevel(); i++) {
                scopeTabs += "\t";
            }

            buf.append(scopeTabs + "Scope " + scope + " - " + st.getScope() + ":\n");
            for (Map.Entry<String, Symbol> entry : st.getST().entrySet()) {
                Symbol symbol = entry.getValue();
                buf.append(tabs + symbol.toFormattedString() + "\n");
            }
            scope++;
        }

        return buf.toString();
    }

    private static void writeSTToFile(String fileName, String st) {
        String outputFile = fileName.replace(".tiger", ".st");
        writeFileWithContent(outputFile, st);
    }

    private static void writeIRToFile(String fileName, String ir) {
        String outputFile = fileName.replace(".tiger", ".ir");
        writeFileWithContent(outputFile, ir);
    }

    private static int getIFlagIdx(String[] args) {
        /* Returns -1 if there are more that one or none "-i" in @args, if there is just 1 "-i" in args, returns its index */
        int n = 0;
        int i = 0;
        for (String arg: args) {
            if (arg.equals("-i")) {
                n+=1;
            }
        }
        for (; i < args.length; i++) {
            if (args[i].equals("-i")) {
                break;
            }
        }
        if (n == 1) { // we've verified -i exists only once
            return i;
        }
        else if (n==0) { // -i is not provided
            return -1;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // Validate args length
        if (!(args.length >= 2)) {
            System.out.println("Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)");
            System.exit(1); // Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)
        }
        else if (args.length > 4) {
            System.out.println("Error in program arguments: additional args provided (only '-l', '-p', '-i <path/to/source>' are supported)");
            System.exit(1); // Error in program arguments
        }

        /* Ensure args are valid */
        boolean lFlagProvided = false; // if provided, write a `<source_fname>.tokens` file with tokens per Req. 4
        boolean pFlagProvided = false; // if provided, write a `<source_fname>.tree.gv` file with parse tree in GraphViz DOT format per Req. 6
        boolean stFlagProvided = false;
        boolean irFlagProvided = false;

        // assert -i and filename provided somewhere //
        String fileName = "";
        if (!Arrays.asList(args).contains("-i")) {
            System.out.println("Error in program arguments: necessary arg -i not provided");
            System.exit(1); // Error in program arguments: necessary arg not provided.
        }

        int iIdx = getIFlagIdx(args);
        if (iIdx == -1) {
            System.out.println("Error in program arguments: -i must be specified only once");
            System.exit(1); // Error in program arguments: duplicate "-i"
        }
        else {
            // validate filename
            int fileNameIdx = iIdx + 1;
            if (!args[fileNameIdx].endsWith(".tiger")) {
                System.out.println("Error in program arguments: file doesn't end with '.tiger'");
                System.exit(1); // Error in program arguments: file doesn't end with '.tiger'
            }
            else if (!srcFileExists(args[fileNameIdx])) {
                System.out.println("Error in program arguments: source file not found");
                System.exit(1); // Error in program arguments: source file not found
            }
            else {
                fileName = args[fileNameIdx];
            }
        }

        // validate optional flags //
        for (int i=0; i < args.length; i++) {
            if (args[i].equals(("-i"))) {
                // assuming thing after -i is filename; validation is done above
                i += 1;
            }
            else if (args[i].equals("-l"))
                lFlagProvided = true;
            else if (args[i].equals("-p"))
                pFlagProvided = true;
            else if (args[i].equals("--st"))
                stFlagProvided = true;
            else if (args[i].equals("--ir"))
                irFlagProvided = true;
            else {
                System.out.println("Error in program arguments: unknown argument " + args[i]);
                System.exit(1); // Error in program arguments: unknown argument
            }
        }

        TigerLexer lexer = getLexer(fileName);

        // Write tokens to file
        if (lFlagProvided)
            writeTokenFile(lexer, fileName); // also checks for scanner errors

        // Run parser and write parse tree as graph in DOT format
        else if (pFlagProvided) {
            checkScannerErrors(lexer); // checks for scanner errors
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TigerParser parser = getTigerParser(tokens);
            ParseTree tree = parser.main(); // Note: this will throw parser error
            String parseTreeAsGraph = parseTreeToGraph(parser, lexer, tree);
            writeGraphToFile(fileName, parseTreeAsGraph);
        }
        // Generate ST and write to .st file
        else if (stFlagProvided) {
            checkScannerErrors(lexer); // checks for scanner errors
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TigerParser parser = getTigerParser(tokens);
            ParseTree tree = parser.main(); // Note: this will throw parser error
            ParseTreeWalker walker = new ParseTreeWalker();

            // ST generation
            TigerSTListener tigerSTListener = new TigerSTListener();
            walker.walk(tigerSTListener, tree);
            List<SemanticError> errors = tigerSTListener.getErrors();
            if (errors.size() > 0) {
                System.err.println("Semantic errors found:");
                for (SemanticError error : errors) {
                    System.err.println(error);
                }
                System.exit(4);
            }
            List<SymbolTable> stAsList = tigerSTListener.getSTAsList();
            String stAsFormattedString = getSTAsFormattedString(stAsList);
            // Remove when done
            System.out.println(stAsFormattedString);
            writeSTToFile(fileName, stAsFormattedString);
        }
        // Run semantic checks. If no failures, generate IR for provided tiger file
        // and write to .ir file.
        else if (irFlagProvided) {
            checkScannerErrors(lexer); // checks for scanner errors
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TigerParser parser = getTigerParser(tokens);
            ParseTree tree = parser.main(); // Note: this will throw parser error
            ParseTreeWalker walker = new ParseTreeWalker();

            // ST generation
            TigerSTListener tigerSTListener = new TigerSTListener();
            walker.walk(tigerSTListener, tree);
            List<SemanticError> errors = tigerSTListener.getErrors();
            if (errors.size() > 0) {
                System.err.println("Semantic errors found:");
                for (SemanticError error : errors) {
                    System.err.println(error);
                }
                System.exit(4);
            }
            List<SymbolTable> stAsList = tigerSTListener.getSTAsList();
            // Remove when done
            //System.out.println(getSTAsFormattedString(stAsList));

            // Semantic analysis
            TigerSemanticAnalysisListener tigerSemanticAnalysisListener = new TigerSemanticAnalysisListener(stAsList);
            walker.walk(tigerSemanticAnalysisListener, tree);
            errors = tigerSemanticAnalysisListener.getErrors();
            if (errors.size() > 0) {
                System.err.println("Semantic errors found:");
                for (SemanticError error : errors) {
                    System.err.println(error);
                }
                System.exit(4);
            }

            // IR generation
            TigerIRListener tigerIRListener = new TigerIRListener(stAsList);
            walker.walk(tigerIRListener, tree);
            System.out.println(IR.toFormattedString());
            writeIRToFile(fileName, IR.toFormattedString());
        }
        else {
            System.out.println("No action required.");
        }

        System.exit(0); // compiling was successful/no errors encountered
    }
}
