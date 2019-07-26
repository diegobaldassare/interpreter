package interpreter.parser.rule;

import interpreter.node.ASTNode;
import interpreter.node.PrintNode;
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
    public ASTNode generateASTNode(List<Token> statement) {
        return new PrintNode(
                statement.get(0).line(),
                statement.get(0).fromColumn(),
                statement.get(0).toColumn(),
                ExpressionRule.generateExpression(statement.subList(2, statement.size() - 1)));
    }
}
