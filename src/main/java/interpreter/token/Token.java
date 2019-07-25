package interpreter.token;

public interface Token {

    public TokenType tokenType();
    public String value();

    public int line();
    public int fromColumn();
    public int toColumn();

    public boolean equals(Object o);
}
