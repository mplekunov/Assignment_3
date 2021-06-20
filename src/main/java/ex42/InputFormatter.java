/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputFormatter {
    private InputFormatter() {}

    public static List<Employee> convertStringToEmployee(String strToConvert)
            throws IndexOutOfBoundsException {

        return Arrays.stream(strToConvert.split("\n")).map(o -> {
            List<String> employeeProperties = Arrays.stream(o.split(",")).map(String::toString).collect(Collectors.toList());

            if (employeeProperties.size() != 3)
                throw new IndexOutOfBoundsException();

            return new Employee(employeeProperties.get(1), employeeProperties.get(0), Double.parseDouble(employeeProperties.get(2)));
        }).collect(Collectors.toList());
    }
}
