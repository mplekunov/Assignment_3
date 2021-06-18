package ex44;

import com.google.gson.reflect.TypeToken;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ProductDatabase {
    private final String dbFileName;
    private final String relativePath;
    private final List<Product> products;

    public ProductDatabase(String relativePath, String dbFileName) throws IOException {
        this.relativePath = relativePath.concat("\\");
        this.dbFileName = dbFileName;
        this.products = downloadObjectFromDb();
    }

    public Product findProduct(String name) {
        return products.stream().filter(o -> o.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void addProduct(Product product) throws IOException {
        if(products.stream().anyMatch(o -> o.getName().equals(product.getName())))
            throw new KeyAlreadyExistsException(String.format("Product %s is already in the database", product.getName()));

        uploadObjectToDb(product);
    }

    private void uploadObjectToDb(Product product)
            throws IOException {
        var file = new FileOut(relativePath, dbFileName);

        products.add(product);

        Type token = new TypeToken<Database<Product>>(){}.getType();
        var serializer = new JsonSerializer<Product>(token);

        var output = serializer.serialize(products);

        file.writeLine(output);

        file.close();
    }

    private List<Product> downloadObjectFromDb()
            throws IOException{
        var file = new FileIn(relativePath, dbFileName);

        var output = file.readAllLines();

        file.close();

        Type token = new TypeToken<Database<Product>>(){}.getType();
        var deserializer = new JsonDeserializer<Product>(token);

        return deserializer.deserialize(output);
    }
}
