/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex45;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var fileIn = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), "exercise45_input.txt");
        var matcher = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), "pattern.txt");

        TextManager textManager = new TextManager(fileIn.readAllLines());

        var cout = new ConsoleOut();
        var cin = new ConsoleIn();

        cout.writeLine("Enter the name of output file (e.g. output.txt): ");
        String outputFileName = cin.readLine();

        File fileOut = new File(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\resources\\ex45\\"), outputFileName);

        int counter = textManager.replaceAll(Pattern.convert(matcher.readAllLines()));

        fileOut.writeLine(textManager.getText());

        System.out.printf(counter == 1 ? "%d match was found" : "%d matches were found", counter);
    }
}
