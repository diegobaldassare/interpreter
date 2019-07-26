package interpreter.node;

public class IdentifierNode extends ExpressionNode {

    private String identifier;

    public IdentifierNode(int line, int fromColumn, int toColumn, String identifier) {
        super(line, fromColumn, toColumn);
        this.identifier = identifier;
    }

    @Override
    public void accept(NodeVisitor visitor) {

    }

    @Override
    public String value() {
        return null;
    }
}
