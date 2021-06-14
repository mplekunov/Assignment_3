/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Converts String to Name object
 */
public class NameConverter {
    /**
     * Default NameConverter constructor
     */
    public NameConverter() {}

    /**
     * Converts string fullName to Name object
     * @param fullName string containing last name and first name
     * @return Name object
     */
    public Name convertToName(String fullName) {
        List<String> name = Arrays.stream(fullName.split(", ")).map(String::toString).collect(Collectors.toList());
        return new Name(name.get(1), name.get(0));
    }

}
