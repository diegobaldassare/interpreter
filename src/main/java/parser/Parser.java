package parser;

import lexer.token.Token;
import parser.ast.ASTNode;

import java.util.List;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Parser {

    /**
     * Creates an ASTNode with all the tokens.
     * @param tokens
     * @return
     */
    public ASTNode parse(List<Token> tokens);
}
