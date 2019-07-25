package interpreter.node;

public class PrintNode implements ASTNode {

    private ExpressionNode argument;

    public PrintNode(ExpressionNode argument) {
        this.argument = argument;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitPrint(this);
    }

    public ExpressionNode getArgument() {
        return argument;
    }
}
