package interpreter.parser;

import interpreter.node.AST;
import interpreter.node.ASTProgram;
import interpreter.parser.rule.*;
import interpreter.token.Token;
import interpreter.token.TokenType;

import java.util.ArrayList;
import java.util.List;


public class ParserImpl implements Parser {

    @Override
    public AST parse(List<Token> input) {
        List<Token> statements = removeSpaces(input);
        ASTProgram result = new ASTProgram();

        int start = 0;
        for (int end = 0; end < statements.size(); end++) {
            if (statements.get(end).tokenType().equals(TokenType.SEMICOLON)) {

                List<Token> statement = statements.subList(start, end);
                for (Rule r: getRules()) {

                    if (r.matches(statement)) {
                        result.getStatements().add(r.generateASTNode(statement));
                        break; // stop looking for another matching rule
                    }
                }
                start = end;
            }
        }
        return result;
    }

    private static List<Rule> getRules() {
        List<Rule> result = new ArrayList<>(5);
        result.add(new DeclarationRule());
        result.add(new AssignationRule());
        result.add(new DeclarationAndAssignationRule());
        result.add(new PrintRule());
        return result;
    }

    private static List<Token> removeSpaces(List<Token> program) {
        List<Token> wrapper = new ArrayList<>(program);
        wrapper.removeIf(t -> t.tokenType().equals(TokenType.SPACE));
        return wrapper;
    }
}
