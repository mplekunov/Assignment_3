/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private static final String path = Paths.get("").toAbsolutePath().toString().concat("\\src\\test\\java\\ex43\\");
    private static final String name = "Test";

    @AfterEach
    void tearDown() {
        new File(path.concat(name)).delete();
    }

    @Test
    @DisplayName("creates folder at specific location")
    void createFolder() throws FileAlreadyExistsException {
        FileManager fileManager = new FileManager(path);
        fileManager.createFolder(name);

        assertTrue(new File(path.concat(name)).exists());
    }

    @Test
    @DisplayName("creates file at specific location")
    void createFile() throws IOException {
        FileManager fileManager = new FileManager(path);
        fileManager.createFile(name);

        assertTrue(new File(path.concat(name)).exists());
    }
}