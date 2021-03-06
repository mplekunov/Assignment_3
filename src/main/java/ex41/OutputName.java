/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputName {
    private final List<Name> names;
    private final String fileName;

    public OutputName(List<Name> names, String fileName) {
        this.fileName = fileName;
        this.names = new ArrayList<>();
        this.names.addAll(names);
    }

    public void write() throws IOException {
        var fileWriter = new FileWriter(fileName);
        fileWriter.write(String.format(
                """
                Total of %d names
                -----------------
                """, names.size()));

        names.forEach(o -> {
            try {
                fileWriter.write(String.format("%s, %s\n", o.getLastName(), o.getFirstName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        fileWriter.close();
    }
}
