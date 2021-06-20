/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;

public final class OutputFormatter {
    private OutputFormatter() {}

    public static String convertEmployeeToString(List<Employee> employees) {
        int firstNameLength = employees.stream().map(o -> o.getFirstName().length()).max(Comparator.comparing(Integer::intValue)).get() + 1;
        int lastNameLength = employees.stream().map(o -> o.getLastName().length()).max(Comparator.comparing(Integer::intValue)).get() + 1;
        int salaryLength = employees.stream().map(o -> String.valueOf(o.getSalary()).length()).max(Comparator.comparing(Integer::intValue)).get() + 1;

        var sBuilder = new StringBuilder();

        sBuilder.append(String.format("%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryLength + "s\n", "Last", "First", "Salary"));

        employees.forEach(o ->
            sBuilder.append(String.format("%-" + lastNameLength + "s%-" + firstNameLength + "s%-" + salaryLength + "s\n",
                    o.getLastName(), o.getFirstName(), NumberFormat.getCurrencyInstance().format(o.getSalary())))
        );

        return sBuilder.toString();
    }
}
