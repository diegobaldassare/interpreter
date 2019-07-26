package interpreter.parser.rule;

import interpreter.node.ASTNode;
import interpreter.node.DeclarationAndAssignationNode;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class DeclarationAndAssignationRule extends AbstractRule {

    @Override
    public boolean matches(List<Token> statement) {
        return startsWith(statement, TokenType.LET) &&
                secondIs(statement, TokenType.IDENTIFIER) &&
                thirdIs(statement, TokenType.COLON) &&
                containsTypes(statement) &&
                contains(statement, TokenType.EQUALS) &&
                doesNotContain(statement, TokenType.PRINT) &&
                sizeBiggerOrEqualThan(statement, 6);
    }

    @Override
    public ASTNode generateASTNode(List<Token> statement) {
        return new DeclarationAndAssignationNode(
                statement.get(0).line(),
                statement.get(0).fromColumn(),
                statement.get(0).toColumn(),
                statement.get(3).value(),
                statement.get(1).value(),
                ExpressionRule.generateExpression(statement.subList(5, statement.size())));
    }
}
