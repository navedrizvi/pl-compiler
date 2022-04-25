import codegen.BasicBlock;
import codegen.CFGBuilder;
import codegen.LivenessAnalysis;
import codegen.TargetCodeGenerator;
import common.Symbol;
import common.SymbolTable;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Tiger {
    private static boolean srcFileExists(String fpath) {
        File f = new File(fpath);
        return f.exists();
    }

    private static void writeFileWithContent(String fpath, String content) {
        // Path targetPath = Paths.get(fpath);
        try {
            // Files.write(targetPath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            FileWriter writer = new FileWriter(fpath, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error in creating new file");
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
            System.err.println("Error in program arguments: source file not found");
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
        for (SymbolTable st: stAsList) {
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

    private static void writeMipsToFile(String fileName, String regAllocationStrategy, String mips) {
        // regAllocationStrategy is one of (briggs, ib, or naive) todo make enum
        String outputFile = fileName.replace(".tiger", "." + regAllocationStrategy + ".s");
        writeFileWithContent(outputFile, mips);
    }

    private static void writeCFGToFile(String fileName, String graph) {
        String outputFile = fileName.replace(".tiger", ".cfg.gv");
        writeFileWithContent(outputFile, graph);
    }

    private static void wrtieLivenessAnalysisToFile(String fileName, String livenessAnalysis) {
        String outputFile = fileName.replace(".tiger", ".liveness");
        writeFileWithContent(outputFile, livenessAnalysis);
    }

    private static int getFlagIdx(String flag, String[] args) {
        /* Returns -1 if there are more that one or none @flag in @args, if there is just 1 @flag in @args, returns its index */
        int n = 0;
        int i = 0;
        for (String arg: args) {
            if (arg.equals(flag)) {
                n+=1;
            }
        }
        for (; i < args.length; i++) {
            if (args[i].equals(flag)) {
                break;
            }
        }
        if (n == 1) { // we've verified flag exists only once
            return i;
        }
        else if (n==0) { // flag is not provided
            return -1;
        }
        else {
            return -1;
        }
    }

    private static String getFileName(String[] args, int fileNameIdx, String extension) {
        String fileName = null;
        // validate filename
        if (!args[fileNameIdx].endsWith(extension)) {
            System.err.println("Error in program arguments: file doesn't end with " + extension);
            System.exit(1); // Error in program arguments: file doesn't end with '.tiger'
        }
        else if (!srcFileExists(args[fileNameIdx])) {
            System.err.println("Error in program arguments: source file not found");
            System.exit(1); // Error in program arguments: source file not found
        }
        else {
            fileName = args[fileNameIdx];
        }
        return fileName;
    }

    private static Map<String, LivenessAnalysis> doFullLivenessAnalysis(
            Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG, Map<String, ArrayList<String>> funcNameToFunc,
            Map<String, List<String>> funcNameToIntList, Map<String, List<String>> funcNameToFloatList
    ) {
        Map<String, LivenessAnalysis> funcNameToLivenessAnalysis = new HashMap<>();

        for (Map.Entry<String, Map<BasicBlock, List<BasicBlock>>> entry: funcNameToCFG.entrySet()) {
            String funcName = entry.getKey();
            LivenessAnalysis livenessAnalysis = new LivenessAnalysis(
                    entry.getValue(), funcNameToFunc.get(funcName), funcNameToIntList.get(funcName), funcNameToFloatList.get(funcName)
            );
            livenessAnalysis.execute();
            funcNameToLivenessAnalysis.put(funcName, livenessAnalysis);
        }

        return funcNameToLivenessAnalysis;
    }

    private static String formatLivenessAnalysisOutput(Map<String, LivenessAnalysis> funcNameToLivenessAnaylsis, Map<String, ArrayList<String>> funcNameToFunc) {
        StringBuilder buf = new StringBuilder();

        for(String funcName: funcNameToFunc.keySet()) {
            buf.append(funcName + ":\n");
            LivenessAnalysis livenessAnalysis = funcNameToLivenessAnaylsis.get(funcName);
            for (String instruction: funcNameToFunc.get(funcName)) {
                buf.append("\t" + instruction + "\n");
                buf.append("\t\t" + "in: " + livenessAnalysis.getInSet().get(instruction) + "\n");
                buf.append("\t\t" + "out: " + livenessAnalysis.getOutSet().get(instruction) + "\n");
            }
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        // Validate args length
        if (!(args.length >= 2)) {
            System.err.println("Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)");
            System.exit(1); // Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)
        }
        else if (args.length > 9) {
            System.err.println("Error in program arguments: additional args provided (only '-l', '-p', '-i <path/to/tiger-source>', '-r <path/to/ir-source>', '--ir' are supported)");
            System.exit(1); // Error in program arguments
        }

        /* Ensure args are valid */
        boolean lFlagProvided = false; // if provided, write a `<source_fname>.tokens` file with tokens per Req. 4
        boolean pFlagProvided = false; // if provided, write a `<source_fname>.tree.gv` file with parse tree in GraphViz DOT format per Req. 6
        boolean stFlagProvided = false;
        boolean irFlagProvided = false;
        boolean nFlagProvided = false;
        boolean bFlagProvided = false;
        boolean mipsFlagProvided = false;
        boolean cfgFlagProvided = false;
        boolean gFlagProvided = false;
        boolean livenessFlagProvided = false;
        boolean limitFlagProvided = false;
        // A limit of 0 means limit arg was not given - TODO not sure if this is safe
        int limit = 0;

        // assert -i and filename provided somewhere //
        if (!Arrays.asList(args).contains("-i")) {
            System.err.println("Error in program arguments: necessary arg -i not provided");
            System.exit(1); // Error in program arguments: necessary arg not provided.
        }

        // User tiger if -i flag provided
        int iIdx = getFlagIdx("-i", args);
        // We don't support IR only
        int rIdx = getFlagIdx("-r", args);
        String fileName = null;
        if (iIdx == -1) {
            System.err.println("Error in program arguments: -i must be specified only once");
            System.exit(1); // Error in program arguments: duplicate "-i"
        }
        else {
            fileName = getFileName(args, iIdx + 1, ".tiger");
        }
        int limitIdx = getFlagIdx("--limit", args);
        if (limitIdx!=-1) {
            limit = Integer.parseInt(args[limitIdx+1]);
            limitFlagProvided = true;
            if (limit !=0 && limit<4){
                System.err.println("invalid limit");
            }
        }

        // validate optional flags //
        for (int i=0; i < args.length; i++) {
            if (args[i].equals("-i") || args[i].equals("-r") || args[i].equals("--limit")) {
                // assuming thing after -i or -r is filename, and after --limit is number; validation is done above
                i += 1;
            }
            else if (args[i].equals("-l"))
                lFlagProvided = true;
            else if (args[i].equals("-p"))
                pFlagProvided = true;
            else if (args[i].equals("-n"))
                nFlagProvided = true;
            else if (args[i].equals("-b"))
                bFlagProvided = true;
            else if (args[i].equals("-g"))
                gFlagProvided = true;
            else if (args[i].equals("--st"))
                stFlagProvided = true;
            else if (args[i].equals("--ir"))
                irFlagProvided = true;
            else if (args[i].equals("--mips"))
                mipsFlagProvided = true;
            else if (args[i].equals("--cfg"))
                cfgFlagProvided = true;
            else if (args[i].equals("--liveness"))
                livenessFlagProvided = true;
            else {
                System.err.println("Error in program arguments: unknown argument " + args[i]);
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
        else if (nFlagProvided || irFlagProvided || bFlagProvided || gFlagProvided) {
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
            System.out.println("OUUUU");
            System.out.println(stAsFormattedString);
 

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
//            System.out.println(IR.toFormattedString());
            if (irFlagProvided) {
                writeIRToFile(fileName, IR.toFormattedString());
            }
            TargetCodeGenerator targetCodeGenerator;
            if (limitFlagProvided && limit!=0) {
                targetCodeGenerator = new TargetCodeGenerator(IR.irOutput, IR.staticIntList, IR.staticFloatList, stAsList.get(stAsList.size()-1), limit);
            }
            else {
                targetCodeGenerator = new TargetCodeGenerator(IR.irOutput, IR.staticIntList, IR.staticFloatList, stAsList.get(stAsList.size()-1), 0);
            }
            if (nFlagProvided) {
                String mips = targetCodeGenerator.generateTargetMipsCodeNaiveAlloc();
                if (mipsFlagProvided) {
//                    System.out.println(mips);
                    writeMipsToFile(fileName, "naive", mips);
                }
            }
            else if (bFlagProvided) {
                CFGBuilder cfgBuilder = new CFGBuilder(IR.irOutput);
                cfgBuilder.build();
                Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG = cfgBuilder.getFuncNameToCFG();
                if (cfgFlagProvided) {
                    String graph = cfgBuilder.getGraph().toDOT();
                    writeCFGToFile(fileName, graph);
                }

                if (mipsFlagProvided) {
                    String mips = targetCodeGenerator.generateTargetMipsCodeIntraBlockAlloc(funcNameToCFG);
//                    System.out.println(mips);
                    writeMipsToFile(fileName, "ib", mips);
                }
            }
            else if (gFlagProvided) {
                CFGBuilder cfgBuilder = new CFGBuilder(IR.irOutput);
                Map<String, ArrayList<String>> funcNameToFunc = cfgBuilder.build();
                Map<String, Map<BasicBlock, List<BasicBlock>>> funcNameToCFG = cfgBuilder.getFuncNameToCFG();
                Map<String, LivenessAnalysis> funcNameToLivenessAnaylsis = doFullLivenessAnalysis(funcNameToCFG, funcNameToFunc, cfgBuilder.getFuncNameToIntList(), cfgBuilder.getFuncNameToFloatList());
                if (livenessFlagProvided) {
                    String livenessAnalysis = formatLivenessAnalysisOutput(funcNameToLivenessAnaylsis, funcNameToFunc);
                    wrtieLivenessAnalysisToFile(fileName, livenessAnalysis);
                }

                if (mipsFlagProvided) {
                    String mips = targetCodeGenerator.generateTargetMipsCodeBriggsAlloc(funcNameToLivenessAnaylsis);;
//                    System.out.println(mips);
                    writeMipsToFile(fileName, "briggs", mips);
                }
            }
        }
        else {
            System.out.println("No action required.");
        }

        System.exit(0); // compiling was successful/no errors encountered
    }
}
