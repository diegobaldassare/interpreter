package interpreter.interpreter;

import java.util.Optional;

public interface Memory<String, Value> {

    public void save(String identifier, Value value);
    public Optional<Value> findById(String identifier);
}
