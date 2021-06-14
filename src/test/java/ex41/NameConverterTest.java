package ex41;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameConverterTest {

    @Test
    @DisplayName("")
    void convertToName() {
        String fullName = "Henry, Prince";
        Name name = new Name("Prince", "Henry");

        NameConverter nameConverter = new NameConverter();
        Name actual = nameConverter.convertToName(fullName);

        assertEquals(name.getLastName(), actual.getLastName());
        assertEquals(name.getFirstName(), actual.getFirstName());
    }
}