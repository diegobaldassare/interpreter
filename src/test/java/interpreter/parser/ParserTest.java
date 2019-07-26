package interpreter.parser;

import interpreter.lexer.Lexer;
import interpreter.lexer.state.LexerAutomaton;
import interpreter.node.AST;
import org.junit.Before;
import org.junit.Test;

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
        AST expected = ;
        AST actual = parser.parse(lexer.lex("let a: number;"));
    }
}
