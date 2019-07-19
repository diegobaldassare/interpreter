package lexer.state;

import lexer.Lexer;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LexerAutomaton implements Lexer {

    private LexerState current;
    private List<Character> lexeme;
    private int line = 0;
    private int fromColumn;
    private int toColumn;
    private List<Token> output = new ArrayList<>();

    @Override
    public List<Token> lex(String input) {
        current = LexerState.getFirstState();
        lexeme = new ArrayList<>();

        int i = 0;
        Character c = input.charAt(i);
        while (i < input.length()) {
            fromColumn = i;
            while (current.accepts(c)) {
                lexeme.add(c);
                c = input.charAt(i);
                i++;
                toColumn = i;
            }
            if (current.isValidToken(this)) {
                output.add(current.generateToken(this));
                lexeme = new ArrayList<>();
            }
            else
                current = current.next();
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

    String getLexeme() {
        return lexeme.toString();
    }

    void setLexeme(List<Character> lexeme) {
        this.lexeme = lexeme;
    }

    public List<Token> getOutput() {
        return output;
    }

    public void setOutput(List<Token> output) {
        this.output = output;
    }
}
