package interpreter.interpreter;

public class InterpreterException extends RuntimeException {

    public InterpreterException(String message) {
        super("Interpreter Exception: " + message);
    }
}