/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex46;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        var file = new File(Paths.get("").toAbsolutePath().toString().concat("\\resources\\ex46\\"), "exercise46_input.txt");

        var textManager = new TextManager(file.readAllLines());

        LinkedHashMap<String, Integer> words = Sort.sortByValue(textManager.countWords());

        var cout = new ConsoleOut();

        words.forEach((key, value) -> {
            var asterisks = new StringBuilder();
            IntStream.range(0,value).forEach(o -> asterisks.append("*"));
            cout.writeLine(String.format("%-10s %s\n", key.concat(":"), asterisks));
        });
    }
}
