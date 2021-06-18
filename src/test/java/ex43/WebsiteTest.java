/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {

    @Test
    @DisplayName("add folder")
    void addFolder() {
        var website = new Website("Prince Life", "Henry The Prince", new HashMap<>());
        website.addFolder(FolderType.JS, "js");
        website.addFolder(FolderType.CSS, "css");

        var expected = new HashMap<>(Map.of(
                FolderType.JS, "js",
                FolderType.CSS, "css"
        ));

        var actual = website.getAdditionalFolders();

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(FolderType.values()[i]), actual.get(FolderType.values()[i]));

    }

    @Test
    @DisplayName("create website object")
    void createWebsiteObject() {
        var website = new Website("PrinceLife", "Henry The Prince", new HashMap<>(Map.of(
                FolderType.JS, "js",
                FolderType.CSS, "css"
        )));

        var expected = new HashMap<>(Map.of(
                FolderType.JS, "js",
                FolderType.CSS, "css"
        ));

        var actual = website.getAdditionalFolders();

        assertEquals("PrinceLife", website.getWebsiteName());
        assertEquals("Henry The Prince", website.getAuthor());

        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(FolderType.values()[i]), actual.get(FolderType.values()[i]));
    }
}