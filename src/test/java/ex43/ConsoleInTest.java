/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInTest {
    private static final InputStream defIn = System.in;
    @AfterEach
    void tearDown() {
        System.setIn(defIn);
    }

    @Test
    @DisplayName("reads input from console")
    void readLine() {
        System.setIn(new ByteArrayInputStream(("Test Input").getBytes()));
        ConsoleIn cin = new ConsoleIn();

        assertEquals("Test Input", cin.readLine());
    }
}