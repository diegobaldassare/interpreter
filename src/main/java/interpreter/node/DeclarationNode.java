package interpreter.node;

public class DeclarationNode implements ASTNode {

    private String dataType;
    private String identifier;

    public DeclarationNode(String dataType, String identifier) {
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
