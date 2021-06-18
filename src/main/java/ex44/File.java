package ex44;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class File {
    private final String fileName;
    private final String relativePath;

    public File(String relativePath, String fileName) {
        this.relativePath = relativePath;
        this.fileName = fileName;
    }

    public void writeLine(String input) throws IOException {
        Files.writeString(Paths.get(relativePath + fileName), input);
    }

    public String readAllLines() throws IOException {
        return Files.readAllLines(Paths.get(relativePath + fileName)).stream().map(String::toString).collect(Collectors.joining());
    }
}
