package lexer.state;

import lexer.token.TokenType;

import static common.Constants.NUMBER;
import static common.Constants.NUMBERS;

class NumberLiteralState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return c.toString().matches(NUMBER);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return context.getCurrentCharacter().toString().matches(NUMBERS);
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
