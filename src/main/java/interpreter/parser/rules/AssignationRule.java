package interpreter.parser.rules;

import interpreter.node.ASTNode;
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
    public ASTNode generateAST() {
        return null;
    }
}
