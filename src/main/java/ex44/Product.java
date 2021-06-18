package ex44;

import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (o.getClass() == getClass()) {
            Product product = (Product) o;
            return Objects.equals(name.toLowerCase(), product.getName().toLowerCase()) && Double.compare(price, product.price) == 0 && quantity == product.quantity;
        } else if (o.getClass() == String.class) {
            String input = (String) o;
            return Objects.equals(name.toLowerCase(), input.toLowerCase());
        } else
            return false;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPrice: %.2f\nQuantity: %d\n", name, price, quantity);
    }
}
