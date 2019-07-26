package interpreter.interpreter.visitor;


import interpreter.node.*;
import interpreter.node.operation.BinaryOperationNode;

public interface ASTVisitor {

    void visitProgram(ASTProgram program);
    void visitDeclaration(DeclarationNode node);
    void visitAssignation(AssignationNode node);
    void visitPrint(PrintNode node);
    void visitDeclarationAndAssignation(DeclarationAndAssignationNode node);
    void visitBinaryOperation(BinaryOperationNode node);
    void visitIdentifier(IdentifierNode node);
}
