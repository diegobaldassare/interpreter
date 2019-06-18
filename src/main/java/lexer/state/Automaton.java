package lexer.state;

import lexer.Lexer;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public class Automaton implements Context {

    private State current;
    private String lexeme;
    private int line;
    private int fromColumn;
    private int toColumn;

    /**
     * Request
     * @param c character that is being read
     */
    @Override
    public void next(Character c) {
//        current.next(this);
    }

    @Override
    public void setState(State state) {
        this.current = state;
    }

    @Override
    public State getState() {
        return current;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getFromColumn() {
        return fromColumn;
    }

    @Override
    public int getToColumn() {
        return toColumn;
    }
}
