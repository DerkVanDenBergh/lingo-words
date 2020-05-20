package infrastructure.serialization;


import infrastructure.serialization.serializers.JSONSerializer;

public class SerializerFactory {

    public Serializer createSerializer(String format) {
        if(format.equals("json")) {
            return new JSONSerializer();
        } else {
            throw new IllegalArgumentException("Format not supported");
        }
    }
}
