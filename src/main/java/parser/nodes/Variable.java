package parser.nodes;

import interpreter.NodeVisitor;

public class Variable implements ASTNode {

    private final String value;

    public Variable(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitVariable(this);
    }
}
