package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> database = new HashMap<>();

    public InMemoryKV(Map<String, String> database) {
        this.database.putAll(database);
    }

    @Override
    public void set(String key, String value) {
        this.database.put(key, value);
    }

    @Override
    public void unset(String key) {
        database.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return database.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(database);
    }
}

// END
