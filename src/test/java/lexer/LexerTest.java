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
        Token expected = new TokenImpl(TokenType.STRING_LITERAL, 0, 3,0, "test");
        Token actual = lexer.lex("\"test\"").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test002_NumberLiteral() {
        Token expected = new TokenImpl(TokenType.NUMBER_LITERAL, 0, 2, 0,"123");
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
        Token expected1 = new TokenImpl(TokenType.PRINT, 0, 4, 0,"print");
        Token expected2 = new TokenImpl(TokenType.LEFT_PARENTHESIS, 5, 5, 0,"(");

        List<Token> expected = Arrays.asList(expected1, expected2);
        List<Token> actual = lexer.lex("print(");
        assertEquals(expected, actual);
    }

    @Test
    public void test012_IdentifiersWithOperation() {
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
    public void test013_AssignationWithType() {
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
    public void test014_PrintFunctionWithExpression() {
        Token firstExpected = new TokenImpl(TokenType.PRINT, 0, 4, 0,"print");
        Token secondExpected = new TokenImpl(TokenType.LEFT_PARENTHESIS, 5, 5, 0,"(");
        Token thirdExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 6, 6, 0,"4");
        Token fourthExpected = new TokenImpl(TokenType.FORWARD_SLASH, 7, 7, 0,"/");
        Token fifthExpected = new TokenImpl(TokenType.NUMBER_LITERAL, 8, 8, 0,"2");
        Token sixthExpected = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 9, 9, 0,")");
        Token seventhExpected = new TokenImpl(TokenType.SEMICOLON, 10, 10, 0,";");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected, sixthExpected, seventhExpected);
        List<Token> actual = lexer.lex("print(4/2);");
        assertEquals(expected, actual);
    }

    @Test
    public void test015_MultipleSpaces() {
        Token expected = new TokenImpl(TokenType.SPACE, 0, 2, 0,"   ");

        List<Token> actual = lexer.lex("   ");
        assertEquals(expected, actual.get(0));
        assertEquals(1, actual.size());
    }

    @Test
    public void test016_MultipleSymbols() {
        Token firstExpected = new TokenImpl(TokenType.PRINT, 0, 4, 0,"print");
        Token secondExpected = new TokenImpl(TokenType.LEFT_PARENTHESIS, 5, 5, 0,"(");
        Token thirdExpected = new TokenImpl(TokenType.LEFT_PARENTHESIS, 6, 6, 0,"(");
        Token fourthExpected = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 7, 7, 0,")");
        Token fifthExpected = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 8, 8, 0,")");
        Token sixthExpected = new TokenImpl(TokenType.SEMICOLON, 9, 9, 0,";");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected, sixthExpected);
        List<Token> actual = lexer.lex("print(());");
        assertEquals(expected, actual);
    }

    @Test
    public void test017_MultipleStrings() {
        Token firstExpected = new TokenImpl(TokenType.STRING_LITERAL, 0, 1, 0,"te");
        Token secondExpected = new TokenImpl(TokenType.SPACE, 2, 2, 0," ");
        Token thirdExpected = new TokenImpl(TokenType.PLUS_SYMBOL, 3, 3, 0,"+");
        Token fourthExpected = new TokenImpl(TokenType.SPACE, 4, 4, 0," ");
        Token fifthExpected = new TokenImpl(TokenType.STRING_LITERAL, 5, 6, 0,"st");

        List<Token> expected = Arrays.asList(firstExpected, secondExpected, thirdExpected, fourthExpected, fifthExpected);
        List<Token> actual = lexer.lex("\"te\" + \"st\"");

        assertEquals(expected, actual);
    }

    @Test
    public void test018_MultipleLines() {
        Token expected1 = new TokenImpl(TokenType.LET, 0, 2, 0,"let");
        Token expected2 = new TokenImpl(TokenType.SPACE, 3, 3, 0," ");
        Token expected3 = new TokenImpl(TokenType.IDENTIFIER, 4, 12, 0,"variable1");
        Token expected4 = new TokenImpl(TokenType.COLON, 13, 13, 0,":");
        Token expected5 = new TokenImpl(TokenType.SPACE, 14, 14, 0," ");
        Token expected6 = new TokenImpl(TokenType.NUMBER_TYPE, 15, 20, 0,"number");
        Token expected7 = new TokenImpl(TokenType.SEMICOLON, 21, 21, 0,";");

        Token expected8 = new TokenImpl(TokenType.IDENTIFIER, 0, 8, 1,"variable1");
        Token expected9 = new TokenImpl(TokenType.SPACE, 9, 9, 1," ");
        Token expected10 = new TokenImpl(TokenType.EQUALS, 10, 10, 1,"=");
        Token expected11 = new TokenImpl(TokenType.SPACE, 11, 11, 1," ");
        Token expected12 = new TokenImpl(TokenType.NUMBER_LITERAL, 12, 12, 1,"4");
        Token expected13 = new TokenImpl(TokenType.FORWARD_SLASH, 13, 13, 1,"/");
        Token expected14 = new TokenImpl(TokenType.LEFT_PARENTHESIS, 14, 14, 1,"(");
        Token expected15 = new TokenImpl(TokenType.NUMBER_LITERAL, 15, 15, 1,"3");
        Token expected16 = new TokenImpl(TokenType.SLASH, 16, 16, 1,"-");
        Token expected17 = new TokenImpl(TokenType.NUMBER_LITERAL, 17, 17, 1,"1");
        Token expected18 = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 18, 18, 1,")");
        Token expected19 = new TokenImpl(TokenType.SEMICOLON, 19, 19, 1,";");

        Token expected20 = new TokenImpl(TokenType.PRINT, 0, 4, 2,"print");
        Token expected21 = new TokenImpl(TokenType.LEFT_PARENTHESIS, 5, 5, 2,"(");
        Token expected22 = new TokenImpl(TokenType.IDENTIFIER, 6, 14, 2,"variable1");
        Token expected23 = new TokenImpl(TokenType.RIGHT_PARENTHESIS, 15, 15, 2,")");
        Token expected24 = new TokenImpl(TokenType.SEMICOLON, 16, 16, 2,";");

        List<Token> expected = Arrays.asList(expected1, expected2, expected3, expected4, expected5, expected6, expected7,
                expected8, expected9, expected10, expected11, expected12, expected13, expected14, expected15, expected16,
                expected17, expected18, expected19, expected20, expected21, expected22, expected23, expected24);

        List<Token> actual = lexer.lex(
                "let variable1: number;" +
                        "variable1 = 4/(3-1);" +
                        "print(variable1);");
        assertEquals(expected, actual);
    }
}
