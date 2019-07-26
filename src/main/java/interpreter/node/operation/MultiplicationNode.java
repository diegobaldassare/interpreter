package interpreter.node.operation;

import interpreter.node.ExpressionNode;

public class MultiplicationNode extends BinaryOperationNode {

    public MultiplicationNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn, left, right);
    }

    @Override
    String calculateValue(ExpressionNode left, ExpressionNode right) {
        return left.value() + right.value();
    }
}
