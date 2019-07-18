package lexer.state;

import lexer.Lexer;

import java.util.Optional;

/**
 * Created by Diego Baldassare on 2019-06-25.
 */
public class LexerTransition {

    private Character label;
    private LexerState next;

    public LexerTransition(Character label, LexerState next) {
        this.label = label;
        this.next = next;
    }

    public Optional<LexerState> accept(Character c) {
        if (label.equals(c)) return Optional.of(next);
        return Optional.empty();
    }

    public LexerState next() {
        return next;
    }

    public Character getLabel() {
        return label;
    }

    public void setLabel(Character label) {
        this.label = label;
    }

    public LexerState getNext() {
        return next;
    }

    public void setNext(LexerState next) {
        this.next = next;
    }
}
