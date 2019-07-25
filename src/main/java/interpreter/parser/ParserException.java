package interpreter.parser;

public class ParserException extends RuntimeException {

    public ParserException(String message) {
        super("Parser Exception: "+ message);
    }
}
