package interpreter.node.operation;

import interpreter.node.ExpressionNode;
import interpreter.node.value.Value;

public class SubtractionNode extends BinaryOperationNode {

    public SubtractionNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn, left, right);
    }

    public SubtractionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    Value calculateValue(ExpressionNode left, ExpressionNode right) {
        return left.value().subtract(right.value());
    }
}
