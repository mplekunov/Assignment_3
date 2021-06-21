/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var nameSorter = new NameSorter(readNames());

        List<Name> sortedList = nameSorter.sort();

        String fileName = Paths.get("").toAbsolutePath().toString().concat("\\resources\\main\\ex41\\output.txt");

        var outputName = new OutputName(sortedList, fileName);
        outputName.write();
    }

    public static List<Name> readNames() {
        System.out.println("Enter list of name in the format: \"Last Name, First Name\"" +
                           "\nEnter \"done\" when you are done with input");

        var inputName = new NameConverter();
        var consoleInput = new ConsoleIn();
        var nameList = new ArrayList<Name>();
        String input;

        while (true) {
            input = consoleInput.read();

            if (!input.equalsIgnoreCase("done"))
                nameList.add(inputName.convertToName(input));
            else
                break;
        }

        return nameList;
    }
}
