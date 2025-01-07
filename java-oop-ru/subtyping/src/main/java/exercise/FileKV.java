package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path, Map<String, String> initial) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(initial));
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        return Utils.deserialize(content);
    }
}
// END
