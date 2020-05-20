package domain;

import java.util.ArrayList;

public class Wordset {
    final String language;
    private ArrayList<String> words;

    public Wordset(ArrayList<String> words, String language) {
        this.words = words;
        this.language = language;
    }

    public void add(String word) {
        this.words.add(word);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getLanguage() {
        return(this.language);
    }
}
