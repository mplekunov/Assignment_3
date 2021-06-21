/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        var cin = new ConsoleIn();
        var cout = new ConsoleOut();

        cout.writeLine("Site name: ");
        String websiteName = cin.readLine();

        cout.writeLine("Author: ");
        String author = cin.readLine();

        cout.writeLine("Do you want a folder for JavaScript? ");
        String isJS = cin.readLine();

        cout.writeLine("Do you want a folder for CSS? ");
        String isCSS = cin.readLine();

        var folders = new HashMap<FolderType, String>();

        if (isJS.equalsIgnoreCase("y"))
            folders.put(FolderType.JS, "js");
        if (isCSS.equalsIgnoreCase("y"))
            folders.put(FolderType.CSS, "css");

        var website = new Website(websiteName, author, folders);

        var websiteGenerator = new WebsiteGenerator(website, Paths.get("").toAbsolutePath().toString().concat("\\resources\\main\\ex43\\"));

        cout.writeLine(websiteGenerator.generateWebsite());
    }
}
