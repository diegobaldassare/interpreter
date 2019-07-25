package interpreter;

import interpreter.node.ASTNode;
import interpreter.interpreter.Interpreter;
import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.token.Token;
import interpreter.parser.Parser;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        final Lexer lexer = new LexerAutomaton();

//        example1(lexer, parser, interpreter);
    }

    private static void example1(Lexer lexer, Parser parser, Interpreter interpreter) {
        final String input =
                "let var1: number;" +
                        "var1 = 2 / (5 - 1);" +
                        "let var2: number;" +
                        "var2 = var1 - 5 * (2 - 3);" +
                        "print(var2 + 1);" +
                        "print(var1);" +
                        "let var3: string;" +
                        "var3 = 'Hello, ';" +
                        "print(var3 + 'world!');";     // print(Hello, world!)

        final List<Token> lex = lexer.lex(input);
        final ASTNode parse = parser.parse(lex);

//        interpreter.interpret(parse);
    }
}
