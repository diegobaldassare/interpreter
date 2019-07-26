package interpreter.parser;

import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.node.*;
import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ParserTest {

    private Parser parser;
    private Lexer lexer;

    @Before
    public void setUp() {
        lexer = new LexerAutomaton();
        parser = new ParserImpl();
    }

    @Test
    public void test001_DeclarationNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new DeclarationNode("number", "a"));
        AST actual = parser.parse(lexer.lex("let a: number;"));
        assertEquals(expected, actual);
    }

    @Test
    public void test002_AssignationNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new AssignationNode("a", new NumberValue(1)));
        AST actual = parser.parse(lexer.lex("a = 1;"));
        assertEquals(expected, actual);
    }

    @Test
    public void test003_PrintNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new PrintNode(new StringValue("test")));
        AST actual = parser.parse(lexer.lex("print(\"test\");"));
        assertEquals(expected, actual);
    }
}
