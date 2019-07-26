package interpreter.node;

public class AssignationNode extends ASTNode {

    private String identifier;
    private ExpressionNode expression;

    public AssignationNode(int line, int fromColumn, int toColumn, String identifier, ExpressionNode expression) {
        super(line, fromColumn, toColumn);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignationNode node = (AssignationNode) o;
        return expression.equals(node.expression) &&
                identifier.equals(node.identifier);
    }
}
