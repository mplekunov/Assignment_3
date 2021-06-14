package ex41;

import java.util.List;

public interface Sorter<T> {
    /**
     * Sorts specified collection in order specified by compareTo() method in the T .
     *
     * @param collection a collection containing elements to be sorted
     * @return sorted collection
     */
    List<T> sort(List<T> collection);

}
