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

        fileWords.add("effect/");
        fileWords.add("appear!");
        fileWords.add("bedr0om");
        fileWords.add("carbon");
        fileWords.add("rotate");
        fileWords.add("rabbit");
        fileWords.add("whisper");
        fileWords.add("makeup");
        fileWords.add("maven");

        ArrayList<String> words = deserializer.read(pathToFile);

        assertEquals(fileWords, words, "Words in array should be equal to read words");
    }
}
