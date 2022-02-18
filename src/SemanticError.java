public class SemanticError {
    private int lineNumber;
    private int columnNumber;
    private String description;

    public SemanticError(int lineNumber, int columnNumber, String description) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.description = description;
    }

    public String toString() {
        return "line " + lineNumber + ":" + ((columnNumber == 0) ? "" : columnNumber) + " " + description;
    }
}
