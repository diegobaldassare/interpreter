package interpreter;

import lexer.Lexer;
import lexer.state.LexerAutomaton;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import parser.ParserImpl;

public class InterpreterTest {

    private Lexer lexer;
    private Parser parser;
    private Interpreter interpreter;

    @Before
    public void setUp() {
        lexer = new LexerAutomaton();
        parser = new ParserImpl();
        interpreter = new InterpreterImpl();
    }

    @Test
    public void test001() {
        final String s = "let var: number;";
        interpreter.interpret(parser.parse(lexer.lex(s)));
    }

    @Test
    public void test002() {
        interpreter.interpret("var1 = 2 * (5 - 1);");
    }

    @Test
    public void test003() {
        interpreter.interpret("let var2: number;");
    }

    @Test
    public void test004() {
        interpreter.interpret("var2 = var1 - 5 * (2 - 3);");
    }

    @Test
    public void test005() {
        interpreter.interpret("print(var2 + 1);");
    }

    @Test
    public void test006() {
        interpreter.interpret("print(var1);");
    }

    @Test
    public void test007() {
        interpreter.interpret("let var3: string;");
    }

    @Test
    public void test008() {
        interpreter.interpret("print(2);");
    }
}