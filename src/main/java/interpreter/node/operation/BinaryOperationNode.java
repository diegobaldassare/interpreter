package interpreter.node.operation;

import interpreter.node.ExpressionNode;
import interpreter.node.value.Value;

public abstract class BinaryOperationNode extends ExpressionNode {

    private ExpressionNode left;
    private ExpressionNode right;

    BinaryOperationNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn);
        this.left = left;
        this.right = right;
    }

    BinaryOperationNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Value value() {
        return calculateValue(left, right);
    }

    abstract Value calculateValue(ExpressionNode left, ExpressionNode right);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperationNode node = (BinaryOperationNode) o;
        return left.equals(node.left) &&
                right.equals(node.right);
    }

    @Override
    public String toString() {
        return "BinaryOperationNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
