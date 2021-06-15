/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileInTest {

    @Test
    @DisplayName("readLine can read Input from the File")
    void readLine() throws IOException {
        FileIn in = new FileIn("src\\test\\java\\ex42\\readLine.txt");

        assertEquals("test line", in.readLine());

        in.close();
    }
}