package interpreter.node.value;

import interpreter.interpreter.InterpreterException;

import static interpreter.node.value.DataType.NUMBER_TYPE;

public class NumberValue extends Value {

    private int value;

    public NumberValue(int value) {
        super(NUMBER_TYPE);
        this.value = value;
    }

    public NumberValue() {
        super(NUMBER_TYPE);
    }

    @Override
    public void setValue(Value newValue) {
        if (newValue.getDataType() != getDataType())
            throw new InterpreterException("the value has a different data type to the result expression");
        this.value = Integer.valueOf(newValue.toString());
    }

    public Value value() {
        return this;
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
        return String.valueOf(value);
    }
}
