package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;
    private Map<String, String> database = new HashMap<String, String>();

    public FileKV(String path, Map<String, String> keyToValue) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(keyToValue));
    }

    @Override
    public void set(String key, String value) {
        var currentMap = toMap();
        currentMap.put(key, value);
        Utils.writeFile(path, Utils.serialize(currentMap));
    }

    @Override
    public void unset(String key) {
        var currentMap = toMap();
        currentMap.remove(key);
        Utils.writeFile(path, Utils.serialize(currentMap));
    }

    @Override
    public String get(String key, String defaultValue) {
        return toMap().getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize(Utils.readFile(path));
    }
}
// END
