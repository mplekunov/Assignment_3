package ex45;

import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextManagerTest {

    @ParameterizedTest(name = "{index} => string ''{0}'' was changed to ''{1}''")
    @CsvSource({
            "I don\'t need to test my string., I need to test my string., don\'t, ''",
            "I was forced to write test cases., I wasn\'t forced to write test cases., was, wasn\'t"
    })
    @DisplayName("replaces all occurrences of pair <Bad, Good>. Source is single pair <Bad, Good>")
    void replaceAll_Using_Single_Pair_Instance(String actual, String expected, String match, String replacement) {
        var textManager = new TextManager(actual);

        textManager.replaceAll(match, replacement);

        assertEquals(expected, textManager.getText());
    }

    @ParameterizedTest(name = "{index} => string ''{0}'' was changed to ''{1}''")
    @CsvSource({
            "Prince Henry is bad. He did something wrong!, Prince Henry is good. He did nothing wrong!",
            "Prince Henry is as bad as you., Prince Henry is as good as you."
    })
    @DisplayName("replaces all occurrences of pair <Bad, Good>. Source is collection of pairs")
    void ReplaceAll_Using_Matcher_Collection(String actual, String expected) {
        var textManager = new TextManager(actual);

        textManager.replaceAll(List.of(new Pair<>("bad", "good"), new Pair<>("something", "nothing")));

        assertEquals(expected, textManager.getText());
    }
}