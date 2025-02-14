package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        var storage = map.toMap();
        storage.forEach((key, value) -> {
            map.unset(key);
            map.set(value, key);
        });
    }
}
// END
