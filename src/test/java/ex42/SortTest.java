/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    @DisplayName("Sorts Employees by Salary, From Highest to Lowest")
    void sortEmployeesByCollection() {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Johnson","Jim", 56500),
                new Employee("Ling", "Mai",55900),
                new Employee("Jones", "Aaron", 46000)
        ));

        List<Employee> expected = new ArrayList<>(List.of(
                new Employee("Johnson","Jim", 56500),
                new Employee("Ling", "Mai",55900),
                new Employee("Jones", "Aaron", 46000)
        ));

        List<Employee> actual = Sort.sortEmployeesByCollection(employees);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getSalary(), actual.get(i).getSalary());
            assertEquals(expected.get(i).getFirstName(), actual.get(i).getFirstName());
            assertEquals(expected.get(i).getLastName(), actual.get(i).getLastName());
        }
    }
}