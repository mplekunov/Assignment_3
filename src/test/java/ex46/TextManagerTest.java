/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex46;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextManagerTest {

    @Test
    void countWords() {
        var textManager = new TextManager("one, two, two, three, three, three");
        var words = textManager.countWords();

        assertEquals(1,words.get("one"));
        assertEquals(2, words.get("two"));
        assertEquals(3, words.get("three"));
    }
}