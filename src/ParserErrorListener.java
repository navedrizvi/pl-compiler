import org.antlr.v4.runtime.*;

public class ParserErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                             String msg, RecognitionException e) {
        System.out.println("Parser Error: "); // TODO should append error message?
        System.exit(3); // Parsing Error Found, e.g., invalid sentence 
    }
}
