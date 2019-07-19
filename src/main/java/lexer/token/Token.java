package lexer.token;

public interface Token {

    public TokenType tokenType();
    public String value();

    int line();
    int fromColumn();
    int toColumn();

    public boolean equals(Object o);
}
