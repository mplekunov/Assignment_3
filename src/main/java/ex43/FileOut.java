/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOut implements Out{
    private final BufferedWriter bWriter;

    public FileOut(String relativePath, String fileName) throws IOException {
        this.bWriter = new BufferedWriter(new FileWriter(relativePath + fileName));
    }

    @Override
    public void writeLine(String input) throws IOException {
        bWriter.write(input);
    }

    public void close() throws IOException {
        bWriter.close();
    }
}
