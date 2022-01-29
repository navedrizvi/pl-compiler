import org.antlr.v4.runtime.*;

public class LexicalErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
                                    // invalid symbol $
        System.out.println("Scanner error: " + msg + " at line " + String.valueOf(line) + " and position " + String.valueOf(charPositionInLine)); // TODO okay to have (or should this msg. match test files like: "Scanner error: invalid symbol - ε" */)
        System.exit(2); // Lexical Error Found, e.g., invalid token (TODO anything more to account for?)
    }
}
