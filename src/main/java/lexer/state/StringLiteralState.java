package lexer.state;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;

import static common.Constants.DOUBLE_QUOTE;

class StringLiteralState extends LexerState {

    private boolean openedString;

    @Override
    boolean accepts(Character c) {
        if (c.equals(DOUBLE_QUOTE)) {
            if (openedString) return false;
            openedString = true;
            return true;
        }
        return openedString;
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return openedString && context.getCurrentCharacter() == DOUBLE_QUOTE;
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
        System.out.println(context.getLexeme());
        return new TokenImpl(getTokenType(context), context.getFromColumn(), context.getToColumn() + 1, context.getLine(),
                context.getLexeme().substring(1, context.getLexeme().length() - 1));
    }
}
