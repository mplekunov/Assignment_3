/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileIn fileIn = new FileIn("src\\main\\java\\ex42\\exercise42_input.txt");
        FileOut fileOut = new FileOut("src\\main\\java\\ex42\\output.txt");

        String input;
        List<Employee> employees = new ArrayList<>();

        while ((input = fileIn.readLine()) != null) {
            Employee employee = InputFormatter.convertStringToEmployee(input);
            employees.add(employee);
        }

        List<Employee> employeesSortedBySalary = Sort.sortEmployeesByCollection(employees);

        fileOut.writeLine(OutputFormatter.convertEmployeeToString(employeesSortedBySalary));
        fileOut.close();
    }
}
