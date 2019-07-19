package parser.nodes;

import interpreter.NodeVisitor;

public class NumberLiteral implements ASTNode {

    private final String value;

    public NumberLiteral(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitNumber(this);
    }
}
