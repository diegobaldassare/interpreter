package lexer.state;

import lexer.token.TokenType;

import static common.Constants.NUMBERS;

class NumberLiteralState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return NUMBERS.contains(c.toString());
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return true;
    }

    @Override
    LexerState next() {
        return KeywordsState.getInstance();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return TokenType.NUMBER_LITERAL;
    }
}
