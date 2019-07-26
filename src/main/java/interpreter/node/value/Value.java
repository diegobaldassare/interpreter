package interpreter.node.value;

import interpreter.node.ExpressionNode;

public abstract class Value extends ExpressionNode {

    private final DataType dataType;

    Value(int line, int fromColumn, int toColumn, DataType dataType) {
        super(line, fromColumn, toColumn);
        this.dataType = dataType;
    }

    Value(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public static Value generateEmptyValue(DataType dataType) {
        return dataType == DataType.STRING_TYPE ? new StringValue() : new NumberValue();
    }

    public abstract void setValue(Value newValue);
}
