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
        this.relativePath = relativePath.concat("\\");
    }

    public String generateWebsite() throws IOException {
        StringBuilder sBuilder = new StringBuilder();

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
        FileManager fileManager = new FileManager(relativePath);
        return String.valueOf(fileManager.createFolder(folderName));
    }

    private String generateIndexFile() throws IOException {
        FileOut fileOut = new FileOut(relativePath, "index.html");

        fileOut.writeLine(String.format(
                """
                <html>
                    <head>
                        <title>%s</title>
                        <meta name="author" content="%s">
                    </head>
                </html>""", website.getWebsiteName(), website.getAuthor()));

        fileOut.close();

        return String.format("Created %s\n", (relativePath + "index.html"));
    }

}
