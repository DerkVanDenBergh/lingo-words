package infrastructure.serialization;

import infrastructure.serialization.deserializers.CSVDeserializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeserializerFactoryTest {

    @Test
    public void deserializerFactoryShouldReturnCsvDeserializer() {
        DeserializerFactory factory = new DeserializerFactory();

        Deserializer factoryDeserializer = factory.createDeserializer("csv");

        assertTrue(factoryDeserializer instanceof CSVDeserializer);
    }

    @Test
    public void deserializerFactoryShouldReturnExceptionWithInvalidArgument() {
        DeserializerFactory factory = new DeserializerFactory();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> factory.createDeserializer("invalid"));
        assertEquals("Filetype not supported", exception.getMessage());
    }
}
