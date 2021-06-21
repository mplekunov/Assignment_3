/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex44;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonDeserializerTest {

    @Test
    @DisplayName("deserializes string into objects")
    void deserialize() {
        var deserializer = new JsonDeserializer<Product>(new TypeToken<Database<Product>>(){}.getType());
        var products = deserializer.deserialize("""
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
                    }
                  ]
                }
                """);

        assertEquals(2, products.size());

        assertEquals(new Product("Widget", 25, 5), products.get(0));
        assertEquals(new Product("Thing", 15, 5), products.get(1));
    }
}