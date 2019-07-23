package lexer.state;

import lexer.Lexer;
import lexer.token.Token;

import java.util.ArrayList;
import java.util.List;

public class LexerAutomaton implements Lexer {

    private static final Character ESCAPE_CHARACTER = '$';
    private LexerState current;
    private String lexeme;
    private int line = 0;
    private int fromColumn;
    private int toColumn;
    private List<Token> output = new ArrayList<>();
    private Character c;
    private int i;

    @Override
    public List<Token> lex(String input) {
        current = LexerState.getFirstState();
        lexeme = "";
        i = 0;
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

            if (current.isValidToken(this)) {
                output.add(current.generateToken(this));
                lexeme = "";
            }

            current = current.next();
        }
        return output;
    }

    void setState(LexerState state) {
        current = state;
    }

    public int getLine() {
        return line;
    }

    void setLine(int line) {
        this.line = line;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    void setFromColumn(int fromColumn) {
        this.fromColumn = fromColumn;
    }

    public int getToColumn() {
        return toColumn;
    }

    void setToColumn(int toColumn) {
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

    void setOutput(List<Token> output) {
        this.output = output;
    }

    int getI() {
        return i;
    }

    void setI(int i) {
        this.i = i;
    }

    Character getCurrentCharacter() {
        if (lexeme.isEmpty()) return ESCAPE_CHARACTER;
        return lexeme.charAt(lexeme.length() - 1);
    }
}
