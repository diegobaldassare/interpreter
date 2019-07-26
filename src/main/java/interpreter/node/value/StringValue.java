package interpreter.node.value;

import interpreter.interpreter.InterpreterException;
import interpreter.interpreter.visitor.ASTVisitor;

public class StringValue extends Value {

    private String value;

    public StringValue(int line, int fromColumn, int toColumn, String value) {
        super(line, fromColumn, toColumn, DataType.STRING_TYPE);
        this.value = value;
    }

    public StringValue(String value) {
        super(DataType.STRING_TYPE);
        this.value = value;
    }

    public StringValue() {
        super(DataType.STRING_TYPE);
    }

    @Override
    public void accept(ASTVisitor visitor) {

    }

    @Override
    public Value value() {
        return this;
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

    @Override
    public void setValue(Value newValue) {
        if (newValue.getDataType() != getDataType())
            throw new InterpreterException("the value has a different data type to the result expression at line " +
                    getLine() + ", between column " + getFromColumn() + " and " + getToColumn() + ".");
        this.value = newValue.toString();
    }
}
