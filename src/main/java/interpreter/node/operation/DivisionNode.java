package interpreter.node.operation;

import interpreter.node.ExpressionNode;

public class DivisionNode extends BinaryOperationNode {

    public DivisionNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn, left, right);
    }

    public DivisionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    String calculateValue(ExpressionNode left, ExpressionNode right) {
        return left.value() + right.value();
    }
}
