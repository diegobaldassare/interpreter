package lexer.state;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public abstract class LexerState {

    private List<LexerTransition> transitions = new ArrayList<>();
    private boolean finalState = false;

    public Token generateToken(LexerAutomaton context) {
        return new TokenImpl(getTokenType(), context.getFromColumn(), context.getToColumn(), context.getLine(), context.getLexeme());
    }

    public LexerState accept(Character c) {
        for (LexerTransition t: transitions) {
            t.accept(c);
        }

    }

    public Token next(LexerAutomaton context) {

        return generateToken(context);
    }

    protected abstract TokenType getTokenType();

    protected abstract TokenType getTokenType();

    public void setTransitions(List<LexerTransition> transitions) {
        this.transitions = transitions;
    }

    public void setFinalState(boolean finalState) {
        this.finalState = finalState;
    }
}
