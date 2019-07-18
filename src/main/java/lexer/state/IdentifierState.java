package lexer.state;

import lexer.token.TokenType;

/**
 * Created by Diego Baldassare on 2019-06-25.
 */
public class IdentifierState extends LexerState {
    @Override
    protected TokenType getTokenType() {
        return TokenType.IDENTIFIER;
    }

    @Override
    public boolean accept(Character c) {
        return false;
    }
}
