package interpreter.node.operation;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.node.ExpressionNode;
import interpreter.node.value.NumberValue;
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
        return new NumberValue(0);
    }

    @Override
    public void accept(ASTVisitor visitor) {

    }
}
