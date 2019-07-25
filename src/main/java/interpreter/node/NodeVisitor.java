package interpreter.node;

public interface NodeVisitor {

    void visitDeclaration(DeclarationNode node);
    void visitAssignation(AssignationNode node);
    void visitExpression(ExpressionNode node);
    void visitPrint(PrintNode node);

}
