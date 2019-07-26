package interpreter.interpreter;

import interpreter.node.value.NumberValue;
import interpreter.node.value.Value;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static junit.framework.TestCase.assertEquals;

//Running test cases in order of method names in ascending order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterpreterTest {

    private Interpreter interpreter;
    private Memory<String, Value> actualMemory;
    private Terminal actualTerminal;

    @Before
    public void setUp() {
        actualMemory = new MemoryImpl();
        actualTerminal = new TerminalHistory();
        interpreter = new InterpreterImpl(actualMemory, actualTerminal);
    }

    @Test
    public void test001_should_declare_a_variable() {
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(0));
        interpreter.interpret("let variable1: number;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test002_should_assign_an_expression_to_a_variable() {
        test001_should_declare_a_variable();
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(9));
        interpreter.interpret("variable1 = 2 * 5 - 1;");
        assertEquals(expected, actualMemory);
    }
//
//    @Test
//    public void test003_should_print_a_value() {
//        Terminal expected = new TerminalHistory();
//        expected.print("2");
//        interpreter.interpret("print(2);");
//        assertEquals(expected, actualTerminal);
//    }

    @Test
    public void test004_should_declare_and_assign_an_expression() {
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable2", new NumberValue(5));
        interpreter.interpret("let variable2: number = 5;");
        assertEquals(expected, actualMemory);
    }

//    @Test
//    public void test004() {
//        interpreter.interpret("let var2: number;");
//        interpreter.interpret("var2 = var1 - 5 * (2 - 3);");
//    }
//
//    @Test
//    public void test005() {
//        interpreter.interpret("print(var2 + 1);");
//    }
//
//    @Test
//    public void test006() {
//        interpreter.interpret("print(var1);");
//    }
//
//    @Test
//    public void test007() {
//        interpreter.interpret("let var3: string;");
//    }
//
//    @Test
//    public void test008() {
//        interpreter.interpret("print(2);");
//    }
}