import org.antlr.v4.runtime.*;

public class ParserErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                             String msg, RecognitionException e) {
        System.out.println("Parser error: " + msg + " at line " + String.valueOf(line) + " and position " + String.valueOf(charPositionInLine)); // TODO okay to have (or should this msg. match test files like: "Parser error: invalid name starting with number" */)
        System.exit(3); // Parsing Error Found, e.g., invalid sentence 
    }
}
