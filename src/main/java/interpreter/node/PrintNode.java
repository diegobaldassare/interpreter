package interpreter.node;

public class PrintNode extends ASTNode {

    private ExpressionNode argument;

    public PrintNode(int line, int fromColumn, int toColumn, ExpressionNode argument) {
        super(line, fromColumn, toColumn);
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
