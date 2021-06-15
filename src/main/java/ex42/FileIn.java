/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class FileIn implements In {
    private final String fileName;
    private final String path;
    private final BufferedReader bReader;

    public FileIn(String fileName) throws IOException {
        this.fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        this.path = fileName.substring(0, fileName.lastIndexOf("\\") + 1);
        this.bReader = initReader();
    }

    private BufferedReader initReader() throws IOException {
        java.io.File file = new java.io.File(path + fileName);

        if(!file.exists())
            throw new NoSuchFileException(path + fileName);

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

    public void close() throws IOException {bReader.close();}
}
