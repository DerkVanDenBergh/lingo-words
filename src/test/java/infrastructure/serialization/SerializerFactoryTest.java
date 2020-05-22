package infrastructure.serialization;

import infrastructure.serialization.serializers.JSONSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SerializerFactoryTest {

    @Test
    public void serializerFactoryShouldReturnJsonSerializer() {
        SerializerFactory factory = new SerializerFactory();

        Serializer factoryDeserializer = factory.createSerializer("json");

        assertTrue(factoryDeserializer instanceof JSONSerializer);
    }

    @Test
    public void deserializerFactoryShouldReturnExceptionWithInvalidArgument() {
        SerializerFactory factory = new SerializerFactory();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> factory.createSerializer("invalid"));
        assertEquals("Format not supported", exception.getMessage());
    }
}
