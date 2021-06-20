/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FileOutTest {
    private final InputStream defIn = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(defIn);
    }

    @Test
    @DisplayName("writeLine can write output in the file")
    void writeLine() throws IOException {
        System.setIn(new ByteArrayInputStream(("no").getBytes())); //ignores FileIn question

        var fileOut = new File("src\\test\\java\\ex42\\", "writeLine.txt");
        var fileIn = new File("src\\test\\java\\ex42\\", "writeLine.txt");

        fileOut.writeLine("Test Line");

        assertEquals("Test Line", fileIn.readAllLines());
    }
}