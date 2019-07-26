package interpreter.parser;

import interpreter.node.AST;
import interpreter.token.Token;

import java.util.List;


public interface Parser {

    AST parse(List<Token> tokens);
}
