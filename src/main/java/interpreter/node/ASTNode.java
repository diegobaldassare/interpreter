package interpreter.node;

public interface ASTNode {

    public void accept(NodeVisitor visitor);
}
