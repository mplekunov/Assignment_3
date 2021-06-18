package ex44;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        var productDatabase = new ProductDatabase(Paths.get("").toAbsolutePath().toString().concat("\\src\\main\\java\\ex44"), "exercise44_input.json");
        var cin = new ConsoleIn();
        var cout = new ConsoleOut();

        Product product;
        while (true) {
            cout.writeLine("What is the product name? ");
            var input = cin.readLine();
            product = productDatabase.findProduct(input);

            if (product == null) {
                cout.writeLine("Do you want to add product? (Y/N): ");
                input = cin.readLine();

                if (input.equalsIgnoreCase("y")) {
                    cout.writeLine("Enter product Name: ");
                    var name = cin.readLine();

                    cout.writeLine("Enter product Price: ");
                    var price = cin.readLine();

                    cout.writeLine("Enter product Quantity: ");
                    var quantity = cin.readLine();

                    productDatabase.addProduct(new Product(name, Double.parseDouble(price), Integer.parseInt(quantity)));
                    break;
                }
            } else {
                cout.writeLine(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", product.getName(), product.getPrice(), product.getQuantity()));
                break;
            }
        }

    }
}
