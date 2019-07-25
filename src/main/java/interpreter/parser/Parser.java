package interpreter.parser;

import interpreter.node.ASTNode;
import interpreter.token.Token;

import java.util.List;


public interface Parser {

    ASTNode parse(List<Token> tokens);
}
