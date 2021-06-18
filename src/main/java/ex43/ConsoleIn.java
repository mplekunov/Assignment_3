/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.util.Scanner;

public class ConsoleIn implements In{
    private final static Scanner scanner = new Scanner(System.in);

    public ConsoleIn() {}

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
