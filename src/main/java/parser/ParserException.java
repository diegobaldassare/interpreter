package parser;

import lexer.state.LexerAutomaton;

public class ParserException extends RuntimeException {

    public ParserException(LexerAutomaton context) {
        super("Parser exception in line " + context.getLine() +
                ", between column " + context.getFromColumn() + " and " + context.getToColumn() + ".");
    }
}