package infrastructure.serialization.serializers;

import domain.Wordset;
import infrastructure.serialization.Serializer;

import java.util.ArrayList;

public class JSONSerializer implements Serializer {

    public String write(Wordset wordset) {
        String serializedWordset = null;

        ArrayList<String> wordsetWords = wordset.getWords();

        serializedWordset = "{\"language\":\"" + wordset.getLanguage() + "\",\n\"words\":[";

        for(String word : wordsetWords) {
            serializedWordset += "\"" + word + "\",";
        }

        serializedWordset = serializedWordset.substring(0, serializedWordset.length() - 1);

        serializedWordset += "]}";

        return serializedWordset;
    }
}
