package ex41;

import java.util.Scanner;

public class ConsoleInput implements Input<String> {
    private final static Scanner scanner = new Scanner(System.in);

    public ConsoleInput() {}

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
