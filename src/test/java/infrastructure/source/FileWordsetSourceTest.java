package infrastructure.source;

import domain.Wordset;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileWordsetSourceTest {

    @Test
    public void fileWordSetSourceShouldImportAlphabeticalWordsetFromFile() {
        FileWordsetSource source = new FileWordsetSource(
                "./src/test/testdata/testdata.csv",
                "alphabetical",
                "dutch"
        );

        Wordset wordset = source.importSet();

        assertEquals("dutch", wordset.getLanguage(), "Language is wordset should be same as predefined");

        assertEquals("the", wordset.getWords().get(0), "The first word of an alphabetical wordset of the testdata should be 'fox'");
    }

}
