/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.Locale;

public class FileOut implements Out{
    private String fileName;
    private final String path;
    private final FileWriter bWriter;

    public FileOut(String fileName) throws IOException {
        this.fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        this.path = fileName.substring(0, fileName.lastIndexOf("\\") + 1);
        this.bWriter = initWriter();
    }

    private FileWriter initWriter() throws IOException {
        java.io.File file = new java.io.File(path + fileName);

        while (!file.createNewFile()) {
            System.out.printf("File with the name %s already exists. Do you want to choose another output file? (Yes/No): ", fileName);

            Input input = new Input(System.in);

            String answer = input.readLine();

            switch (answer.toLowerCase(Locale.ROOT)) {
                case "yes":
                    System.out.print("Enter new name for the output file (e.g. output.txt): ");
                    fileName = input.readLine();
                    file = new java.io.File(path + fileName);
                    break;
                case "no":
                    break;
                default:
                    System.out.println("System couldn't recognize your answer, please try again");
            }

            if (answer.toLowerCase(Locale.ROOT).equals("no"))
                break;
        }

        if (!file.canWrite())
            throw new NonWritableChannelException();

        return new FileWriter(path + fileName);
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void writeLine(String input) throws IOException {
        bWriter.write(input);
    }

    public void close() throws IOException {bWriter.close();}
}
