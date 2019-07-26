package interpreter.node.value;

import interpreter.node.NodeVisitor;

public class NumberValue extends Value {

    private int value;

    public NumberValue(int line, int fromColumn, int toColumn, int value) {
        super(line, fromColumn, toColumn);
        this.value = value;
    }

    public NumberValue(int value) {
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
        NumberValue node = (NumberValue) o;
        return value == node.value;
    }

    @Override
    public String toString() {
        return "NumberValue{" +
                "value=" + value +
                '}';
    }
}
