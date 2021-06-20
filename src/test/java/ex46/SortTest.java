package ex46;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void sortByValue() {
        var map = new HashMap<>(Map.of("Henry", 3, "Prince", 1, "The", 2));
        var expected = new LinkedHashMap<String, Integer>();
        expected.put("Henry", 3);
        expected.put("The", 2);
        expected.put("Prince", 1);

        var expectedOrder = new ArrayList<>(expected.keySet());
        var mapOrder = new ArrayList<>(Sort.sortByValue(map).keySet());

        assertArrayEquals(expectedOrder.toArray(), mapOrder.toArray());
    }
}