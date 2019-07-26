package interpreter.node;

public class DeclarationNode extends ASTNode {

    private String dataType;
    private String identifier;

    public DeclarationNode(int line, int fromColumn, int toColumn, String dataType, String identifier) {
        super(line, fromColumn, toColumn);
        this.dataType = dataType;
        this.identifier = identifier;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitDeclaration(this);
    }

    public String getDataType() {
        return dataType;
    }

    public String getIdentifier() {
        return identifier;
    }
}
