package interpreter.node;

import interpreter.interpreter.visitor.ASTVisitor;
import interpreter.node.value.DataType;

public class DeclarationNode extends ASTNode {

    private final DataType dataType;
    private final String identifier;

    public DeclarationNode(int line, int fromColumn, int toColumn, DataType dataType, String identifier) {
        super(line, fromColumn, toColumn);
        this.dataType = dataType;
        this.identifier = identifier;
    }

    public DeclarationNode(DataType dataType, String identifier) {
        this.dataType = dataType;
        this.identifier = identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitDeclaration(this);
    }

    public DataType getDataType() {
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
