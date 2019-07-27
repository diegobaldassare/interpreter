package interpreter.node;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiteralNode literalNode = (LiteralNode) o;
        return value.equals(literalNode.value);
    }

    @Override
    public String toString() {
        return "LiteralNode{" +
                "value=" + value +
                '}';
    }
}
