package interpreter.parser.rules;

import interpreter.ast.ASTNode;
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
    public ASTNode generateAST() {
        return null;
    }
}
