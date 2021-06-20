/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorts Name object in the given format
 */
public class NameSorter {
    private final List<Name> names;

    /**
     * Constructs an empty NameSorter object.
     */
    private NameSorter() {
        names = new ArrayList<>();
    }

    /**
     * Constructs a NameSorter object containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param nameCollection the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public NameSorter(List<Name> nameCollection)
        throws NullPointerException {

        this();
        names.addAll(nameCollection);
    }

    public List<Name> sort() {
        return names.stream().sorted(Comparator.comparing(Name::getLastName)).collect(Collectors.toList());
    }
}
