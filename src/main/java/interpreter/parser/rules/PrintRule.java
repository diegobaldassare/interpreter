package interpreter.parser.rules;

import interpreter.node.ASTNode;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class PrintRule extends AbstractRule {

    @Override
    public boolean matches(List<Token> statement) {
        return startsWith(statement, TokenType.PRINT) &&
                secondIs(statement, TokenType.LEFT_PARENTHESIS) &&
                endsWith(statement, TokenType.RIGHT_PARENTHESIS) &&
                sizeBiggerOrEqualThan(statement, 3);
    }

    @Override
    public ASTNode generateAST() {
        return null;
    }
}
