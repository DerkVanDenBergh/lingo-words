package infrastructure.filter.filters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class AlphaNumericWordFilterTest {

    @Test
    public void alphanumericWordFilterShouldReturnAlphabeticalStrings() {
        AlphaNumericWordFilter filter = new AlphaNumericWordFilter();

        ArrayList<String> toBeFilteredWords = new ArrayList<String>();

        toBeFilteredWords.add("the");
        toBeFilteredWords.add("quick!");
        toBeFilteredWords.add("br0wn");
        toBeFilteredWords.add("fox");

        ArrayList<String> filteredWords = new ArrayList<String>();

        filteredWords.add("the");
        filteredWords.add("br0wn");
        filteredWords.add("fox");



        assertEquals(filteredWords, filter.filterWords(toBeFilteredWords), "Filter should remove 'quick!'");
    }
}
