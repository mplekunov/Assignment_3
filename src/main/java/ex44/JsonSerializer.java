package ex44;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

public final class JsonSerializer<T> {
    private final Type token;

    public JsonSerializer(Type token) {
        this.token = token;
    };

    public String serialize(List<T> products) {
        Gson gBuilder = new GsonBuilder().setPrettyPrinting().create();
        return gBuilder.toJson(new Database<T>(products), token);
    }
}
