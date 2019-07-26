package interpreter.parser.rule.handler;

import interpreter.node.ExpressionNode;
import interpreter.node.operation.SubtractionNode;
import interpreter.parser.ParserException;
import interpreter.parser.rule.ExpressionRule;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class SubtractionRule extends ExpressionRule {

    @Override
    public ExpressionRule next() {
        return new MultiplicationRule();
    }

    @Override
    public ExpressionNode handle(List<Token> statement) {
        if (!matches(statement)) return next().handle(statement);

        for (Token t : statement) {
            if (t.tokenType().equals(TokenType.SLASH)) {
                int i = statement.indexOf(t);
                return new SubtractionNode(
                        t.line(),
                        t.fromColumn(),
                        t.toColumn(),
                        ExpressionRule.generateExpression(statement.subList(0, i)),
                        ExpressionRule.generateExpression(statement.subList(i + 1, statement.size())));
            }
        }
        Token t = statement.get(0);
        throw new ParserException("inconsistent subtraction at line " + t.line() + ", between column " +
                t.fromColumn() + " and " + t.toColumn() + ".");
    }

    @Override
    public boolean matches(List<Token> statement) {
        return contains(statement, TokenType.SLASH);
    }
}
