package interpreter.interpreter;

import interpreter.node.value.NumberValue;
import interpreter.node.value.StringValue;
import interpreter.node.value.Value;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

//Running test cases in order of method names in ascending order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterpreterTest {

    private Interpreter interpreter;
    private Memory<String, Value> memory;
    private Terminal actualTerminal;

    @Before
    public void setUp() {
        memory = MemoryImpl.getInstance();
        actualTerminal = new TerminalHistory();
        interpreter = new InterpreterImpl(memory, actualTerminal);
    }

    @Test
    public void test001_should_declare_a_variable() {
        interpreter.interpret("let variable: number;");
        assert(memory.findById("variable").isPresent());
    }

    @Test
    public void test002_should_assign_a_value_to_a_variable() {
        interpreter.interpret("variable = 5;");
        assertEquals(memory.findById("variable"), Optional.of(new NumberValue(5)));
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
        interpreter.interpret("let var4: number = 5;");
        assertEquals(memory.findById("var4"), Optional.of(new NumberValue(5)));
    }

    @Test
    public void test005_should_declare_and_assign_a_simple_expression() {
        interpreter.interpret("let var5: number = 2 + 1;");
        assertEquals(memory.findById("var5"), Optional.of(new NumberValue(3)));
    }

    @Test
    public void test006_should_override_a_string_value_to_a_variable() {
        interpreter.interpret("let var6: string;");

        interpreter.interpret("var6 = \"test\";");
        assertEquals(memory.findById("var6"), Optional.of(new StringValue("test")));

        interpreter.interpret("var6 = \"update\";");
        assertEquals(memory.findById("var6"), Optional.of(new StringValue("update")));
    }

    @Test
    public void test007_should_calculate_a_subtraction() {
        interpreter.interpret("let var7: number = 2 * 5 - 1;");
        assertEquals(memory.findById("var7"), Optional.of(new NumberValue(9)));
    }

    @Test
    public void test008_should_calculate_a_division() {
        interpreter.interpret("let var8: number = 0 / 2;");
        assertEquals(memory.findById("var8"), Optional.of(new NumberValue(0)));
    }

    @Test
    public void test009_should_calculate_an_expression() {
        interpreter.interpret("let var9: number = 5 + 4 / 2 * 3 - 1;");
        assertEquals(memory.findById("var9"), Optional.of(new NumberValue(10)));
    }


    @Test
    public void test010_should_use_the_value_of_a_variable() {
        interpreter.interpret("let a: number = 2;");
        interpreter.interpret("let b: number = a + 2;");
        assertEquals(memory.findById("a"), Optional.of(new NumberValue(2)));
        assertEquals(memory.findById("b"), Optional.of(new NumberValue(4)));
    }
//
//    @Test
//    public void test008_should_increment_the_value_of_a_variable() {
//        test001_should_declare_a_variable();
//        Memory<String, Value> expected = new MemoryImpl();
//        expected.saveOrUpdate("variable1", new NumberValue(5));
//        interpreter.interpret("variable1 = 5;");
//        assertEquals(expected, memory);
//    }
//
//    @Test
//    public void test009_should_print_a_variable() {
//        test001_should_declare_a_variable();
//        Memory<String, Value> expected = new MemoryImpl();
//        expected.saveOrUpdate("variable1", new NumberValue(5));
//        interpreter.interpret("variable1 = 5;");
//        assertEquals(expected, memory);
//    }
//
//    @Test
//    public void test010_should_print_an_expression() {
//        test001_should_declare_a_variable();
//        Memory<String, Value> expected = new MemoryImpl();
//        expected.saveOrUpdate("variable1", new NumberValue(5));
//        interpreter.interpret("variable1 = 5;");
//        assertEquals(expected, memory);
//    }
}