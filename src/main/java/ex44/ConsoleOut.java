/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

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
