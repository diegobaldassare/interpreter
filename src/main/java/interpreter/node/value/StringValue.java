package interpreter.node.value;

public class StringValue extends Value {

    private String value;

    public StringValue(String value) {
        super(DataType.STRING_TYPE);
        this.value = value;
    }

    StringValue() {
        super(DataType.STRING_TYPE);
    }

    public Value add(Value value) {
        return value.add(this);
    }
    public Value subtract(Value value) {
        return value.subtract(this);
    }
    public Value multiply(Value value) {
        return value.multiply(this);
    }
    public Value divide(Value value) {
        return value.divide(this);
    }

    @Override
    public void setValue(Value newValue) {
        verifyMismatch(newValue);
        this.value = newValue.toString();
    }

    @Override
    Value add(NumberValue value) {
        return new StringValue(this.value + value.toString());
    }

    @Override
    Value add(StringValue value) {
        return new StringValue(this.value + value.toString());
    }

    @Override
    Value subtract(NumberValue value) {
        throw new UnsupportedOperationException("Can not subtract a string");
    }

    @Override
    Value subtract(StringValue value) {
        throw new UnsupportedOperationException("Can not subtract a string");
    }

    @Override
    Value multiply(NumberValue value) {
        throw new UnsupportedOperationException("Can not multiply a string");
    }

    @Override
    Value multiply(StringValue value) {
        throw new UnsupportedOperationException("Can not multiply a string");
    }

    @Override
    Value divide(NumberValue value) {
        throw new UnsupportedOperationException("Can not divide a string");
    }

    @Override
    Value divide(StringValue value) {
        throw new UnsupportedOperationException("Can not divide a string");
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
