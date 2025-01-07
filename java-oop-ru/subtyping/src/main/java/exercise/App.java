package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> temp = storage.toMap();
        storage.toMap().keySet().forEach(storage::unset);
        temp.forEach((key, value) -> {
            storage.set(value, key);
        });
    }
}
// END
