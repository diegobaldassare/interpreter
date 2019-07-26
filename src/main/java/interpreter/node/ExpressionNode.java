package interpreter.node;

import interpreter.node.value.Value;

public abstract class ExpressionNode extends ASTNode {

    protected ExpressionNode(int line, int fromColumn, int toColumn) {
        super(line, fromColumn, toColumn);
    }

    protected ExpressionNode() {
    }

    public abstract Value value();
}
