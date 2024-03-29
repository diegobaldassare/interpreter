package interpreter.node.value;

import interpreter.interpreter.InterpreterException;

public abstract class Value {

    private final DataType dataType;

    Value(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public abstract Value add(Value value);
    public abstract Value subtract(Value value);
    public abstract Value multiply(Value value);
    public abstract Value divide(Value value);

    public abstract void setValue(Value newValue);

    abstract Value add(NumberValue value);
    abstract Value add(StringValue value);
    abstract Value subtract(NumberValue value);
    abstract Value subtract(StringValue value);
    abstract Value multiply(NumberValue value);
    abstract Value multiply(StringValue value);
    abstract Value divide(NumberValue value);
    abstract Value divide(StringValue value);

    void verifyMismatch(Value newValue) {
        if (newValue.getDataType() != this.getDataType())
            throw new InterpreterException("type mismatch");
    }

    public static Value emptyValue(DataType dataType) {
        return dataType == DataType.STRING_TYPE ? new StringValue() : new NumberValue();
    }
}
