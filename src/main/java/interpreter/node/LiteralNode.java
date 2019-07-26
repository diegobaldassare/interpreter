package interpreter.node;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.node.value.Value;

public class LiteralNode extends ExpressionNode {

    private Value value;

    public LiteralNode(int line, int fromColumn, int toColumn, Value value) {
        super(line, fromColumn, toColumn);
        this.value = value;
    }

    public LiteralNode(Value value) {
        this.value = value;
    }

    @Override
    public Value value() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        // A literal does anything
    }
}
