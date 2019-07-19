package lexer.state;

import lexer.token.TokenType;

import static common.Constants.SPACE;

class SpaceState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return c.equals(SPACE);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return context.getC() == SPACE;
    }

    @Override
    LexerState next() {
        return SymbolState.getInstance();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        if (context.getOutput().get(context.getOutput().size()).tokenType().equals(TokenType.SPACE))
            context.getOutput().remove(context.getOutput().size());
        return TokenType.SPACE;
    }
}
