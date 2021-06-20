/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    private static final InputStream defIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(defIn);
    }

    @Test
    @DisplayName("Input string from Input Stream corresponds to the expected string")
    void readLine() {
        System.setIn(new ByteArrayInputStream(("Test").getBytes()));
        var input = new ConsoleIn();
        assertEquals("Test", input.readLine());
    }
}