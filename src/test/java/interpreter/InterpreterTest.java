//package interpreter;
//
//import lexer.Lexer;
//import org.junit.Before;
//import org.junit.Test;
//import parser.Parser;
//import parser.ParserAutomaton;
//
//public class InterpreterTest {
//
//    private Compiler compiler;
//
//    @Before
//    public void setUp() {
//        Lexer lexer = new LexerAutomaton();
//        Parser parser = new ParserAutomaton(new ProgramController());
//        Interpreter interpreter = new InterpreterImpl();
//
//        compiler = new CompilerImpl(lexer, parser, interpreter);
//    }
//
//    @Test
//    public void testSimpleCompilation001() {
//        compiler.compile("print(2+2);");
//    }
//
//    @Test
//    public void testSimpleCompilation002() {
//        compiler.compile("let a;\na = 2;\nprint(a);");
//    }
//
//    @Test
//    public void testSimpleCompilation004() {
//        compiler.compile("print(\"foo\");");
//    }
//
//    @Test
//    public void testTwoExpressionCompilation() {
//        compiler.compile("let a:string = \"aaa\";\nlet b:string = \"bbb\";\nprint(a+b);");
//    }
//
//    @Test
//    public void testTwoExpressionCompilation2() {
//        compiler.compile("let a:number = 2;\nlet b:number = 8;\nprint(a+b);");
//    }
//
//    @Test
//    public void testTwoExpressionCompilation3() {
//        compiler.compile("let a:string = \"2\";\nlet b:number = 8;\nprint(a+b);");
//    }
//
//    @Test
//    public void testTwoExpressionCompilation4() {
//        compiler.compile("let a:number = 2+2;\nlet b:number = 3+3;\nprint(a+b);");
//    }
//
//    @Test
//    public void testTwoExpressionCompilation5() {
//        compiler.compile("let a:string = \"he\";\nlet b:string = \"llo\";\nprint(a+b);");
//    }
//
//    @Test
//    public void testManySpacesCompilation() {
//        compiler.compile("   \n\n   let     foo: number   = 123312313    \n   ;\n\n\n\nprint(foo)     ; ");
//    }
//
//    @Test
//    public void testReassignation() {
//        compiler.compile("let a:number = 2; a = 3; print(a);");
//    }
//
//    @Test
//    public void testExpressionWithRepeteadVar() {
//        compiler.compile("let a:number = 2; print(a*a*a);");
//    }
//
//    @Test
//    public void testPrecedenceInExpressions() {
//        compiler.compile("let a:number = 2; let b:number = 3; let c:number = 1; print(a*b-c);");
//    }
//
//    @Test(expected = InterpreterException.class)
//    public void testTypeException() {
//        compiler.compile("let a:number = \"foo\";");
//    }
//
//    @Test(expected = InterpreterException.class)
//    public void testTypeException2() {
//        compiler.compile("let a:string = 2;");
//    }
//
////    @Test
////    public void testSingleQuoteString() {
////        compiler.compile("print(\'foo\');");
////    }
////
////    @Test (expected = InterpreterException.class)
////    public void testDeclarationAndUsageWithoutAssignation() {
////        compiler.compile("let a; print(a);");
////    }
//
//    @Test
//    public void testPrintSeparatorExpression() {
//        compiler.compile("print(\";;()()\");");
//    }
//}