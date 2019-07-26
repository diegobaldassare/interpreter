package interpreter.node.value;

import interpreter.interpreter.InterpreterException;

public class StringValue extends Value {

    private String value;

    public StringValue(String value) {
        super(DataType.STRING_TYPE);
        this.value = value;
    }

    public StringValue() {
        super(DataType.STRING_TYPE);
    }

    @Override
    public void setValue(Value newValue) {
        if (newValue.getDataType() != getDataType())
            throw new InterpreterException("the value has a different data type to the result expression");
        this.value = newValue.toString();
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
        return value;
    }
}
