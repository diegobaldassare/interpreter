package interpreter.interpreter;


import interpreter.ast.ASTNode;

public interface Interpreter {

    void interpret(ASTNode node);
    void interpret(String input);
}
