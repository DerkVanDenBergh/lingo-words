package infrastructure.serialization.deserializers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVDeserializerTest {

    @Test
    public void csvDeserializerShouldReturnValidStringArrayListFromFile() {
        CSVDeserializer deserializer = new CSVDeserializer();

        Path pathToFile = Paths.get("./src/test/testdata/testdata.csv");

        ArrayList<String> fileWords = new ArrayList<>();

        fileWords.add("the/");
        fileWords.add("quick!");
        fileWords.add("br0wn");
        fileWords.add("fox");
        fileWords.add("jumps");
        fileWords.add("over");
        fileWords.add("the");
        fileWords.add("lazy");
        fileWords.add("dog");

        ArrayList<String> words = deserializer.read(pathToFile);

        assertEquals(fileWords, words, "Words in array should be equal to read words");
    }
}
