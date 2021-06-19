package ex45;

import org.javatuples.Pair;
import java.util.List;

public class TextManager {
    private String text;

    public TextManager(String text) {
        this.text = text;
    }

    public int replaceAll(String match, String replacement) {
        if (text.contains(match)) {
            text = text.replaceFirst(match, replacement);
            return 1 + replaceAll(match, replacement);
        }

        return 0;
    }

    public int replaceAll(List<Pair<String, String>> matcher) {
        var wrapper = new Object() {int counter = 0;};
        matcher.forEach(o -> wrapper.counter += replaceAll(o.getValue0(), o.getValue1()));

        return wrapper.counter;
    }

    public String getText() {
        return text;
    }
}
