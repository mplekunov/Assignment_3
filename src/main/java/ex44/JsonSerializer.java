package ex44;

import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;

public final class JsonSerializer<T> {
    private final Type token;

    public JsonSerializer(Type token) {
        this.token = token;
    }

    public String serialize(List<T> objects) {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(new Database<>(objects, token), token);
    }
}
