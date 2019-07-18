package lexer;

import lexer.state.LexerAutomaton;

public class LexerException extends RuntimeException {

    public LexerException(LexerAutomaton context) {
        super("Lexer exception in line " + context.getLine() +
                ", between column " + context.getFromColumn() + " and " + context.getToColumn() + ".");
    }
}