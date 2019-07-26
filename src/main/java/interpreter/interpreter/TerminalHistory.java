package interpreter.interpreter;

import java.util.ArrayList;
import java.util.List;

public class TerminalHistory implements Terminal {

    private List<String> history = new ArrayList<>();

    @Override
    public void print(String output) {
        history.add(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalHistory terminal = (TerminalHistory) o;
        return history.equals(terminal.history);
    }

    @Override
    public String toString() {
        return "TerminalHistory{" +
                "history=" + history +
                '}';
    }
}
