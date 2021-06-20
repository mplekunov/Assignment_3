/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex45;

import org.javatuples.Pair;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextManager {
    private String text;

    public TextManager(String text) {
        this.text = text;
    }

    public int replaceAll(String match, String replacement) {
        Pattern p = Pattern.compile("(\\b"+match+")(?=([a-z]{0,2}(([\"\']\\s)|(\\s)|([.,:;!?]))))");
        Matcher m = p.matcher(text);

        if (m.find()) {
            if (replacement.equals(""))
                text = text.replaceFirst("(\\b"+match+"\\s)", replacement);
            else
                text = text.replaceFirst(p.pattern(), replacement);

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
