package ex44;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public final class JsonDeserializer<T> { ;
    private Database<T> db;
    private final Type token;

    public JsonDeserializer(Type token) {
        db = new Database<>();
        this.token = token;
    }

    public List<T> deserialize(String strToParse) {
        db = new Gson().fromJson(strToParse, token);
        return db.getProducts();
    }
}
