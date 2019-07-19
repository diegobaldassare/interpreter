package lexer.state;

import lexer.token.TokenType;

public class LexerTransition {

    private Character label;
    private LexerState next;
    private boolean endToken; //determines the end of the token
    private TokenType tokenType;

    public LexerTransition(Character label, LexerState next, boolean endToken) {
        this.label = label;
        this.next = next;
    }

    boolean accepts(Character c) {
         return label.equals(c);
    }

    /**
     * If it is the end of the token it
     * means that a valid token was formed.
     */
    boolean isValidToken() {
        return endToken;
    }

    LexerState next() {
        return next;
    }

    TokenType getTokenType() {
        return tokenType;
    }

    Character getLabel() {
        return label;
    }

    void setLabel(Character label) {
        this.label = label;
    }

    LexerState getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }

    void setNext(LexerState next) {
        this.next = next;
    }

    void setEndToken(boolean endToken) {
        this.endToken = endToken;
    }

    void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }
}
