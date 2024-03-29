package interpreter.node.value;

import static interpreter.node.value.DataType.NUMBER_TYPE;

public class NumberValue extends Value {

    private int value;

    public NumberValue(int value) {
        super(NUMBER_TYPE);
        this.value = value;
    }

    NumberValue() {
        super(NUMBER_TYPE);
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
        this.value = Integer.valueOf(newValue.toString());
    }

    @Override
    Value add(NumberValue value) {
        return new NumberValue(value.value + this.value);
    }

    @Override
    Value add(StringValue value) {
        return new StringValue(value.toString() + this.value);
    }

    @Override
    Value subtract(NumberValue value) {
        return new NumberValue(value.value - this.value);
    }

    @Override
    Value subtract(StringValue value) {
        throw new UnsupportedOperationException("Can not subtract a Number with a String");
    }

    @Override
    Value multiply(NumberValue value) {
        return new NumberValue(this.value * value.value);
    }

    @Override
    Value multiply(StringValue value) {
        throw new UnsupportedOperationException("Can not multiply a Number with a String");
    }

    @Override
    Value divide(NumberValue value) {
        if (this.value == 0) {
            throw new ArithmeticException("Can not divide by zero");
        }
        return new NumberValue(value.value / this.value);
    }

    @Override
    Value divide(StringValue value) {
        throw new UnsupportedOperationException("Can not divide a Number with a String");
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
