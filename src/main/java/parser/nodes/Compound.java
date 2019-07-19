package parser.nodes;

import interpreter.NodeVisitor;

import java.util.List;

public class Compound implements ASTNode {

    private final List<ASTNode> children;

    public Compound(List<ASTNode> children) {
        this.children = children;
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitCompound(this);
    }
}
