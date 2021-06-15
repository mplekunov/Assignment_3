/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.io.InputStream;
import java.util.Scanner;

public class Input implements In {
    private static Scanner scanner;

    public Input(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
