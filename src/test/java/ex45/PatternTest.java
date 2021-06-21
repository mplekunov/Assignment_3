/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex45;

import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatternTest {

    @Test
    @DisplayName("converts pattern into collection of pairs")
    void convert() {
        var actual = Pattern.convert(
                """
                Prince,Henry
                Did,Nothing
                That,Would
                Be,Wrong""");

        var expected = List.of(
                new Pair<>("Prince", "Henry"),
                new Pair<>("Did", "Nothing"),
                new Pair<>("That", "Would"),
                new Pair<>("Be", "Wrong"));

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}