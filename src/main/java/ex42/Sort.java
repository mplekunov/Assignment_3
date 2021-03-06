/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Sort {
    private Sort(){}

    public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
    }
}
