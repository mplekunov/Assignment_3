/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex45;

import org.javatuples.Pair;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Pattern {
    private Pattern() {}

    public static List<Pair<String, String>> convert(String pattern) {
        return Arrays.stream(pattern.split("\n"))
                .map(o -> new Pair<>(o.substring(0, o.indexOf(",")), o.substring(o.indexOf(",") + 1)))
                    .collect(Collectors.toList());
    }
}
