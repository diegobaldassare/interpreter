package interpreter.node.value;

import interpreter.node.ExpressionNode;

public abstract class Value extends ExpressionNode {

    Value(int line, int fromColumn, int toColumn) {
        super(line, fromColumn, toColumn);
    }

    Value() {
    }
}
