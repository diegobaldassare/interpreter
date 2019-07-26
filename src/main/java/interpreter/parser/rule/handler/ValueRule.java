package interpreter.parser.rule.handler;

import interpreter.node.ExpressionNode;
import interpreter.node.IdentifierNode;
import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
import interpreter.parser.ParserException;
import interpreter.parser.rule.ExpressionRule;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class ValueRule extends ExpressionRule {

    @Override
    protected ExpressionRule next() {
        throw new ParserException("inconsistent value");
    }

    @Override
    public ExpressionNode handle(List<Token> statement) {
        Token t = statement.get(0);

        if (t.tokenType().equals(TokenType.STRING_LITERAL))
            return new StringValue(t.line(), t.fromColumn(), t.toColumn(), t.value());

        if (t.tokenType().equals(TokenType.NUMBER_LITERAL))
            return new NumberValue(t.line(), t.fromColumn(), t.toColumn(), Integer.valueOf(t.value()));

        if (t.tokenType().equals(TokenType.IDENTIFIER))
            return new IdentifierNode(t.line(), t.fromColumn(), t.toColumn(), t.value());

        throw new ParserException("inconsistent value at line " + t.line() + ", between column " +
                t.fromColumn() + " and " + t.toColumn() + ".");
    }

    @Override
    public boolean matches(List<Token> statement) {
        return statement.size() == 1;
    }
}
