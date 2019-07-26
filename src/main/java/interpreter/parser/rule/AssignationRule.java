package interpreter.parser.rule;

import interpreter.node.ASTNode;
import interpreter.node.AssignationNode;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class AssignationRule extends AbstractRule {

    @Override
    public boolean matches(List<Token> statement) {
        return startsWith(statement, TokenType.IDENTIFIER) &&
                secondIs(statement, TokenType.EQUALS) &&
                doesNotContain(statement, TokenType.LET) &&
                doesNotContain(statement, TokenType.PRINT) &&
                doesNotContain(statement, TokenType.COLON) &&
                doesNotContain(statement, TokenType.STRING_TYPE) &&
                doesNotContain(statement, TokenType.NUMBER_TYPE) &&
                sizeBiggerOrEqualThan(statement, 3);
    }

    @Override
    public ASTNode generateASTNode(List<Token> statement) {
        return new AssignationNode(
                statement.get(0).line(),
                statement.get(0).fromColumn(),
                statement.get(0).toColumn(),
                statement.get(0).value(),
                ExpressionRule.generateExpression(statement.subList(2, statement.size())));
    }
}
