/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.Scanner;

public class ConsoleInput implements Input<String> {
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Default ConsoleInput Constructor
     */
    public ConsoleInput() {}

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
