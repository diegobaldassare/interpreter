package lexer.state;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;

import java.util.ArrayList;
import java.util.List;

abstract class LexerState {

    private List<LexerTransition> transitions = new ArrayList<>();

    LexerState() {
    }

    public LexerState(LexerTransition transition) {
        this.transitions.add(transition);
    }

    abstract boolean accepts(Character c);

    abstract boolean isValidToken(LexerAutomaton context);

    abstract LexerState next();

    abstract TokenType getTokenType(LexerAutomaton context);

    Token generateToken(LexerAutomaton context) {
        return new TokenImpl(getTokenType(context), context.getFromColumn(), context.getToColumn(), context.getLine(), context.getLexeme());
    }

    List<LexerTransition> getTransitions() {
        return transitions;
    }

    void setTransitions(List<LexerTransition> transitions) {
        this.transitions = transitions;
    }

    static LexerState getFirstState() {
        return KeywordsState.getInstance();
    }
}
