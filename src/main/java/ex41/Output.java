package ex41;

import java.io.IOException;

public interface Output {
    /**
     * Writes output. Returns state of an operation.
     * @throws IOException - if operation was unsuccessful.
     */
    void write() throws IOException;
}
