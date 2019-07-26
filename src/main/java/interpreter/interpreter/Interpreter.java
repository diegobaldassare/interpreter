package interpreter.interpreter;


import interpreter.node.AST;

public interface Interpreter {

    void interpret(AST program);
    void interpret(String input);
}
