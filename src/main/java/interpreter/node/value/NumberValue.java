package interpreter.node.value;

import interpreter.interpreter.InterpreterException;
import interpreter.interpreter.visitor.ASTVisitor;

public class NumberValue extends Value {

    private int value;

    public NumberValue(int line, int fromColumn, int toColumn, int value) {
        super(line, fromColumn, toColumn, DataType.NUMBER_TYPE);
        this.value = value;
    }

    public NumberValue(int value) {
        super(DataType.NUMBER_TYPE);
        this.value = value;
    }

    public NumberValue() {
        super(DataType.NUMBER_TYPE);
    }

    @Override
    public void accept(ASTVisitor visitor) {

    }

    @Override
    public void setValue(Value newValue) {
        if (newValue.getDataType() != getDataType())
            throw new InterpreterException("the value has a different data type to the result expression at line " +
                    getLine() + ", between column " + getFromColumn() + " and " + getToColumn() + ".");
        this.value = Integer.valueOf(newValue.toString());
    }

    @Override
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
