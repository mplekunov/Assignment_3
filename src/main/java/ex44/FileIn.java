package ex44;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIn implements Input {
    private final Scanner scanner;

    public FileIn(String relativePath, String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new File(relativePath + fileName));
    }

    public void close() {
        scanner.close();
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    public String readAllLines() {
        StringBuilder sBuilder = new StringBuilder();

        while (scanner.hasNextLine())
            sBuilder.append(scanner.nextLine());

        return sBuilder.toString();
    }
}
