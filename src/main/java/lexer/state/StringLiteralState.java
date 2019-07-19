package lexer.state;

import lexer.token.TokenType;

import static common.Constants.DOUBLE_QUOTE;

class StringLiteralState extends LexerState {

    private boolean openedString;

    @Override
    boolean accepts(Character c) {
        if (openedString) {
//            if (c.equals(DOUBLE_QUOTE)) openedString = false;
            return true;
        }
        else if (c.equals(DOUBLE_QUOTE)) openedString = true;
        return false;
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return openedString && context.getLexeme().charAt(context.getLexeme().length() - 1) == DOUBLE_QUOTE;
    }

    @Override
    LexerState next() {
        return new IdentifierState();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        return TokenType.STRING_LITERAL;
    }
}
