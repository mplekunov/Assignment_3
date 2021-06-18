package ex44;

import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;

public final class JsonDeserializer<T> {
    private Database<T> db;
    private final Type token;

    public JsonDeserializer(Type token) {
        this.db = new Database<>(token);
        this.token = token;
    }

    public List<T> deserialize(String strToParse) {
        var gson = new GsonBuilder().create();
        db = gson.fromJson(strToParse, token);
        return db.getDbObjects();
    }
}
