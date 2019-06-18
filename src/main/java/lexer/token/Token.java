package lexer.token;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Token {

    TokenType getTokenType();
    String getValue();

    int getFromColumn();
    int getToColumn();
    int getLine();
}
