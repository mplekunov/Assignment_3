/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("name_1.lastName > name_2.lastName")
    void compareTo_Greater_Than() {
        Name name_1 = new Name("A", "B");
        Name name_2 = new Name("C", "D");

        assertTrue(name_2.compareTo(name_1) > 0);
    }

    @Test
    @DisplayName("name_1.lastName < name_1.lastName")
    void compareTo_Less_Than() {
        Name name_1 = new Name ("C", "D");
        Name name_2 = new Name("A", "B");

        assertTrue(name_2.compareTo(name_1) < 0);
    }

    @Test
    @DisplayName("name_1.lastName == name_1.lastName")
    void compareTo_Equals_To() {
        Name name_1 = new Name ("A", "B");
        Name name_2 = new Name("A", "B");

        assertEquals(0, name_2.compareTo(name_1));
    }
}