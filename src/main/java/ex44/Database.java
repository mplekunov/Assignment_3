package ex44;

import com.google.gson.annotations.SerializedName;
import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Database<T> {
    @SerializedName("products")
    private List<T> dbObjects;
    private transient File dbFile;
    private final transient Type token;

    public Database(File dbFile, Type token) throws IOException {
        this.dbFile = dbFile;
        this.token = token;

        this.dbObjects = downloadObjectFromDb();
    }

    public Database(Type token){
        this.token = token;
    }

    public Database(List<T> objects, Type token) {
        this.dbObjects = objects;
        this.token = token;
    }

    public T findObject(String name) {
        return dbObjects.stream().filter(o -> o.equals(name)).findFirst().orElse(null);
    }

    public void addObject(T obj) throws IOException {
        if(dbObjects.stream().anyMatch(o -> o.equals(obj)))
            throw new KeyAlreadyExistsException(String.format("Product %s is already in the database", obj));

        uploadObjectToDb(obj);
    }

    private void uploadObjectToDb(T obj)
            throws IOException {

        dbObjects.add(obj);

        var serializer = new JsonSerializer<T>(token);

        var output = serializer.serialize(dbObjects);

        dbFile.writeLine(output);
    }

    private List<T> downloadObjectFromDb()
            throws IOException{

        var output = dbFile.readAllLines();

        var deserializer = new JsonDeserializer<T>(token);

        return deserializer.deserialize(output);
    }

    public List<T> getDbObjects() {
        return dbObjects;
    }
}
