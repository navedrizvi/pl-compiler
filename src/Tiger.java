import java.util.Arrays;
import java.io.File;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Tiger {

    private static boolean srcFileExists(String fpath) {
        File f = new File(fpath);
        return f.exists();
    }

    public static void main(String[] args) throws Exception {
        // TODO should we print descriptive error messages before error exit? we are right now for sake of debugging
        if (!(args.length >= 2)) {
            System.out.println("Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)");
            System.exit(1); // Error in program arguments: must have 2 necessary args (-i and <path/to/source> are necessary)
        }

        /* Ensure args are valid */
        // minor TODO confirm do we need to support input stream, or only file?
        String[] validArgFlags = new String[] {"-l", "-p"};

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
                System.out.println("Error in program arguments: file not found");
                System.exit(1); // Error in program arguments: file not found
            }
        }

        for (int i=0; i < args.length; i++) {
            if (!Arrays.asList(validArgFlags).contains(args[i])) {
                System.out.println("Error in program arguments: unknown argument " + args[i]);
                System.exit(1); // Error in program arguments: unknown argument
            }
        }

        /* Req: When the -l flag is provided, write the stream of tokens to a file. The output file should have the same name and path as the input file with the extension changed to .tokens. Output one tuple per line using the syntax <token type, "token value">.
        */
        CharStream fileStream = CharStreams.fromFileName(fileName);

        System.exit(0); // compiling was successful/no errors encountered
    }
}
