package lexer.state;

import lexer.token.TokenType;

import static common.Constants.ALPHANUMERIC;

class IdentifierState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return ALPHANUMERIC.contains(c.toString());
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return true;
    }

    @Override
    LexerState next() {
        return new NumberLiteralState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return TokenType.IDENTIFIER;
    }
}
