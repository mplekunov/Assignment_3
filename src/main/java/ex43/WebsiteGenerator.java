/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex43;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class WebsiteGenerator {
    private final Website website;
    private String relativePath;

    public WebsiteGenerator(Website website, String relativePath) {
        this.website = website;
        this.relativePath = relativePath;
    }

    public String generateWebsite() throws IOException {
        var sBuilder = new StringBuilder();

        sBuilder.append(generateFolder(website.getWebsiteName()));
        relativePath = relativePath.concat(website.getWebsiteName()).concat("\\");

        website.getAdditionalFolders().forEach(((folderType, s) -> {
            try {
                sBuilder.append(generateFolder(s));
            } catch (FileAlreadyExistsException e) {
                e.printStackTrace();
            }
        }));

        try {
           sBuilder.append(generateIndexFile());
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        }

        return sBuilder.toString();
    }

    private String generateFolder(String folderName) throws FileAlreadyExistsException {
        var fileManager = new FileManager(relativePath);
        return String.valueOf(fileManager.createFolder(folderName));
    }

    private String generateIndexFile() throws IOException {
        var fileOut = new File(relativePath, "index.html");

        fileOut.writeLine(String.format(
                """
                <html>
                    <head>
                        <title>%s</title>
                        <meta name="author" content="%s">
                    </head>
                </html>""", website.getWebsiteName(), website.getAuthor()));

        return String.format("Created %s\n", (relativePath + "index.html"));
    }

}
