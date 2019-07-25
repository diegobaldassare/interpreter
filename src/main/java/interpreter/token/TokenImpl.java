package interpreter.token;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenImpl token = (TokenImpl) o;
        return tokenType == token.tokenType
                && fromColumn == token.fromColumn
                && toColumn == token.toColumn
                && line == token.line
                && value.equals(token.value);
    }

    @Override
    public String toString() {
        return "TokenImpl{" +
                "tokenType=" + tokenType +
                ", value=" + value +
                ", line=" + line +
                ", fromColumn=" + fromColumn +
                ", toColumn=" + toColumn +
                '}';
    }
}
