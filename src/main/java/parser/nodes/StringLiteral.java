package parser.nodes;

import interpreter.NodeVisitor;

public class StringLiteral implements ASTNode {

    private final String value;

    public StringLiteral(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitString(this);
    }
}
