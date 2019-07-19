package lexer.state;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;

abstract class LexerState {

    abstract boolean accepts(Character c);

    abstract boolean isValidToken(LexerAutomaton context);

    abstract LexerState next();

    abstract TokenType getTokenType(LexerAutomaton context);

    Token generateToken(LexerAutomaton context) {
        return new TokenImpl(getTokenType(context), context.getFromColumn(), context.getToColumn(), context.getLine(), context.getLexeme());
    }

    static LexerState getFirstState() {
        return new SpaceState();
    }
}
