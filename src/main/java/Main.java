//import interpreter.Interpreter;
//import interpreter.InterpreterImpl;
//import lexer.Lexer;
//import lexer.state.LexerAutomaton;
//import parser.Parser;
//import parser.ParserAutomaton;
//
//public class Main {
//
//    public static void main(String[] args) {
//        final Lexer lexer = new LexerAutomaton();
//        final Parser parser = new ParserAutomaton();
//        final Interpreter interpreter = new InterpreterImpl();
//
//        //Code statements examples:
//        final String input1 = "let pepe: string = \"hola\"; let pepito: number; pepito = 5 * 5 - 8; print(pepito + pepe + \"mundo\");";
//
//        final String input2 =
//                        "let var1: number; " +
//                        "var1 = 2 * (5 - 1); " +        // var1 = 2 * 4 = 8
//                        "let var2: number; " +
//                        "var2 = var1 - 5 * (2 - 3); " + // var2 = 8 - (5 * -1) = 8 - (-5) = 13
//                        "print(var2 + 1); " +           // print(13 + 1)
//                        "print(var1); " +               // print(8)
//                        "let var3: string; " +
//                        "var3 = 'Hello, '; " +
//                        "print(var3 + 'world!');";     // print(Hello, world!)
//
//        System.out.println(interpreter.interpret(parser.parse(lexer.lex(input1))));
//        System.out.println(interpreter.interpret(parser.parse(lexer.lex(input2))));
//    }
//}
