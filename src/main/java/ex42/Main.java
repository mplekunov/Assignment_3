/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        var fileIn = new File(Paths.get("").toAbsolutePath().toString().concat("\\resources\\ex42\\"), "exercise42_input.txt");
        var fileOut = new File(Paths.get("").toAbsolutePath().toString().concat("\\resources\\ex42\\"), "output.txt");

        String input = fileIn.readAllLines();

        List<Employee> employees = InputFormatter.convertStringToEmployee(input);

        List<Employee> employeesSortedBySalary = Sort.sortEmployeesByCollection(employees);

        fileOut.writeLine(OutputFormatter.convertEmployeeToString(employeesSortedBySalary));
    }
}
