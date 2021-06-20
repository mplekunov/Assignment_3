/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputFormatterTest {

    @Test
    @DisplayName("Returns initialized Employee object")
    void convertStringToEmployee() {
        List<Employee> employee = InputFormatter.convertStringToEmployee("Henry,Prince,1498");

        assertEquals(1498, employee.get(0).getSalary());
        assertEquals("Prince", employee.get(0).getFirstName());
        assertEquals("Henry", employee.get(0).getLastName());
    }
}