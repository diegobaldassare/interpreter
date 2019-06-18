package diegobaldassare.lexer;

import diegobaldassare.lexer.token.Token;
import diegobaldassare.lexer.diegobaldassare.token.TokenImpl;
import diegobaldassare.lexer.token.TokenType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class TestLexer {

    private Lexer lexer;
    private TokenConsumer consumer;

    @Before
    public void setup() {
        consumer = new TokenConsumer();
        lexer = new LexerAutomaton(consumer);
    }

    @Test
    public void test001SimpleString() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("\"test\"");

        // when
        List<Token> lex = lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(6, 0, "\"test\"", TokenType.STRING);
        Token result = lex.get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test002SimpleNumber() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("123");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(3, 0, "123", TokenType.NUMBER);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test003SimpleIdentifier() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("identifier");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(10, 0, "identifier", TokenType.IDENTIFIER);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test004SimpleLet() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("let");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(3, 0, "let", TokenType.LET);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test005SimpleTypeNumber() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("number");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(6, 0, "number", TokenType.NUMBER_TYPE);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test006SimpleTypeString() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("string");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(6, 0, "string", TokenType.STRING_TYPE);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test007SimplePlusOperator() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("+");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(1, 0, "+", TokenType.PLUS);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test008SimpleMinusOperator() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("-");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(1, 0, "-", TokenType.MINUS);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test009SimpleMultiplyOperator() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("*");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(1, 0, "*", TokenType.MULTIPLY);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test010SimpleDivideOperator() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("/");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(1, 0, "/", TokenType.DIVIDE);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test011SimpleSpace() {
        // given
        Supplier<Character> supplier = new CharacterSupplier(" ");

        // when
        lexer.lex(supplier);

        // then
        Token expected = new TokenImpl(1, 0, " ", TokenType.SPACE);
        Token result = consumer.getResult().get(0);

        assertTokens(result, expected);
    }

    @Test
    public void test012SimpleOperation() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("2+2");

        // when
        lexer.lex(supplier);

        // then
        Token first = new TokenImpl(1, 0, "2", TokenType.NUMBER);
        Token second = new TokenImpl(2, 0, "+", TokenType.PLUS);
        Token third = new TokenImpl(3, 0, "2", TokenType.NUMBER);
        List<Token> expected = Arrays.asList(first, second, third);
        List<Token> result = consumer.getResult();

        assertTokenList(result, expected);
    }

    @Test
    public void test013OperationWithSpaces() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("2 + 2");

        // when
        lexer.lex(supplier);

        // then
        Token first = new TokenImpl(1, 0, "2", TokenType.NUMBER);
        Token second = new TokenImpl(2, 0, " ", TokenType.SPACE);
        Token third = new TokenImpl(3, 0, "+", TokenType.PLUS);
        Token fourth = new TokenImpl(4, 0, " ", TokenType.SPACE);
        Token fifth = new TokenImpl(5, 0, "2", TokenType.NUMBER);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth);
        List<Token> result = consumer.getResult();

        assertTokenList(result, expected);
    }

    @Test
    public void test013IdentifierWithSpaces() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("a + a");

        // when
        lexer.lex(supplier);

        // then
        Token first = new TokenImpl(1, 0, "a", TokenType.IDENTIFIER);
        Token second = new TokenImpl(2, 0, " ", TokenType.SPACE);
        Token third = new TokenImpl(3, 0, "+", TokenType.PLUS);
        Token fourth = new TokenImpl(4, 0, " ", TokenType.SPACE);
        Token fifth = new TokenImpl(5, 0, "a", TokenType.IDENTIFIER);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth);
        List<Token> result = consumer.getResult();

        assertTokenList(result, expected);
    }

    @Test
    public void test014SingleNewLine() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("\n");

        // when
        lexer.lex(supplier);

        // then
        Token result = consumer.getResult().get(0);
        Token expected = new TokenImpl(0, 1, "\n", TokenType.NEW_LINE);

        assertTokens(result, expected);
    }

    @Test
    public void test015NewLineThenIdentifier() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("\na");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(0, 1, "\n", TokenType.NEW_LINE);
        Token second = new TokenImpl(1, 1, "a", TokenType.IDENTIFIER);
        List<Token> expected = Arrays.asList(first, second);

        assertTokenList(result, expected);
    }

    @Test
    public void test016SimpleAssignationDeclaration() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("let foo=2");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(3, 0, "let", TokenType.LET);
        Token second = new TokenImpl(4, 0, " ", TokenType.SPACE);
        Token third = new TokenImpl(7, 0, "foo", TokenType.IDENTIFIER);
        Token fourth = new TokenImpl(8, 0, "=", TokenType.EQUALS);
        Token fifth = new TokenImpl(9, 0, "2", TokenType.NUMBER);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth);

        assertTokenList(result, expected);
    }

    @Test
    public void test016SimpleAssignationDeclarationSpaced() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("let foo = 2");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(3, 0, "let", TokenType.LET);
        Token second = new TokenImpl(4, 0, " ", TokenType.SPACE);
        Token third = new TokenImpl(7, 0, "foo", TokenType.IDENTIFIER);
        Token fourth = new TokenImpl(8, 0, " ", TokenType.SPACE);
        Token fifth = new TokenImpl(9, 0, "=", TokenType.EQUALS);
        Token sixth = new TokenImpl(10, 0, " ", TokenType.SPACE);
        Token seventh = new TokenImpl(11, 0, "2", TokenType.NUMBER);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh);

        assertTokenList(result, expected);
    }

    @Test
    public void test017SimpleAssignationDeclarationWithType() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("let foo:number = 2+2");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(3, 0, "let", TokenType.LET);
        Token second = new TokenImpl(4, 0, " ", TokenType.SPACE);
        Token third = new TokenImpl(7, 0, "foo", TokenType.IDENTIFIER);
        Token fourth = new TokenImpl(8, 0, ":", TokenType.COLON);
        Token fifth = new TokenImpl(14, 0, "number", TokenType.NUMBER_TYPE);
        Token sixth = new TokenImpl(15, 0, " ", TokenType.SPACE);
        Token seventh = new TokenImpl(16, 0, "=", TokenType.EQUALS);
        Token eight = new TokenImpl(17, 0, " ", TokenType.SPACE);
        Token ninth = new TokenImpl(18, 0, "2", TokenType.NUMBER);
        Token tenth = new TokenImpl(19, 0, "+", TokenType.PLUS);
        Token eleventh = new TokenImpl(20, 0, "2", TokenType.NUMBER);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth, eleventh);

        assertTokenList(result, expected);
    }

    @Test
    public void test018SimplePrint() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("print");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(5, 0, "print", TokenType.PRINT);
        List<Token> expected = Collections.singletonList(first);

        assertTokenList(result, expected);
    }

    @Test
    public void test018SimplePrintWithExpression() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("print(2+2)");

        // when
        lexer.lex(supplier);

        // then
        List<Token> result = consumer.getResult();
        Token first = new TokenImpl(5, 0, "print", TokenType.PRINT);
        Token second = new TokenImpl(6, 0, "(", TokenType.LPARENTHESIS);
        Token third = new TokenImpl(7, 0, "2", TokenType.NUMBER);
        Token fourth = new TokenImpl(8, 0, "+", TokenType.PLUS);
        Token fifth = new TokenImpl(9, 0, "2", TokenType.NUMBER);
        Token sixth = new TokenImpl(10, 0, ")", TokenType.RPARENTHESIS);
        List<Token> expected = Arrays.asList(first, second, third, fourth, fifth, sixth);

        assertTokenList(result, expected);
    }

    @Test
    public void test019SimpleException() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("$");

        try {
            // when
            lexer.lex(supplier);
        } catch (LexerException e) {
            //then
            assertNotNull(e.getMessage());
            assertThat(e.getMessage(), containsString("line: 0 and column: 0"));
        }
    }

    @Test
    public void test20MultipleSpaces() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("  ");

        List<Token> result = lexer.lex(supplier);

        Token first = new TokenImpl(2, 0, "  ", TokenType.SPACE);
        List<Token> expected = Collections.singletonList(first);

        assertTokenList(result, expected);
    }

    @Test (expected = LexerException.class)
    public void test21Exception() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("print((2);");

        lexer.lex(supplier);
    }

    @Test (expected = LexerException.class)
    public void test22Exception() {
        // given
        Supplier<Character> supplier = new CharacterSupplier("print();");

        lexer.lex(supplier);
    }

    private void assertTokens(Token actual, Token expected) {
        assertThat(actual.getColumn(), is(equalTo(expected.getColumn())));
        assertThat(actual.getLine(), is(equalTo(expected.getLine())));
        assertThat(actual.getType(), is(equalTo(expected.getType())));
        assertThat(actual.getValue(), is(equalTo(expected.getValue())));
    }

    private void assertTokenList(List<Token> actualList, List<Token> expectedList) {
        if (actualList.size() != expectedList.size()) throw new RuntimeException("Different size");
        for (int i = 0; i < actualList.size(); i++) {
            Token actual = actualList.get(i);
            Token expected = expectedList.get(i);
            assertThat(actual.getColumn(), is(equalTo(expected.getColumn())));
            assertThat(actual.getLine(), is(equalTo(expected.getLine())));
            assertThat(actual.getType(), is(equalTo(expected.getType())));
            assertThat(actual.getValue(), is(equalTo(expected.getValue())));
        }
    }

    @Test
    public void testIdentifierLex(){

        String file = "hola";

        TokenImpl expected = new TokenImpl(new RangeImpl(0, 4), new RangeImpl(0,0), TokenType.Identifier,"hola");

        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(expected, tokens.get(0));
    }

    @Test
    public void testSingleWordsLex(){

        String file = "let string\nboolean number";

        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl string = new TokenImpl(new RangeImpl(4,10 ), new RangeImpl(0,0), TokenType.StringType,"string");

        TokenImpl enter = new TokenImpl(new RangeImpl(10,0), new RangeImpl(0,1), TokenType.Enter,"\n");
        TokenImpl booleanType = new TokenImpl(new RangeImpl(0,7 ), new RangeImpl(1,1), TokenType.BooleanType,"boolean");
        TokenImpl numberType = new TokenImpl(new RangeImpl(8,14 ), new RangeImpl(1,1), TokenType.NumberType,"number");

        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(let, tokens.get(0));
        assertEquals(space, tokens.get(1));
        assertEquals(string, tokens.get(2));
        assertEquals(enter, tokens.get(3));
        assertEquals(booleanType, tokens.get(4));
        assertEquals(numberType, tokens.get(6));
    }

    @Test
    public void testPrintLex(){

        String file = "print(4) print(\"hola\") print(true)";

        TokenImpl print = new TokenImpl(new RangeImpl(0, 5), new RangeImpl(0,0), TokenType.Print,"print");
        TokenImpl leftParenthesis = new TokenImpl(new RangeImpl(5, 6), new RangeImpl(0,0), TokenType.LeftParenthesis,"(");
        TokenImpl number = new TokenImpl(new RangeImpl(6, 7), new RangeImpl(0,0), TokenType.NumberLiteral,"4");
        TokenImpl rightParenthesis = new TokenImpl(new RangeImpl(7, 8), new RangeImpl(0,0), TokenType.RightParenthesis,")");
        TokenImpl print2 = new TokenImpl(new RangeImpl(9, 14), new RangeImpl(0,0), TokenType.Print,"print");
        TokenImpl stringLiteral = new TokenImpl(new RangeImpl(15, 21), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl booleanLiteral = new TokenImpl(new RangeImpl(29, 33), new RangeImpl(0,0), TokenType.BooleanLiteral,"true");


        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(print, tokens.get(0));
        assertEquals(leftParenthesis, tokens.get(1));
        assertEquals(number, tokens.get(2));
        assertEquals(rightParenthesis, tokens.get(3));
        assertEquals(print2, tokens.get(5));
        assertEquals(stringLiteral, tokens.get(7));
        assertEquals(booleanLiteral, tokens.get(12));
    }
    @Test
    public void testDeclarationAssignationLex(){

        String file = "let hola:string=\"hola\"+\"hola\";";

        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl identifier = new TokenImpl(new RangeImpl(4, 8), new RangeImpl(0,0), TokenType.Identifier,"hola");
        TokenImpl colon = new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0,0), TokenType.Colon,":");
        TokenImpl stringType = new TokenImpl(new RangeImpl(9, 15), new RangeImpl(0,0), TokenType.StringType,"string");
        TokenImpl equal = new TokenImpl(new RangeImpl(15, 16), new RangeImpl(0,0), TokenType.EQUAL,"=");
        TokenImpl stringLiteral = new TokenImpl(new RangeImpl(16, 22), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl plus = new TokenImpl(new RangeImpl(22, 23), new RangeImpl(0,0), TokenType.ArithmeticOperation,"+");
        TokenImpl stringLiteral2 = new TokenImpl(new RangeImpl(23, 29), new RangeImpl(0,0), TokenType.StringLiteral,"\"hola\"");
        TokenImpl semiColon = new TokenImpl(new RangeImpl(29, 30), new RangeImpl(0,0), TokenType.Semicolon,";");


        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(let, tokens.get(0));
        assertEquals(space, tokens.get(1));
        assertEquals(identifier, tokens.get(2));
        assertEquals(colon, tokens.get(3));
        assertEquals(stringType, tokens.get(4));
        assertEquals(equal, tokens.get(5));
        assertEquals(stringLiteral, tokens.get(6));
        assertEquals(plus, tokens.get(7));
        assertEquals(stringLiteral2, tokens.get(8));
        assertEquals(semiColon, tokens.get(9));
    }

    @Test
    public void testDeclarationLex(){

        String file = "let hola:string;\n";

        TokenImpl let = new TokenImpl(new RangeImpl(0, 3), new RangeImpl(0,0), TokenType.Let,"let");
        TokenImpl space = new TokenImpl(new RangeImpl(3, 4), new RangeImpl(0,0), TokenType.Space," ");
        TokenImpl identifier = new TokenImpl(new RangeImpl(4, 8), new RangeImpl(0,0), TokenType.Identifier,"hola");
        TokenImpl colon = new TokenImpl(new RangeImpl(8, 9), new RangeImpl(0,0), TokenType.Colon,":");
        TokenImpl stringType = new TokenImpl(new RangeImpl(9, 15), new RangeImpl(0,0), TokenType.StringType,"string");
        TokenImpl semiColon = new TokenImpl(new RangeImpl(15,16), new RangeImpl(0,0), TokenType.Semicolon,";");


        List<Token> tokens = lexer.generateTokens(file);


        assertEquals(let, tokens.get(0));
        assertEquals(space, tokens.get(1));
        assertEquals(identifier, tokens.get(2));
        assertEquals(colon, tokens.get(3));
        assertEquals(stringType, tokens.get(4));
        assertEquals(semiColon, tokens.get(5));
    }

}
