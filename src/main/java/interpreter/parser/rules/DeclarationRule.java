package interpreter.parser.rules;

import interpreter.node.ASTNode;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public class DeclarationRule extends AbstractRule {

    @Override
    public boolean matches(List<Token> statement) {
        return startsWith(statement, TokenType.LET) &&
                secondIs(statement, TokenType.IDENTIFIER) &&
                thirdIs(statement, TokenType.COLON) &&
                containsTypes(statement) &&
                sizeEquals(statement, 4);
    }

    @Override
    public ASTNode generateAST() {
        return null;
    }
}
