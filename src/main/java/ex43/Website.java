/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.HashMap;

public class Website {
    private final String websiteName;
    private final String author;
    private final HashMap<FolderType, String> additionalFolders;

    private Website(String websiteName, String author) {
        this.websiteName = websiteName;
        this.author = author;
        this.additionalFolders = new HashMap<>();
    }

    public Website(String websiteName, String author, HashMap<FolderType, String> folders) {
        this(websiteName, author);
        this.additionalFolders.putAll(folders);
    }

    public void addFolder(FolderType folderType, String folderName) {
        if (additionalFolders.containsKey(folderType))
            throw new KeyAlreadyExistsException(String.format("Key %s already exists in collection", folderType.toString()));

        if (additionalFolders.containsValue(folderName))
            throw new KeyAlreadyExistsException(String.format("Folder %s already exists in collection", folderName));

        additionalFolders.put(folderType, folderName);
    }

    public HashMap<FolderType, String> getAdditionalFolders() {
        return additionalFolders;
    }

    public String getAuthor() {
        return author;
    }

    public String getWebsiteName() {
        return websiteName;
    }
}
