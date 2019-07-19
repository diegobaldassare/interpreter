package lexer.state;

import lexer.Lexer;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

public class LexerAutomaton implements Lexer {

    private LexerState current;
    private String lexeme;
    private int line = 0;
    private int fromColumn;
    private int toColumn;
    private List<Token> output = new ArrayList<>();
    private Character c;

    @Override
    public List<Token> lex(String input) {
        current = LexerState.getFirstState();
        lexeme = "";

        int i = 0;
        c = input.charAt(i);
        while (i < input.length()) {
            fromColumn = i;

            // State accepts input
            while (current.accepts(c)) {
                toColumn = i;
                lexeme = lexeme.concat(c.toString());
                i++;
                if (i >= input.length()) break;
                c = input.charAt(i);
            }

            // State does not accept input:

            // 1. Because it is a token
            if (current.isValidToken(this)) {
                output.add(current.generateToken(this));
                lexeme = "";
                i++;
            }

            // 2. Because it is not a token
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
        return lexeme;
    }

    void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    List<Token> getOutput() {
        return output;
    }

    public void setOutput(List<Token> output) {
        this.output = output;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }
}
