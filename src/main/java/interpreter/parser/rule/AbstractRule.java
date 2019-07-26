package interpreter.parser.rule;

import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

public abstract class AbstractRule implements Rule {

    protected boolean startsWith(List<Token> statement, TokenType tokenType) {
        return statement.get(0).tokenType().equals(tokenType);
    }

    protected boolean secondIs(List<Token> statement, TokenType tokenType) {
        return statement.get(1).tokenType().equals(tokenType);
    }

    protected boolean thirdIs(List<Token> statement, TokenType tokenType) {
        return statement.get(2).tokenType().equals(tokenType);
    }

    protected boolean contains(List<Token> statement, TokenType tokenType) {
        return statement.stream().anyMatch(st -> st.tokenType().equals(tokenType));
    }

    protected boolean containsTypes(List<Token> statement) {
        return statement.stream().anyMatch(st -> st.tokenType().equals(TokenType.STRING_TYPE) || st.tokenType().equals(TokenType.NUMBER_TYPE));
    }

    protected boolean doesNotContain(List<Token> statement, TokenType tokenType) {
        return statement.stream().noneMatch(st -> st.tokenType().equals(tokenType));
    }

    protected boolean endsWith(List<Token> statement, TokenType tokenType) {
        return statement.get(statement.size() - 1).tokenType().equals(tokenType);
    }

    protected boolean sizeBiggerOrEqualThan(List<Token> statement, int size) {
        return statement.size() >= size;
    }

    protected boolean sizeEquals(List<Token> statement, int size) {
        return statement.size() == size;
    }

    protected boolean oddAmount(List<Token> tokenTypes) {
        return tokenTypes.size() % 2 == 1;
    }
}
