package interpreter.node;

public abstract class ExpressionNode implements ASTNode {

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitExpression(this);
    }

    public abstract String value();
}
