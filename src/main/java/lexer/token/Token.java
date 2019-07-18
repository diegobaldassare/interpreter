package lexer.token;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Token {

    TokenType tokenType();
    String value();

    int line();
    int fromColumn();
    int toColumn();
}
