package interpreter;

import parser.ast.ASTNode;

/**
 * Created by Diego Baldassare on 2019-06-18.
 */
public interface Interpreter {

    /**
     * Executes the ASTNode with all its statements.
     * @param head
     */
    public void interpret(ASTNode head);
}
