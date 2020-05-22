package infrastructure.filter;

import infrastructure.filter.filters.AlphaNumericWordFilter;
import infrastructure.filter.filters.AlphabeticalWordFilter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFilterFactoryTest {

    @Test
    public void wordFilterFactoryShouldReturnAlphabeticalFilter() {
        WordFilterFactory factory = new WordFilterFactory();

        WordFilter factoryFilter = factory.createFilter("alphabetical");

        assertTrue(factoryFilter instanceof AlphabeticalWordFilter);
    }

    @Test
    public void wordFilterFactoryShouldReturnAlphaNumericFilter() {
        WordFilterFactory factory = new WordFilterFactory();

        WordFilter factoryFilter = factory.createFilter("alphanumeric");

        assertTrue(factoryFilter instanceof AlphaNumericWordFilter);
    }

    @Test
    public void wordFilterFactoryShouldReturnExceptionWithInvalidArgument() {
        WordFilterFactory factory = new WordFilterFactory();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> factory.createFilter("invalid"));
        assertEquals("Filter not supported", exception.getMessage());
    }
}