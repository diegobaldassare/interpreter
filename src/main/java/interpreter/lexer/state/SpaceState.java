package interpreter.lexer.state;

import interpreter.token.TokenType;

import static common.Constants.SPACE;

class SpaceState extends LexerState {

    @Override
    boolean accepts(Character c) {
        return c.equals(SPACE);
    }

    @Override
    boolean isValidToken(LexerAutomaton context) {
        return context.getCurrentCharacter() == SPACE;
    }

    @Override
    LexerState next() {
        return SymbolState.getInstance();
    }

    @Override
    TokenType getTokenType(LexerAutomaton context) {
        // removes previous Space Token so that it returns only one Space Token
        if (!context.getOutput().isEmpty())
            if (context.getOutput().get(context.getOutput().size() - 1).tokenType().equals(TokenType.SPACE))
                context.getOutput().remove(context.getOutput().size());
        return TokenType.SPACE;
    }
}
