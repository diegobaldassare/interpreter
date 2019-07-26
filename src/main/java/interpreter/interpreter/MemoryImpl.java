package interpreter.interpreter;

import interpreter.node.value.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryImpl implements Memory<String, Value> {

    private Map<String, Value> map = new HashMap<>();

    @Override
    public void saveOrUpdate(String identifier, Value value) {
        map.put(identifier, value);
    }

    @Override
    public Optional<Value> findById(String identifier) {
        if (!map.containsKey(identifier))
            return Optional.empty();
        return Optional.of(map.get(identifier));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryImpl memory = (MemoryImpl) o;
        return map.equals(memory.map);
    }

    @Override
    public String toString() {
        return "MemoryImpl{" +
                "map=" + map +
                '}';
    }
}
