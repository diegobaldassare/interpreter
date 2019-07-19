package parser.nodes;

import interpreter.NodeVisitor;

public class Type implements ASTNode {

    private final String value;

    public Type(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {

    }
}
