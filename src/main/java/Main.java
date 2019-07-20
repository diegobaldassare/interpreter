import interpreter.Interpreter;
import interpreter.InterpreterImpl;
import lexer.Lexer;
import lexer.state.LexerAutomaton;
import lexer.token.Token;
import parser.Parser;
import parser.ParserImpl;
import parser.nodes.ASTNode;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        final Lexer lexer = new LexerAutomaton();
        final Parser parser = new ParserImpl();
        final Interpreter interpreter = new InterpreterImpl();

        example1(lexer, parser, interpreter);
    }

    private static void example1(Lexer lexer, Parser parser, Interpreter interpreter) {
        final String input =
                        "let var1: number;" +
                                "var1 = 2 / (5 - 1);" +
                                "" +
                                "let var2: number;" +
                                "var2 = var1 - 5 * (2 - 3);" +
                                "" +
                                "print(var2 + 1);" +
                                "print(var1);" +
                                "" +
                                "let var3: string;" +
                                "var3 = 'Hello, ';" +
                                "" +
                                "print(var3 + 'world!');";     // print(Hello, world!)

        final List<Token> lex = lexer.lex(input);
        final ASTNode parse = parser.parse(lex);

        interpreter.interpret(parse);
    }
}
