package interpreter.node;

public interface AST {

    public void accept(NodeVisitor visitor);
}
