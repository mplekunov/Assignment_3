/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex46;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextManager {
    private final String text;

    public TextManager(String text) {
        this.text = text;
    }

    public HashMap<String, Integer> countWords() {
        var words = new HashMap<String, Integer>();
        Pattern p = Pattern.compile("([a-zA-Z]+)");

        Arrays.stream(text.split("\\s")).forEach(o -> {
            Matcher m = p.matcher(o);
            if (m.find())
                words.merge(m.group(0), 1, Integer::sum);
        });

        return words;
    }
}
