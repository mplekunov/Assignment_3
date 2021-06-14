/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        NameSorter nameSorter = new NameSorter(readNames());
        List<Name> sortedList = nameSorter.sort();

        String fileName = openFile();
        writeNames(sortedList, fileName);
    }

    /**
     * Tries to open file using pre-defined file name. If file already exists, asks
     * @return Name of the file in String format
     * @throws IOException - if problem occurs during writing
     */
    public static String openFile() throws IOException {
        String fileName = "output.txt";
        System.out.printf("Name of the file for output specified by default is %s", fileName);

        File file = new File(fileName);
        String userInput = "";

        while (file.exists()) {
            ConsoleInput consoleInput = new ConsoleInput();
            System.out.printf("File with the name \"%s\" already exists. Do you want to specify another name? (Yes, No) ", fileName);

                userInput = consoleInput.read();

                switch (userInput.toLowerCase(Locale.ROOT)) {
                    case "yes":
                        System.out.print("Enter the name of the output file including extension (e.g. output.txt): ");
                        file = new File(consoleInput.read());
                        break;
                    case "no":
                        break;
                }

            if (userInput.equalsIgnoreCase("no"))
                break;
        }

        if (userInput.equalsIgnoreCase("yes"))
            file.createNewFile();

        return fileName;
    }

    public static List<Name> readNames() {
        System.out.println("Enter list of name in the format: \"Last Name, First Name\"" +
                           "\nEnter \"done\" when you are done with input");

        NameConverter inputName = new NameConverter();
        ConsoleInput consoleInput = new ConsoleInput();
        List<Name> nameList = new ArrayList<>();
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

    public static void writeNames(List<Name> names, String fileName) throws IOException {
        OutputName outputName = new OutputName(names, fileName);
        outputName.write();
    }
}
