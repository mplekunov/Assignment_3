/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex44;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var productToken = new TypeToken<Database<Product>>(){}.getType();
        var file = new File(Paths.get("").toAbsolutePath().toString().concat("\\resources\\main\\ex44\\"), "exercise44_input.json");

        var productDb = new Database<Product>(file, productToken);

        var cin = new ConsoleIn();
        var cout = new ConsoleOut();

        Product product;

        while (true) {
            cout.writeLine("What is the product name? ");
            String input = cin.readLine();
            product = productDb.findObject(input);

            if (product == null) {
                cout.writeLine("Do you want to add product? (Y/N): ");
                input = cin.readLine();

                if (input.equalsIgnoreCase("y")) {
                    cout.writeLine("Enter product Name: ");
                    String name = cin.readLine();

                    cout.writeLine("Enter product Price: ");
                    String price = cin.readLine();

                    cout.writeLine("Enter product Quantity: ");
                    String quantity = cin.readLine();

                    productDb.addObject(new Product(name, Double.parseDouble(price), Integer.parseInt(quantity)));
                    break;
                }
            } else {
                cout.writeLine(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", product.getName(), product.getPrice(), product.getQuantity()));
                break;
            }
        }

    }
}
