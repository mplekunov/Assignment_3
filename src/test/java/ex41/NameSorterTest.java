/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameSorterTest {

    @Test
    @DisplayName("Sorts Names by last name in alphabetical order")
    void sort() {
        List<Name> nameCollection = new ArrayList<>(List.of(new Name("Ling", "Mai"), new Name("Johnson", "Jim"), new Name("Zarnecki", "Sabrina")));
        List<Name> expected = new ArrayList<>(List.of(new Name("Johnson", "Jim"), new Name("Ling", "Mai"), new Name("Zarnecki", "Sabrina")));

        NameSorter nameSorter = new NameSorter(nameCollection);
        List<Name> actual = nameSorter.sort();

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(0, actual.get(0).compareTo(expected.get(0)));
        }
    }
}