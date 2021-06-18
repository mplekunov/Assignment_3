package ex44;

import java.util.Scanner;

public class ConsoleIn implements Input{
    private final Scanner scanner;

    public ConsoleIn() {
        this.scanner = new Scanner(System.in);
    }

    public void close() {
        this.scanner.close();
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
