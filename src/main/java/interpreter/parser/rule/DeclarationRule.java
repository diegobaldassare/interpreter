package interpreter.parser.rule;

import interpreter.node.ASTNode;
import interpreter.node.DeclarationNode;
import interpreter.node.value.DataType;
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
    public ASTNode generateASTNode(List<Token> statement) {
        return new DeclarationNode(
                statement.get(1).line(),
                statement.get(1).fromColumn(),
                statement.get(1).toColumn(),
                statement.get(3).tokenType().equals(TokenType.STRING_TYPE) ?
                        DataType.STRING_TYPE : DataType.NUMBER_TYPE,
                statement.get(1).value());
    }
}
