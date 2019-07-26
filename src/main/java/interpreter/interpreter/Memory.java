package interpreter.interpreter;

import java.util.Optional;

public interface Memory<String, Value> {

    public void saveOrUpdate(String identifier, Value value);
    public Optional<Value> findById(String identifier);
}
