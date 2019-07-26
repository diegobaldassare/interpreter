package interpreter.interpreter;

import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
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
        expected.saveOrUpdate("variable", new NumberValue(0));
        interpreter.interpret("let variable: number;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test002_should_assign_a_value_to_a_variable() {
        test001_should_declare_a_variable();
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable", new NumberValue(5));
        interpreter.interpret("variable = 5;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test003_should_print_a_value() {
        Terminal expected = new TerminalHistory();
        expected.print("2");
        interpreter.interpret("print(2);");
        assertEquals(expected, actualTerminal);
    }

    @Test
    public void test004_should_declare_and_assign_a_value() {
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("var4", new NumberValue(5));
        interpreter.interpret("let var4: number = 5;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test005_should_declare_and_assign_an_expression() {
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("var5", new NumberValue(9));
        interpreter.interpret("let var5: number = 2 * 5 - 1;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test006_should_override_a_value_to_a_variable() {
        Memory<String, Value> expected = new MemoryImpl();
        interpreter.interpret("let var6: string;");

        expected.saveOrUpdate("var6", new StringValue("test"));
        interpreter.interpret("var6 = \"test\";");
        assertEquals(expected, actualMemory);

        expected.saveOrUpdate("var6", new StringValue("update"));
        interpreter.interpret("var6 = \"update\";");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test007_should_use_the_value_of_a_variable() {
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(5));
        interpreter.interpret("variable1 = 5;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test008_should_increment_the_value_of_a_variable() {
        test001_should_declare_a_variable();
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(5));
        interpreter.interpret("variable1 = 5;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test009_should_print_a_variable() {
        test001_should_declare_a_variable();
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(5));
        interpreter.interpret("variable1 = 5;");
        assertEquals(expected, actualMemory);
    }

    @Test
    public void test010_should_print_an_expression() {
        test001_should_declare_a_variable();
        Memory<String, Value> expected = new MemoryImpl();
        expected.saveOrUpdate("variable1", new NumberValue(5));
        interpreter.interpret("variable1 = 5;");
        assertEquals(expected, actualMemory);
    }
}