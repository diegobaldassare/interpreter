package lexer.state;

import lexer.token.TokenType;

/**
 * Created by Diego Baldassare on 2019-06-25.
 */
public class KeywordState extends LexerState {

    @Override
    protected TokenType getTokenType() {
        return null;
    }

    @Override
    public boolean accept(Character c) {
        return false;
    }
}
