import org.antlr.v4.runtime.*;

public class LexicalErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError( Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                                String msg, RecognitionException e ) {
        System.out.println("Token recognition error.");
        System.exit(2); // Lexical Error Found, e.g., invalid token (TODO anything more to account for?)
    }
}