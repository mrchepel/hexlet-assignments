package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        var contents = car.serialize();
        Files.write(path, contents.getBytes(), StandardOpenOption.CREATE);
    }

    public static Car extract(Path path) throws IOException {
        return Car.deserialize(Files.readString(path));
    }
}
// END
