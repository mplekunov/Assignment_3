package ex43;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {
    private static final String path = Paths.get("").toAbsolutePath().toString().concat("\\src\\test\\java\\ex43\\");
    private static final Website website = new Website("PrinceLife", "Henry The Prince", new HashMap<>(Map.of(FolderType.JS, "js", FolderType.CSS, "css")));

    boolean deleteFiles(File file) {
        var allContents = file.listFiles();

        if (allContents != null)
            Arrays.stream(allContents).forEach(o -> deleteFiles(o));
        return file.delete();
    }

    @AfterEach
    void tearDown() {
        deleteFiles(new File(path + website.getWebsiteName()));
    }

    @Test
    @DisplayName("generates all required folders/files")
    void generateWebsite() throws IOException {
        var websiteGenerator = new WebsiteGenerator(website, path);
        websiteGenerator.generateWebsite();

        assertTrue(new File(path + website.getWebsiteName()).exists());
        assertTrue(new File(path + website.getWebsiteName().concat("\\js")).exists());
        assertTrue(new File(path + website.getWebsiteName().concat("\\css")).exists());
        assertTrue(new File(path + website.getWebsiteName().concat("\\index.html")).exists());
    }

    @Test
    @DisplayName("index.html file has correct structure")
    void testIndexFile() throws IOException {
        var websiteGenerator = new WebsiteGenerator(website, path);
        websiteGenerator.generateWebsite();

        var expected =
                """
                <html>
                    <head>
                        <title>PrinceLife</title>
                        <meta name="author" content="Henry The Prince">
                    </head>
                </html>""";

        var bReader = new BufferedReader(new FileReader(path + website.getWebsiteName().concat("\\index.html")));
        assertEquals(expected, bReader.lines().collect(Collectors.joining("\n")));
        bReader.close();
    }

}