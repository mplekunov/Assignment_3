package ex44;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOut implements Output {
    private final BufferedWriter bWriter;

    public FileOut(String relativePath, String fileName) throws IOException {
        this.bWriter = new BufferedWriter(new FileWriter(relativePath + fileName));
    }

    public void close() throws IOException {
        bWriter.close();
    }

    @Override
    public void writeLine(String input) throws IOException {
        bWriter.write(input);
    }
}
