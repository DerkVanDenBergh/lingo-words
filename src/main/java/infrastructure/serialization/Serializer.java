package infrastructure.serialization;

import domain.Wordset;

public interface Serializer {
    String write(Wordset wordset);
}
