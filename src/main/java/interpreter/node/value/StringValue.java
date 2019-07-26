package interpreter.node.value;

import interpreter.node.NodeVisitor;

public class StringValue extends Value {

    private String value;

    public StringValue(int line, int fromColumn, int toColumn, String value) {
        super(line, fromColumn, toColumn);
        this.value = value;
    }

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public void accept(NodeVisitor visitor) {

    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValue node = (StringValue) o;
        return value.equals(node.value);
    }

    @Override
    public String toString() {
        return "StringValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
