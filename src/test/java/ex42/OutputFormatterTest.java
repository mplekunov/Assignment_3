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

class OutputFormatterTest {

    @Test
    @DisplayName("Returns Employee object in the string format")
    void convertEmployeeToString() {
        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Employee("Prince", "Henry", 35000),
                new Employee("Did", "Nothing", 34000),
                new Employee("Wrong", "!", 33000)
        ));

        String actual = OutputFormatter.convertEmployeeToString(employees);
        String expected = """
                Last    First  Salary \s
                Henry   Prince $35,000.00
                Nothing Did    $34,000.00
                !       Wrong  $33,000.00
                """;

        assertEquals(expected, actual);
    }
}