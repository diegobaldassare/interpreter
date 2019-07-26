package interpreter.parser.rule;

import interpreter.node.ASTNode;
import interpreter.node.ExpressionNode;
import interpreter.parser.rule.handler.AdditionRule;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public abstract class ExpressionRule extends AbstractRule {

    public static ExpressionNode generateExpression(List<Token> statement) {
        AdditionRule additionRule = new AdditionRule();
        return additionRule.handle(statement);
    }

    protected abstract ExpressionRule next();

    public abstract ExpressionNode handle(List<Token> statement);

    @Override
    public boolean matches(List<Token> statement) {
        return oddAmount(statement) &&
                doesNotContain(statement, TokenType.LET) &&
                doesNotContain(statement, TokenType.COLON) &&
                doesNotContain(statement, TokenType.NUMBER_TYPE) &&
                doesNotContain(statement, TokenType.STRING_TYPE) &&
                doesNotContain(statement, TokenType.EQUALS) &&
                doesNotContain(statement, TokenType.PRINT);
    }

    // This method should not be used
    @Override
    public ASTNode generateASTNode(List<Token> statement) {
        return generateExpression(statement);
    }
}
