/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex44;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("tests \"equals\" on Product Objects")
    void testEquals_Product_Objects() {
        assertEquals(new Product("Prince Henry", 1, 1), new Product("prince henry", 1, 1));
        assertEquals(new Product("Prince Henry", 2, 1), new Product("Prince Henry", 2, 1));
        assertEquals(new Product("Prince Henry", 1, 2), new Product("Prince Henry", 1, 2));
        assertNotEquals(new Product("Not Prince Henry", 1, 1), new Product("Prince Henry", 1, 1));
    }

    @Test
    @DisplayName("tests \"equals\" on String Objects")
    void testEquals_String_Objects() {
        //.equals is overridden. .equals of Product can evaluate to True if parameter object is a string and this string equals to the name of Product object
        assertFalse(new Product("Prince Henry", 1, 1).equals("Not Prince Henry"));
        assertTrue (new Product("Prince Henry", 1, 1).equals("Prince Henry"));
    }

    @ParameterizedTest
    @MethodSource("getProductCollection")
    @DisplayName("converts product object to string")
    void testToString(Product product) {
        assertEquals(String.format("Name: %s\nPrice: %.2f\nQuantity: %d\n", product.getName(), product.getPrice(), product.getQuantity()), product.toString());
    }

    static Stream<Product> getProductCollection() {
        return Stream.of(new Product("Prince Henry", 1, 2), new Product("Did Nothing", 3, 4), new Product("Wrong", 5, 6));
    }
}