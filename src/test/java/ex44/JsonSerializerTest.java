package ex44;

import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {

    @Test
    @DisplayName("serializes product collection into string")
    void serialize() {
        var serializer = new JsonSerializer<Product>(new TypeToken<Database<Product>>(){}.getType());

        var output = serializer.serialize(List.of(new Product("Prince Henry", 5, 15), new Product("Did Nothing Wrong", 15, 5)));

        assertEquals("""
                {
                  "products": [
                    {
                      "name": "Prince Henry",
                      "price": 5.0,
                      "quantity": 15
                    },
                    {
                      "name": "Did Nothing Wrong",
                      "price": 15.0,
                      "quantity": 5
                    }
                  ]
                }""", output);
    }
}