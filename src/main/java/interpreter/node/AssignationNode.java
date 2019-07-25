package interpreter.node;

public class AssignationNode implements ASTNode {

    private String identifier;
    private ExpressionNode expression;

    public AssignationNode(String identifier, ExpressionNode expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitAssignation(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
