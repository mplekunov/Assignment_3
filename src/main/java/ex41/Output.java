/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.io.IOException;

public interface Output {
    /**
     * Writes output. Returns state of an operation.
     * @throws IOException - if operation was unsuccessful.
     */
    void write() throws IOException;
}
