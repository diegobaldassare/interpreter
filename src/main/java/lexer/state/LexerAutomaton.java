package lexer.state;

import lexer.Lexer;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public class LexerAutomaton implements Lexer {

    private LexerState current;
    private List<Character> lexeme;
    private int line;
    private int fromColumn;
    private int toColumn;

    @Override
    public List<Token> lex(String input) {
        List<Token> output = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            while (current.accept(c)) {
                lexeme.add(c);
            }
            output.add(current.next(this));
        }
        return output;
    }

    public void setState(LexerState state) {
        current = state;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public void setFromColumn(int fromColumn) {
        this.fromColumn = fromColumn;
    }

    public int getToColumn() {
        return toColumn;
    }

    public void setToColumn(int toColumn) {
        this.toColumn = toColumn;
    }

    public String getLexeme() {
        return lexeme.toString();
    }
}
