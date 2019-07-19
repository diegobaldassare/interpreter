package parser.nodes;

import interpreter.NodeVisitable;

public interface ASTNode extends NodeVisitable {

    String getValue();
}
