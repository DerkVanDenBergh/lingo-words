package infrastructure.filter.filters;

import infrastructure.filter.WordFilter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabeticalWordFilter implements WordFilter {

    public ArrayList<String> filterWords(ArrayList<String> words) {
        ArrayList<String> filteredWords = new ArrayList<String>();

        String regex = "^[a-z]+$";

        Pattern pattern = Pattern.compile(regex);

        for (String word : words)
        {
            Matcher matcher = pattern.matcher(word);

            if(matcher.matches()) {
                System.out.println(word);
                filteredWords.add(word);
            }
        }

        return filteredWords;
    }
}
