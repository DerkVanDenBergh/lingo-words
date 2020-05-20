package infrastructure.serialization;

import domain.Wordset;

import java.nio.file.Path;
import java.util.ArrayList;

public interface Deserializer {
    public ArrayList<String> read(Path pathToFile);
}
