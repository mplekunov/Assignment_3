/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex41;

import org.jetbrains.annotations.NotNull;

public class Name implements Comparable<Name> {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(@NotNull Name name)
        throws NullPointerException {

        if (this.lastName.isEmpty() || name.lastName.isEmpty())
            throw new NullPointerException();

        return this.lastName.compareTo(name.lastName);
    }
}
