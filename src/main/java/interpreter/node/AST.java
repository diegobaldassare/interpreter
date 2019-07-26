package interpreter.node;

import interpreter.interpreter.visitor.ASTVisitor;

public interface AST {

    public void accept(ASTVisitor visitor);
}
