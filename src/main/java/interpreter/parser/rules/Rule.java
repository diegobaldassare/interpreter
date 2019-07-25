package interpreter.parser.rules;

import interpreter.node.ASTNode;
import interpreter.token.Token;

import java.util.List;

public interface Rule {

    boolean matches(List<Token> statement);
    ASTNode generateAST();
}
