package infrastructure.filter.filters;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class AlphabeticalWordFilterTest {

    @Test
    public void alphabeticalWordFilterShouldReturnAlphabeticalStrings() {
        AlphabeticalWordFilter filter = new AlphabeticalWordFilter();

        ArrayList<String> toBeFilteredWords = new ArrayList<String>();

        toBeFilteredWords.add("effect/");
        toBeFilteredWords.add("appear");
        toBeFilteredWords.add("bedr0om");
        toBeFilteredWords.add("carbon");

        ArrayList<String> filteredWords = new ArrayList<String>();

        filteredWords.add("appear");
        filteredWords.add("carbon");



        assertEquals(filteredWords, filter.filterWords(toBeFilteredWords), "Filter should removed 'effect/' and 'bedr0om'");
    }
}