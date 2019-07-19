package lexer.state;

import lexer.token.TokenType;

import static common.Constants.NUMBER;

class NumberLiteralState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return c.toString().matches(NUMBER);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return context.getC().toString().matches(NUMBER);
    }

    @Override
    LexerState next() {
        return AlphanumericState.getInstance();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return TokenType.NUMBER_LITERAL;
    }
}
