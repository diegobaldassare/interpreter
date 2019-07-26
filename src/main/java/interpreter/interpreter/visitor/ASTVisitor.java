package interpreter.interpreter.visitor;

import interpreter.node.*;

public interface ASTVisitor {

    void visitProgram(ASTProgram program);
    void visitDeclaration(DeclarationNode node);
    void visitAssignation(AssignationNode node);
    void visitPrint(PrintNode node);
    void visitIdentifier(IdentifierNode node);
}
