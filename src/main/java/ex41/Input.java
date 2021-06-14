/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

public interface Input<T> {
    /**
     * Reads input. Returns T type object.
     * @return T type object containing input
     */
    T read();
}
