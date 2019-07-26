package interpreter.node;

import interpreter.interpreter.visitor.ASTVisitor;

public class IdentifierNode extends ExpressionNode {

    private String identifier;

    public IdentifierNode(int line, int fromColumn, int toColumn, String identifier) {
        super(line, fromColumn, toColumn);
        this.identifier = identifier;
    }

    public IdentifierNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIdentifier(this);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentifierNode node = (IdentifierNode) o;
        return identifier.equals(node.identifier);
    }

    @Override
    public String toString() {
        return "IdentifierNode{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
