import java.util.Arrays;
import java.io.File;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// write initial CLI parser
// write initial part of error parsing

public class Tiger {

    private static boolean srcFileExists(String fpath) {
        File f = new File(fpath);
        return f.exists();
    }

    public static void main(String[] args) throws Exception {
        if (!(args.length >= 2)) {
            System.exit(1); // Error in program arguments: must have 2 args atleast (-i and <path/to/source> are necessary)
        }

        /* Ensure args are valid */
        // minor TODO confirm do we need to support input stream, or only file?
        String[] validArgFlags = new String[] {"-i", "-l", "-p"};

        for (int i=0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                // if -i arg, check the next arg is presumably the source tiger file
                // TODO do we need to throw Error code if src file doesnt end with `.tiger`?
                if (!srcFileExists(args[i+1])) {
                    System.exit(1); // Error in program arguments: file not found
                }
                // next arg is valid so skip checking it
                i += 1;
            }
            else {
                if (!Arrays.asList(validArgFlags).contains(args[i])) {
                    System.exit(1); // Error in program arguments: unknown argument
                }
            }
        }

        System.exit(0); // compiling was successful/no errors encountered
    }
}
