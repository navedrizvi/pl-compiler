import org.antlr.v4.runtime.*;

public class LexicalErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        System.out.println("Scanner error: " + msg + " at line " + String.valueOf(line) + " and position " + String.valueOf(charPositionInLine));
        System.exit(2);
    }
}
