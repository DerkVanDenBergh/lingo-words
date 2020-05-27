package infrastructure.serialization.serializers;

import domain.Wordset;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONSerializerTest {

    @Test
    public void JsonSerializerShouldReturnValidJsonString() {
        JSONSerializer serializer = new JSONSerializer();

        Wordset set = new Wordset(new ArrayList<String>(), "dutch");

        set.add("the");
        set.add("quick");
        set.add("fox");

        String serialized = serializer.write(set);

        String predefined = "{\"language\":\"dutch\",\"words\":[\"the\",\"quick\",\"fox\"]}";

        assertEquals(predefined, serialized, "serialized string should be equal to predefined string");
    }
}
