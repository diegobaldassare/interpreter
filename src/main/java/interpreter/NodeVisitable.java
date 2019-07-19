package interpreter;

public interface NodeVisitable {

    void accept(NodeVisitor visitor);
}
