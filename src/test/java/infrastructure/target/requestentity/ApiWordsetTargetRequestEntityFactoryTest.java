package infrastructure.target.requestentity;

import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiWordsetTargetRequestEntityFactoryTest {
    @Test
    public void ApiWordsetTargetRequestEntityFactoryShouldReturnJsonStringEntity() {
        ApiWordsetTargetRequestEntityFactory factory = new ApiWordsetTargetRequestEntityFactory();

        StringEntity factoryEntity = factory.createEntity("json", "{\"language\":\"dutch\",\"words\":[\"the\",\"quick\",\"fox\"]}");

        assertEquals("Content-Type: application/json; charset=UTF-8", factoryEntity.getContentType().toString());
    }

    @Test
    public void deserializerFactoryShouldReturnExceptionWithInvalidArgument() {
        ApiWordsetTargetRequestEntityFactory factory = new ApiWordsetTargetRequestEntityFactory();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> factory.createEntity("invalid", "invalid"));
        assertEquals("Format not supported", exception.getMessage());
    }
}
