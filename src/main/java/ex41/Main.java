/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NameSorter nameSorter = new NameSorter(new ArrayList<>());
        List<Name> names = new ArrayList<>();
        nameSorter.sort(names);
    }
}
