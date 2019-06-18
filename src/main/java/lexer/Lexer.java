package lexer;

import lexer.token.Token;

import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Lexer {

    /**
     * Reads all the code statements and returns them converted into an interpretable Token.
     * @param statements
     * @return
     */
    public List<Token> lex(String statements);
}
