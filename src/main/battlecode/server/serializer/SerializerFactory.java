package battlecode.server.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Turns out the factory pattern is basically exactly what we want here.
 * We can abstract away creation of serializers.
 *
 * Created by james on 9/26/15.
 */
public interface SerializerFactory {
    /**
     * Create a serializer
     *
     * @param output stream to write to; may be null
     * @param input stream to read from; may be null
     * @return a new serializer to use
     */
    Serializer createSerializer(OutputStream output, InputStream input) throws IOException;
}
