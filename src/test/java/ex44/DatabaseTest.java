/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex44;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


import static org.mockito.Mockito.*;
class DatabaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"Test", "Doodad", "doodad"})
    @DisplayName("finds object in database")
    void findObject(String objectName) throws IOException {
        var mockFile = mock(File.class);

        when(mockFile.readAllLines()).thenReturn("""
                {
                  "products": [
                    {
                      "name": "Widget",
                      "price": 25.0,
                      "quantity": 5
                    },
                    {
                      "name": "Thing",
                      "price": 15.0,
                      "quantity": 5
                    },
                    {
                      "name": "Doodad",
                      "price": 5.0,
                      "quantity": 10
                    }
                  ]
                }""");

        var db = (Database<Product>) mock(new Database(mockFile, new TypeToken<Database<Product>>(){}.getType()).getClass());

        db.findObject(objectName);
        verify(db).findObject(objectName);
    }

    @ParameterizedTest
    @MethodSource("getProductStream")
    @DisplayName("adds object to database")
    void addObject(Product product) throws IOException {
        var db = (Database<Product>) mock(Database.class);
        when(db.getDbObjects()).thenReturn(List.of(new Product("Test", 13,14)));

        db.addObject(product);
        verify(db).addObject(product);
    }

    static Stream<Product> getProductStream() {
        return Stream.of(new Product("Prince Henry", 1, 123), new Product("Did Nothing", 2, 345), new Product("Wrong", 3, 432));
    }
}