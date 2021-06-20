/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameSorter {
    private final List<Name> names;

    private NameSorter() {
        names = new ArrayList<>();
    }

    public NameSorter(List<Name> nameCollection)
        throws NullPointerException {

        this();
        names.addAll(nameCollection);
    }

    public List<Name> sort() {
        return names.stream().sorted(Comparator.comparing(Name::getLastName)).collect(Collectors.toList());
    }
}
