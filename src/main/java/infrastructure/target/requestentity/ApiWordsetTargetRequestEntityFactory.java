package infrastructure.target.requestentity;


import org.apache.http.entity.StringEntity;

public class ApiWordsetTargetRequestEntityFactory {
    public StringEntity createEntity(String format, String serializedWordset) {
        if(format.equals("json")) {
            try {
                return new StringEntity(serializedWordset, "application/json", "UTF-8");
            } catch(Exception e) {
                throw new IllegalArgumentException("Encoding not supported");
            }
        } else {
            throw new IllegalArgumentException("Format not supported");
        }
    }
}
