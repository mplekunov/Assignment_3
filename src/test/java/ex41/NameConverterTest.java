/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameConverterTest {

    @Test
    @DisplayName("converts string into object")
    void convertToName() {
        String fullName = "Henry, Prince";
        Name name = new Name("Prince", "Henry");

        NameConverter nameConverter = new NameConverter();
        Name actual = nameConverter.convertToName(fullName);

        assertEquals(name.getLastName(), actual.getLastName());
        assertEquals(name.getFirstName(), actual.getFirstName());
    }
}