package interpreter.interpreter;


import interpreter.node.AST;

public interface Interpreter {

    void interpret(AST node);
    void interpret(String input);
}
