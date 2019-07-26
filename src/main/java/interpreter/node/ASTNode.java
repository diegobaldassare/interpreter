package interpreter.node;

public abstract class ASTNode implements AST {

    private int line;
    private int fromColumn;
    private int toColumn;

    ASTNode(int line, int fromColumn, int toColumn) {
        this.line = line;
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
    }

    public int getLine() {
        return line;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public int getToColumn() {
        return toColumn;
    }
}
