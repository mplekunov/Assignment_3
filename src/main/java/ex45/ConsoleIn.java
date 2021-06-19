package ex45;

import java.util.Scanner;

public class ConsoleIn {
    private final Scanner scanner;

    public ConsoleIn() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
