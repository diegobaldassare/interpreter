package interpreter.parser;

import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.node.*;
import interpreter.node.operation.AdditionNode;
import interpreter.node.operation.MultiplicationNode;
import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
import org.junit.Before;
import org.junit.Test;

import static interpreter.node.value.DataType.NUMBER_TYPE;
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
        expected.getStatements().add(new DeclarationNode(NUMBER_TYPE, "a"));
        AST actual = parser.parse(lexer.lex("let a: number;"));
        assertEquals(expected, actual);
    }

    @Test
    public void test002_AssignationNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new AssignationNode("a", new LiteralNode(new NumberValue(1))));
        AST actual = parser.parse(lexer.lex("a = 1;"));
        assertEquals(expected, actual);
    }

    @Test
    public void test003_PrintNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new PrintNode(new LiteralNode(new StringValue("test"))));
        AST actual = parser.parse(lexer.lex("print(\"test\");"));
        assertEquals(expected, actual);
    }

    @Test
    public void test004_PrintWithBinaryOperation() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new PrintNode(new AdditionNode(
                new LiteralNode(new NumberValue(2)), new LiteralNode(new NumberValue(2)))));
        AST actual = parser.parse(lexer.lex("print(2 + 2);"));
        assertEquals(expected, actual);
    }

    @Test
    public void test005_PrintWithMultipleBinaryOperations() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new PrintNode(new AdditionNode(
                new MultiplicationNode(new LiteralNode(new NumberValue(2)), new LiteralNode(new NumberValue(3))),
                new LiteralNode(new NumberValue(1)))));
        AST actual = parser.parse(lexer.lex("print(2 * 3 + 1);"));
        assertEquals(expected, actual);
    }

    @Test
    public void test006_AssignationWithIdentifier() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new AssignationNode("a", new AdditionNode(
                new IdentifierNode("a"),
                new LiteralNode(new NumberValue(1)))));
        AST actual = parser.parse(lexer.lex("a = a + 1;"));
        assertEquals(expected, actual);
    }

    @Test
    public void test007_DeclarationAndAssignationNode() {
        ASTProgram expected = new ASTProgram();
        expected.getStatements().add(new DeclarationAndAssignationNode(NUMBER_TYPE, "a",
                new LiteralNode(new NumberValue(4))));
        AST actual = parser.parse(lexer.lex("let a: number = 4;"));
        assertEquals(expected, actual);
    }
}
