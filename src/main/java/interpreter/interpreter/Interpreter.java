package interpreter.interpreter;


import interpreter.node.ASTNode;

public interface Interpreter {

    void interpret(ASTNode node);
    void interpret(String input);
}
