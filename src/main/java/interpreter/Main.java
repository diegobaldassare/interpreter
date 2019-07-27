package interpreter;

import interpreter.interpreter.Interpreter;
import interpreter.interpreter.InterpreterImpl;


public class Main {

    public static void main(String[] args) {
        final Interpreter interpreter = new InterpreterImpl();
        final String input =
                        "let var1: number = 2 * 4 - 10;" + // var1 = 8 - 10 = -2
                        "let var2: number; " +
                        "var2 = var1 / 2 + 5 * 3; " +      // var2 = -1 + 15 = 14
                        "print(var2 + 1); " +              // print(14 + 1)
                        "print(\"result: \" + var1); " +   // print("result: " + -2)
                        "let var3: string; " +
                        "var3 = 'Hello, '; " +
                        "print(var3 + 'world!');"; // print(Hello, world!)

        interpreter.interpret(input);
    }
}
