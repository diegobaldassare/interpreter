package interpreter;

import lexer.Lexer;
import lexer.state.LexerAutomaton;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import parser.ParserImpl;

public class InterpreterTest {

    private Interpreter interpreter;

    @Before
    public void setUp() {
        Lexer lexer = new LexerAutomaton();
        Parser parser = new ParserImpl();
        interpreter = new InterpreterImpl();
    }

    @Test
    public void testSimpleCompilation001() {
        interpreter.interpret("let var: number;");
    }

    @Test
    public void testSimpleCompilation002() {
        interpreter.interpret("let a;\na = 2;\nprint(a);");
    }

    @Test
    public void testSimpleCompilation004() {
        interpreter.interpret("print(\"foo\");");
    }

    @Test
    public void testTwoExpressionCompilation() {
        interpreter.interpret("let a:string = \"aaa\";\nlet b:string = \"bbb\";\nprint(a+b);");
    }

    @Test
    public void testTwoExpressionCompilation2() {
        interpreter.interpret("let a:number = 2;\nlet b:number = 8;\nprint(a+b);");
    }

    @Test
    public void testTwoExpressionCompilation3() {
        interpreter.interpret("let a:string = \"2\";\nlet b:number = 8;\nprint(a+b);");
    }

    @Test
    public void testTwoExpressionCompilation4() {
        interpreter.interpret("let a:number = 2+2;\nlet b:number = 3+3;\nprint(a+b);");
    }

    @Test
    public void testTwoExpressionCompilation5() {
        interpreter.interpret("let a:string = \"he\";\nlet b:string = \"llo\";\nprint(a+b);");
    }

    @Test
    public void testManySpacesCompilation() {
        interpreter.interpret("   \n\n   let     foo: number   = 123312313    \n   ;\n\n\n\nprint(foo)     ; ");
    }

    @Test
    public void testReassignation() {
        interpreter.interpret("let a:number = 2; a = 3; print(a);");
    }

    @Test
    public void testExpressionWithRepeteadVar() {
        interpreter.interpret("let a:number = 2; print(a*a*a);");
    }

    @Test
    public void testPrecedenceInExpressions() {
        interpreter.interpret("let a:number = 2; let b:number = 3; let c:number = 1; print(a*b-c);");
    }
}