package interpreter.lexer.state;

import interpreter.token.Token;
import interpreter.token.TokenImpl;
import interpreter.token.TokenType;

import static common.Constants.DOUBLE_QUOTE;

class StringLiteralState extends LexerState {

    private boolean openedString;

    @Override
    boolean accepts(Character c) {
        if (c.equals(DOUBLE_QUOTE)) {
            if (openedString) return false;
            openedString = true;
        }
        return openedString;
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return openedString && context.getC() == DOUBLE_QUOTE;
    }

    @Override
    LexerState next() {
        return new NumberLiteralState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return TokenType.STRING_LITERAL;
    }

    @Override
    Token generateToken(LexerAutomaton context) {
        openedString = false;
        context.setStringLiterals(context.getStringLiterals() + 1);
        context.setI(context.getI() + 1);
        if (context.getI() < context.getInput().length()) context.setC(context.getInput().charAt(context.getI()));
        return new TokenImpl(getTokenType(context), context.getFromColumn(), context.getToColumn() - 1,
                context.getLine(), context.getLexeme().substring(1));
    }
}
