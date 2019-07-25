package interpreter.parser;

import interpreter.ast.ASTNode;
import interpreter.token.Token;

import java.util.List;


public interface Parser {

    ASTNode parse(List<Token> tokens);
}
