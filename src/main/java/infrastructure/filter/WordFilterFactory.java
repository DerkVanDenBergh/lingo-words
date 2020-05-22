package infrastructure.filter;

import infrastructure.filter.filters.AlphaNumericWordFilter;
import infrastructure.filter.filters.AlphabeticalWordFilter;

public class WordFilterFactory {
    public WordFilter createFilter(String filter) {
        if(filter.equals("alphabetical")) {
            return new AlphabeticalWordFilter();
        } else if(filter.equals("alphanumeric")) {
            return new AlphaNumericWordFilter();
        } else {
            throw new IllegalArgumentException("Filter not supported");
        }
    }
}
