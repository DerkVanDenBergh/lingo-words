package infrastructure.serialization;

import infrastructure.serialization.deserializers.CSVDeserializer;

import java.util.IllegalFormatException;

public class DeserializerFactory {
    public Deserializer CreateDeserializer(String extension) {
        System.out.println(extension);
        if(extension.equals("csv")) {
            return new CSVDeserializer();
        } else {
            throw new IllegalArgumentException("Filetype not supported");
        }
    }
}
