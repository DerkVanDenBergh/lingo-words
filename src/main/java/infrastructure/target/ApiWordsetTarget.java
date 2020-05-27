package infrastructure.target;

import domain.Wordset;
import domain.WordsetTarget;
import infrastructure.serialization.Serializer;
import infrastructure.serialization.SerializerFactory;
import infrastructure.target.requestentity.ApiWordsetTargetRequestEntityFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.rmi.server.ExportException;

public class ApiWordsetTarget implements WordsetTarget {

    final String endpoint;
    final String format;

    final Throwable ExportException = new Exception();

    public ApiWordsetTarget(String endpoint, String format)
    {
        this.endpoint = endpoint;
        this.format = format;
    }

    public String export(Wordset wordset) throws ExportException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(endpoint);

        Serializer serializer = new SerializerFactory().createSerializer(format);

        // ToDo: goede plek vinden voor deze klasse
        StringEntity requestEntity = new ApiWordsetTargetRequestEntityFactory().createEntity(format, serializer.write(wordset));

        try{
            httppost.setEntity(requestEntity);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        //Execute and get the response.
        try {
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream instream = entity.getContent()) {
                    StringBuilder textBuilder = new StringBuilder();
                    try (Reader reader = new BufferedReader(new InputStreamReader
                            (instream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                        int c = 0;
                        while ((c = reader.read()) != -1) {
                            textBuilder.append((char) c);
                        }
                    }

                    return textBuilder.toString();
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ExportException("Export failed, please check API endpoint");
        }

        return null;
    }
}
