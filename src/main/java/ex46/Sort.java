/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex46;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Sort {
    private Sort() {}

    public static LinkedHashMap<String, Integer> sortByValue(Map<String, Integer> collection) {
        return collection.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}