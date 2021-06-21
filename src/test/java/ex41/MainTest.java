/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final InputStream defIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(defIn);
    }

    @Test
    @DisplayName("Correctly converts from console to Collection of Name objects")
    void readNames() {
        List<Name> expected = new ArrayList<>(List.of(
                new Name("Ling", "Mai"),
                new Name("Johnson", "Jim"),
                new Name("Zarnecki", "Sabrina")
        ));

        System.setIn(new ByteArrayInputStream(("Mai, Ling\nJim, Johnson\nSabrina, Zarnecki\ndone\n").getBytes()));

        List<Name> actual = Main.readNames();

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getFirstName(), expected.get(i).getFirstName());
            assertEquals(actual.get(i).getLastName(), expected.get(i).getLastName());
        }
    }
}