package interpreter.node.value;

import interpreter.node.NodeVisitor;

public class StringValue extends Value {

    private String value;

    public StringValue(int line, int fromColumn, int toColumn, String value) {
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
