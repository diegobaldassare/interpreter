package parser;

import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new ParserImpl();
    }

    @Test
    public void testSimpleOperationPrintParse() {
        Token first = new TokenImpl(TokenType.PRINT, 0, 0, 0, "print");
        Token second = new TokenImpl(TokenType.LEFT_PARENTHESIS, 0, 0, 0, "(");
        Token third = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0, "2");
        Token fourth = new TokenImpl(TokenType.PLUS_SYMBOL, 0, 0, 0, "+");
        Token fifth = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0, "2");
        Token sixth = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 0, 0, 0, ")");
        Token seventh = new TokenImpl(TokenType.SEMICOLON, 0, 0, 0, ";");
        List<Token> simplePrint = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh);
        System.out.println(parser.parse(simplePrint).getValue());
    }
}
