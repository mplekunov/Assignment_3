package ex41;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {
    private final InputStream defIS = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(defIS);
    }

    @Test
    @DisplayName("Value from console is read correctly")
    void read() {
        System.setIn(new ByteArrayInputStream(("File Name\n").getBytes()));

        ConsoleInput consoleInput = new ConsoleInput();
        assertEquals("File Name", consoleInput.read());
    }
}