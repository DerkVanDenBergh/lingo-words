package infrastructure.serialization.deserializers;

import infrastructure.serialization.Deserializer;
import domain.Wordset;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CSVDeserializer implements Deserializer {
    public ArrayList<String> read(Path pathToFile)
    {
        ArrayList<String> words = new ArrayList<String>();

        try(BufferedReader reader = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8))
        {
            String line = reader.readLine();

            while(line != null)
            {

                String[] lineWords = line.split(",");

                for(String word : lineWords)
                {
                    words.add(word);
                }

                line = reader.readLine();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        return words;
    }
}
