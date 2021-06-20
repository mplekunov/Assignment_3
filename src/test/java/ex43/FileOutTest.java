/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileOutTest {
    private static final String path = Paths.get("").toAbsolutePath().toString().concat("\\src\\test\\java\\ex43\\");
    private static final String name = "Test";

    @AfterEach
    void tearDown() {
        new File(path.concat(name)).delete();
    }

    @Test
    @DisplayName("writes into file")
    void writeLine() throws IOException {
        File file = new File(path + name);
        file.createNewFile();

        ex43.File fileOut = new ex43.File(path, name);
        fileOut.writeLine("test");

        BufferedReader bReader = new BufferedReader(new FileReader(path + name));
        assertEquals("test", bReader.readLine());
        bReader.close();
    }

}