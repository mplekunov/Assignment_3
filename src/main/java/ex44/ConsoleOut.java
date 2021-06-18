package ex44;

import java.io.PrintStream;

public class ConsoleOut {
    private final PrintStream printStream;

    public ConsoleOut() {
        this.printStream = System.out;
    }

    public void writeLine(String input) {
        printStream.print(input);
    }
}
