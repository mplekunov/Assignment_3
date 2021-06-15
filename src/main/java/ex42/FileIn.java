package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class FileIn implements In {
    private final String fileName;
    private final BufferedReader bReader;

    public FileIn(String fileName) throws IOException {
        this.fileName = fileName;
        this.bReader = initReader();
    }

    private BufferedReader initReader() throws IOException {
        java.io.File file = new java.io.File(fileName);

        if(!file.exists())
            throw new NoSuchFileException(fileName);

        if (!file.canRead())
            throw new IOException();

        return new BufferedReader(new FileReader(file));
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String readLine() throws IOException {
        return bReader.readLine();
    }
}
