package interpreter.node.value;

public abstract class Value {

    private final DataType dataType;

    Value(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public abstract void setValue(Value newValue);

    public static Value emptyValue(DataType dataType) {
        return dataType == DataType.STRING_TYPE ? new StringValue() : new NumberValue();
    }
}
