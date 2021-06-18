/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.io.IOException;

public class ConsoleOut implements Out{
    public ConsoleOut() {}

    @Override
    public void writeLine(String input) throws IOException {
        System.out.print(input);
    }
}
