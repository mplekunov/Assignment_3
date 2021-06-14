package ex41;

import org.jetbrains.annotations.NotNull;

/**
 * Stores Information about Name object
 */
public class Name implements Comparable<Name> {

    private String firstName;
    private String lastName;

    /**
     * Returns the frstName field of this object
     * @return string representing firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the lastName field of this object
     *
     * @return string representing lastName field
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Compares this object's lastName property with the same property of specified object.
     * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     *
     * @param name object to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     * @throws NullPointerException - if an argument is null and this comparator does not permit null arguments.
     */
    @Override
    public int compareTo(@NotNull Name name)
        throws NullPointerException {

        if (this.lastName.isEmpty() || name.lastName.isEmpty())
            throw new NullPointerException();

        return this.lastName.compareTo(name.lastName);
    }
}
