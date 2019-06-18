package lexer.state;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public abstract class LexerState implements State {

    State next;

    @Override
    public State next() {
        return next;
    }

    @Override
    public void handle(Context context) {
        //do something with context

        //else next ?

    }

    public Token getToken(Context c) {
        return new TokenImpl(getTokenType(), c.getFromColumn(), c.getToColumn(), c.getLine(), c.getLexeme());
    }

    public abstract TokenType getTokenType();
}
