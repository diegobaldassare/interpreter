package interpreter.interpreter;

public class TerminalSystem implements Terminal {

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
