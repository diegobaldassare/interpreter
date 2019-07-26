package interpreter.node;

public class DeclarationNode extends ASTNode {

    private String dataType;
    private String identifier;

    public DeclarationNode(int line, int fromColumn, int toColumn, String dataType, String identifier) {
        super(line, fromColumn, toColumn);
        this.dataType = dataType;
        this.identifier = identifier;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationNode node = (DeclarationNode) o;
        return dataType.equals(node.dataType) &&
                identifier.equals(node.identifier);
    }

    @Override
    public String toString() {
        return "DeclarationNode{" +
                "dataType='" + dataType + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
