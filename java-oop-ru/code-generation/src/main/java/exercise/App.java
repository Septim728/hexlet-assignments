package exercise;

import lombok.SneakyThrows;

import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    @SneakyThrows
    public static void save(Path filePath, Car instance) {
        String jsonRepresentation = instance.serialize();
        Files.writeString(filePath, jsonRepresentation, StandardOpenOption.WRITE);

    }

    @SneakyThrows
    public static Car extract(Path filePath) throws Exception {
        String jsonRepresentation = Files.readString(filePath);
        Car instance = Car.deserialize(jsonRepresentation);
        return instance;
    }
}
// END
