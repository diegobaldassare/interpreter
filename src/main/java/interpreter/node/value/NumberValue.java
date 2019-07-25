package interpreter.node.value;

import interpreter.node.NodeVisitor;

public class NumberValue extends Value {

    private int value;

    public NumberValue(int line, int fromColumn, int toColumn, int value) {
        super(line, fromColumn, toColumn);
        this.value = value;
    }

    @Override
    public void accept(NodeVisitor visitor) {

    }

    @Override
    public String value() {
        return null;
    }
}
