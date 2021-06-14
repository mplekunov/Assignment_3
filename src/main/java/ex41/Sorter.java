/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.List;

public interface Sorter<T> {
    /**
     * Sorts this object's collection in order specified by compareTo() method in the T.
     *
     * @return sorted collection
     */
    List<T> sort();

}
