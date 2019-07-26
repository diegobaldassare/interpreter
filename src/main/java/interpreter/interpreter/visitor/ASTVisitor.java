package interpreter.interpreter.visitor;


import interpreter.node.*;
import interpreter.node.operation.BinaryOperationNode;
import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;

public interface ASTVisitor {

    public void visitProgram(ASTProgram program);
    public void visitDeclaration(DeclarationNode node);
    public void visitAssignation(AssignationNode node);
    public void visitPrint(PrintNode node);
    public void visitDeclarationAndAssignation(DeclarationAndAssignationNode node);
    public void visitExpression(ExpressionNode node);
    public void visitBinaryOperation(BinaryOperationNode node);
    public void visitIdentifier(IdentifierNode node);
    public void visitNumber(NumberValue node);
    public void visitString(StringValue node);
}
