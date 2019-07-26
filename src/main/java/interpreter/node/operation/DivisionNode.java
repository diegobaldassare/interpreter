package interpreter.node.operation;

import interpreter.node.ExpressionNode;
import interpreter.node.value.Value;

public class DivisionNode extends BinaryOperationNode {

    public DivisionNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn, left, right);
    }

    public DivisionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    Value calculateValue(ExpressionNode left, ExpressionNode right) {
        return left.value().divide(right.value());
    }
}
