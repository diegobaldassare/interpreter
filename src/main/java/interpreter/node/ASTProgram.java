package interpreter.node;

import java.util.List;

public class ASTProgram implements AST {

    private List<ASTNode> statements;

    @Override
    public void accept(NodeVisitor visitor) {

    }

    public List<ASTNode> getStatements() {
        return statements;
    }

    public void setStatements(List<ASTNode> statements) {
        this.statements = statements;
    }
}
