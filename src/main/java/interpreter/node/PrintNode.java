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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintNode node = (PrintNode) o;
        return argument.equals(node.argument);
    }
}