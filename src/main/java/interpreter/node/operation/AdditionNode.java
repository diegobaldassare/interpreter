package interpreter.node.operation;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.node.ExpressionNode;
import interpreter.node.value.NumberValue;
import interpreter.node.value.Value;

public class AdditionNode extends BinaryOperationNode {

    public AdditionNode(int line, int fromColumn, int toColumn, ExpressionNode left, ExpressionNode right) {
        super(line, fromColumn, toColumn, left, right);
    }

    public AdditionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    Value calculateValue(ExpressionNode left, ExpressionNode right) {
//        return left.value().a.add(right.value());
        return new NumberValue();
    }

    @Override
    public void accept(ASTVisitor visitor) {
//        visitor.visitAddition(visitor);
    }
}
