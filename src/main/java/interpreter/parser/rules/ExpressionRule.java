package interpreter.parser.rules;

import interpreter.ast.ASTNode;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class ExpressionRule extends AbstractRule {

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

    @Override
    public ASTNode generateAST() {
        return null;
    }
}
