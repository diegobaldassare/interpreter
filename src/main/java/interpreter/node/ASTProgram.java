package interpreter.node;

import java.util.ArrayList;
import java.util.List;

public class ASTProgram implements AST {

    private List<ASTNode> statements = new ArrayList<>();

    @Override
    public void accept(NodeVisitor visitor) {

    }

    public List<ASTNode> getStatements() {
        return statements;
    }

    public void setStatements(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ASTProgram program = (ASTProgram) obj;
        if (statements.size() != program.statements.size()) return false;
        for (int i = 0; i < statements.size(); i++) {
            if (!statements.get(i).equals(program.statements.get(i))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return statements.toString();
    }
}
