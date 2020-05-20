package infrastructure.source;

import com.google.common.io.Files;
import domain.Wordset;
import domain.WordsetSource;
import infrastructure.filter.WordFilter;
import infrastructure.filter.WordFilterFactory;
import infrastructure.serialization.Deserializer;
import infrastructure.serialization.DeserializerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWordsetSource implements WordsetSource
{

    final String path;
    final String filter;
    final String language;

    public FileWordsetSource(String path, String filter, String language)
    {
        this.path = path;
        this.filter = filter;
        this.language = language;
    }

    public Wordset importSet()
    {
        Path pathToFile = Paths.get(path);

        String extension = Files.getFileExtension(pathToFile.toString());

        Deserializer deserializer = new DeserializerFactory().CreateDeserializer(extension);

        WordFilter wordFilter = new WordFilterFactory().CreateFilter(filter);

        return new Wordset(wordFilter.filterWords(deserializer.read(pathToFile)), this.language);
    }
}
