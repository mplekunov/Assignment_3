package ex41;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputNameTest {

    @Test
    @DisplayName("File format is correct")
    void write() throws IOException {
        List<Name> nameCollection = new ArrayList<>(List.of(
                new Name("Jim", "Johnson"),
                new Name("Chris", "Jones"),
                new Name("Aaron", "Jones"),
                new Name("Mai", "Ling")));

        NameSorter nameSorter = new NameSorter(nameCollection);
        List<Name> actualSorted = nameSorter.sort();

        final File expected = new File("src\\test\\java\\ex41\\expected.txt");
        final File actual = new File("src\\test\\java\\ex41\\actual.txt");

        OutputName outputName = new OutputName(actualSorted, "src\\test\\java\\ex41\\actual.txt");
        outputName.write();

        BufferedReader brExpected = new BufferedReader(new FileReader(expected));
        BufferedReader brActual = new BufferedReader(new FileReader(actual));

        String ex_str;
        while((ex_str = brExpected.readLine()) != null)
            assertEquals(ex_str, brActual.readLine());
    }
}