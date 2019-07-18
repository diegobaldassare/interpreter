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
    public TokenType tokenType() {
        return tokenType;
    }

    @Override
    public int fromColumn() {
        return fromColumn;
    }

    @Override
    public int toColumn() {
        return toColumn;
    }

    @Override
    public int line() {
        return line;
    }

    @Override
    public String value() {
        return value;
    }
}
