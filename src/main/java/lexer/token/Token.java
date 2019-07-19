package lexer.token;

public interface Token {

    TokenType tokenType();
    String value();

    int line();
    int fromColumn();
    int toColumn();

    boolean equals(Object o);
}
