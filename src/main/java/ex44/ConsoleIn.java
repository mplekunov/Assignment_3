package ex44;

import java.util.Scanner;

public class ConsoleIn {
    private final Scanner scanner;

    public ConsoleIn() {
        this.scanner = new Scanner(System.in);
    }

    public void close() {
        this.scanner.close();
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
