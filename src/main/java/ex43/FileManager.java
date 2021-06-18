/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class FileManager {
    private final String relativePath;

    public FileManager(String relativePath) {
        this.relativePath = relativePath;
    }

    public String createFolder(String folderName)
            throws FileAlreadyExistsException {
        File file = new File(relativePath + folderName);

        if (file.exists())
            throw new FileAlreadyExistsException(String.format("Folder %s already exists in the %s", folderName, relativePath));

        if (file.mkdir())
            return String.format("Created %s\n", (relativePath + folderName));
        else
            return String.format("Couldn't create folder %s in %s\n", folderName, relativePath);
    }

    public String createFile(String fileName)
            throws IOException {
        File file = new File(relativePath + fileName);

        if (file.exists())
            throw new FileAlreadyExistsException(String.format("File %s already exists in the %s", fileName, relativePath));

        if (file.createNewFile())
            return String.format("Created %s\n", (relativePath + fileName));
        else
            return String.format("Couldn't create file %s in %s\n", fileName, relativePath);
    }

}
