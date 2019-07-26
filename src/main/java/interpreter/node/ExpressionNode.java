package interpreter.node;

public abstract class ExpressionNode extends ASTNode {

    public ExpressionNode(int line, int fromColumn, int toColumn) {
        super(line, fromColumn, toColumn);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitExpression(this);
    }

    public abstract String value();
}
