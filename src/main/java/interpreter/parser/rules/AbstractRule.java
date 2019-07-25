package interpreter.parser.rules;

import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.List;

abstract class AbstractRule implements Rule {

    boolean startsWith(List<Token> statement, TokenType tokenType) {
        return statement.get(0).tokenType().equals(tokenType);
    }

    boolean secondIs(List<Token> statement, TokenType tokenType) {
        return statement.get(1).tokenType().equals(tokenType);
    }

    boolean thirdIs(List<Token> statement, TokenType tokenType) {
        return statement.get(2).tokenType().equals(tokenType);
    }

    boolean contains(List<Token> statement, TokenType tokenType) {
        return statement.stream().anyMatch(st -> st.tokenType().equals(tokenType));
    }

    boolean containsTypes(List<Token> statement) {
        return statement.stream().anyMatch(st -> st.tokenType().equals(TokenType.STRING_TYPE) || st.tokenType().equals(TokenType.NUMBER_TYPE));
    }

    boolean doesNotContain(List<Token> statement, TokenType tokenType) {
        return statement.stream().noneMatch(st -> st.tokenType().equals(tokenType));
    }

    boolean endsWith(List<Token> statement, TokenType tokenType) {
        return statement.get(statement.size() - 1).tokenType().equals(tokenType);
    }

    boolean sizeBiggerOrEqualThan(List<Token> statement, int size) {
        return statement.size() >= size;
    }

    boolean sizeEquals(List<Token> statement, int size) {
        return statement.size() == size;
    }

    boolean oddAmount(List<Token> tokenTypes) {
        return tokenTypes.size() % 2 == 1;
    }
}
