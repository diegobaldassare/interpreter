package interpreter.node;

import interpreter.interpreter.visitor.ASTVisitor;

public class DeclarationAndAssignationNode extends ASTNode {

    private DeclarationNode declarationNode;
    private AssignationNode assignationNode;

    public DeclarationAndAssignationNode(int line, int fromColumn, int toColumn, String dataType, String identifier, ExpressionNode expression) {
        super(line, fromColumn, toColumn);
        this.declarationNode = new DeclarationNode(line, fromColumn, toColumn, dataType, identifier);
        this.assignationNode = new AssignationNode(line, fromColumn, toColumn, identifier, expression);
    }

    public DeclarationAndAssignationNode(String dataType, String identifier, ExpressionNode expression) {
        this.declarationNode = new DeclarationNode(dataType, identifier);
        this.assignationNode = new AssignationNode(identifier, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitDeclaration(declarationNode);
        visitor.visitAssignation(assignationNode);
    }

    public String getDataType() {
        return declarationNode.getDataType();
    }

    public String getIdentifier() {
        return declarationNode.getIdentifier();
    }

    public ExpressionNode getExpression() {
        return assignationNode.getExpression();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationAndAssignationNode node = (DeclarationAndAssignationNode) o;
        return declarationNode.equals(node.declarationNode) &&
                assignationNode.equals(node.assignationNode);
    }

    @Override
    public String toString() {
        return "DeclarationAndAssignationNode{" +
                "dataType='" + getDataType() + '\'' +
                ", identifier='" + getIdentifier() + '\'' +
                ", expression='" + getExpression() + '\'' +
                '}';
    }
}
