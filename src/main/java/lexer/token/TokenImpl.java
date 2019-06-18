package lexer.token;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public class TokenImpl implements Token {

    private final TokenType tokenType;
    private final int fromColumn;
    private final int toColumn;
    private final int line;
    private final String value;

    public TokenImpl(TokenType tokenType, int fromColumn, int toColumn, int line, String value) {
        this.tokenType = tokenType;
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.line = line;
        this.value = value;
    }

    @Override
    public TokenType getTokenType() {
        return tokenType;
    }

    @Override
    public int getFromColumn() {
        return fromColumn;
    }

    @Override
    public int getToColumn() {
        return toColumn;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public String getValue() {
        return value;
    }
}
