package interpreter.lexer.state;

import interpreter.lexer.Lexer;
import interpreter.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the "context" of the State Pattern.
 * It has all the information corresponding to the input
 * while reading it, with its corresponding getters and setters,
 * so that each state can respond according to the context.
 */
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
    private int pastLines;
    private int lineStart;
    private int stringLiterals;
    private String input;


    @Override
    public List<Token> lex(String input) {
        current = LexerState.getFirstState();
        lexeme = "";
        this.input = input;

        i = 0;
        c = input.charAt(i);

        while (i < input.length()) {

            // State accepts input
            while (current.accepts(c)) {
                toColumn = i - pastLines - stringLiterals * 2;
                lexeme = lexeme.concat(c.toString());
                i++;
                if (i >= input.length()) break;
                c = input.charAt(i);
            }

            if (current.isValidToken(this)) {
                output.add(current.generateToken(this));
                lexeme = "";
                fromColumn = i - pastLines - stringLiterals * 2;
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

    Character getC() {
        return c;
    }

    int getPastLines() {
        return pastLines;
    }

    void setPastLines(int pastLines) {
        this.pastLines = pastLines;
    }

    int getLineStart() {
        return lineStart;
    }

    void setLineStart(int lineStart) {
        this.lineStart = lineStart;
    }

    void setC(Character c) {
        this.c = c;
    }

    String getInput() {
        return input;
    }

    void setStringLiterals(int stringLiterals) {
        this.stringLiterals = stringLiterals;
    }

    int getStringLiterals() {
        return stringLiterals;
    }
}
