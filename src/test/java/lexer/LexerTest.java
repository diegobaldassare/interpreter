package lexer;

import lexer.state.LexerAutomaton;
import lexer.token.Token;
import lexer.token.TokenImpl;
import lexer.token.TokenType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LexerTest {

    private Lexer lexer;

    @Before
    public void setup() {
        lexer = new LexerAutomaton();
    }

    @Test
    public void test001_StringLiteral() {
        Token expected = new TokenImpl(TokenType.STRING_LITERAL, 0, 5,0, "test");
        Token actual = lexer.lex("\"test\"").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test002_NumberLiteral() {
        Token expected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 3, 0,"123");
        Token actual = lexer.lex("123").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test003_Identifier() {
        Token expected = new TokenImpl(TokenType.LET, 0, 2, 0,"let");
        Token actual = lexer.lex("let").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test004_LetKeyword() {
        Token expected = new TokenImpl(TokenType.LET, 0, 2, 0,"let");
        Token actual = lexer.lex("let").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test005_NumberType() {
        Token expected = new TokenImpl(TokenType.NUMBER_TYPE, 0, 5, 0,"number");
        Token actual = lexer.lex("number").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test006_StringType() {
        Token expected = new TokenImpl(TokenType.STRING_TYPE, 0, 5, 0,"string");
        Token actual = lexer.lex("string").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test007_Operator() {
        Token expected = new TokenImpl(TokenType.PLUS_SYMBOL, 0, 0, 0,"+");
        Token actual = lexer.lex("+").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test008_Space() {
        Token expected = new TokenImpl(TokenType.SPACE, 0, 0, 0," ");
        Token actual = lexer.lex(" ").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test009_SimpleOperation() {
        Token firstExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0,"2");
        Token secondExpected = new TokenImpl(TokenType.SLASH, 1, 1, 0,"-");
        Token thirdExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 2, 2, 0,"1");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected);
        List<Token> actual = lexer.lex("2-1");
        assertEquals(expected, actual);
    }

    @Test
    public void test010_OperationWithSpaces() {
        Token firstExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0,"2");
        Token secondExpected = new TokenImpl(TokenType.SPACE, 1, 1, 0," ");
        Token thirdExpected = new TokenImpl(TokenType.ASTERISK, 2, 2, 0,"*");
        Token fourthExpected = new TokenImpl(TokenType.SPACE, 3, 3, 0," ");
        Token fifthExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 4, 4, 0,"2");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected);
        List<Token> actual = lexer.lex("2 * 2");
        assertEquals(expected, actual);
    }

    @Test
    public void test011_Parenthesis() {
        Token expected1 = new TokenImpl(TokenType.PRINT, 0, 0, 0,"print");
        Token expected2 = new TokenImpl(TokenType.LEFT_PARENTHESIS, 0, 0, 0,"(");

        List<Token> expected = Arrays.asList(expected1, expected2);
        List<Token> actual = lexer.lex("print(");
        assertEquals(expected, actual);
    }

    @Test
    public void test015_IdentifiersWithOperation() {
        Token firstExpected = new TokenImpl(TokenType.IDENTIFIER, 0, 0, 0,"a");
        Token secondExpected = new TokenImpl(TokenType.SPACE, 1, 1, 0," ");
        Token thirdExpected = new TokenImpl(TokenType.PLUS_SYMBOL, 2, 2, 0,"+");
        Token fourthExpected = new TokenImpl(TokenType.SPACE, 3, 3, 0," ");
        Token fifthExpected = new TokenImpl(TokenType.IDENTIFIER, 4, 4, 0,"a");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected);
        List<Token> actual = lexer.lex("a + a");
        assertEquals(expected, actual);
    }

    @Test
    public void test016_AssignationWithType() {
        Token firstExpected = new TokenImpl(TokenType.LET, 0, 2, 0,"let");
        Token secondExpected = new TokenImpl(TokenType.SPACE, 3, 3, 0," ");
        Token thirdExpected = new TokenImpl(TokenType.IDENTIFIER, 4, 6, 0,"foo");
        Token fourthExpected = new TokenImpl(TokenType.COLON, 7, 7, 0,":");
        Token fifthExpected = new TokenImpl(TokenType.SPACE, 8, 8, 0," ");
        Token sixthExpected = new TokenImpl(TokenType.NUMBER_TYPE, 9, 14, 0,"number");
        Token seventhExpected = new TokenImpl(TokenType.SPACE, 15, 15, 0," ");
        Token eighthExpected = new TokenImpl(TokenType.EQUALS, 16, 16, 0,"=");
        Token ninthExpected = new TokenImpl(TokenType.SPACE, 17, 17, 0," ");
        Token tenthExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 18, 18, 0,"2");
        Token eleventhExpected = new TokenImpl(TokenType.SEMICOLON, 19, 19, 0,";");
        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected,
                sixthExpected, seventhExpected, eighthExpected, ninthExpected, tenthExpected, eleventhExpected);

        List<Token> actual = lexer.lex("let foo: number = 2;");
        assertEquals(expected, actual);
    }

    @Test
    public void test017_PrintFunctionWithExpression() {
        Token firstExpected = new TokenImpl(TokenType.PRINT, 0, 0, 0,"print");
        Token secondExpected = new TokenImpl(TokenType.LEFT_PARENTHESIS, 0, 0, 0,"(");
        Token thirdExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0,"4");
        Token fourthExpected = new TokenImpl(TokenType.FORWARD_SLASH, 0, 0, 0,"/");
        Token fifthExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 0, 0,"2");
        Token sixthExpected = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 0, 0, 0,")");
        Token seventhExpected = new TokenImpl(TokenType.SEMICOLON, 0, 0, 0,";");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected, sixthExpected, seventhExpected);
        List<Token> actual = lexer.lex("print(4/2);");
        assertEquals(expected, actual);
    }

    @Test
    public void test018_MultipleSpaces() {
        Token expected = new TokenImpl(TokenType.SPACE, 0, 2, 0,"   ");
        Token actual = lexer.lex("   ").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test020_LexerException() {
        try {
            lexer.lex("print((2);");
        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test021_LexerException() {
        try {
            lexer.lex("print();");
        } catch (LexerException e) {
            System.out.println(e.getMessage());
        }
    }
}
