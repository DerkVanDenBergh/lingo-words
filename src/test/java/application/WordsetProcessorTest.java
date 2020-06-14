package application;

import com.github.tomakehurst.wiremock.WireMockServer;
import domain.Wordset;
import domain.WordsetSource;
import domain.WordsetTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordsetProcessorTest {

    WireMockServer wireMockServer;

    @Test
    public void WordsetProcessorExportShouldReturnTrue() {
        WordsetProcessor processor = new WordsetProcessor();

        Wordset wordset = new Wordset(new ArrayList<String>(), "dutch");
        wordset.add("the");
        wordset.add("quick");
        wordset.add("brown");

        WordsetSource source = mock(WordsetSource.class);
        when(source.importSet()).thenReturn(wordset);

        WordsetTarget target = mock(WordsetTarget.class);
        try {
            when(target.export(any(Wordset.class))).thenReturn("Example response!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }

        assertTrue(processor.exportWordset(source, target));
    }

    @Test
    public void WordsetProcessorExportShouldReturnFalse() {
        WordsetProcessor processor = new WordsetProcessor();

        Wordset wordset = new Wordset(new ArrayList<String>(), "dutch");
        wordset.add("the");
        wordset.add("quick");
        wordset.add("brown");

        WordsetSource source = mock(WordsetSource.class);
        when(source.importSet()).thenReturn(wordset);

        WordsetTarget target = mock(WordsetTarget.class);
        try {
            when(target.export(any(Wordset.class))).thenThrow(new Exception());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }

        assertFalse(processor.exportWordset(source, target));
    }

    @BeforeEach
    public void setup () {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }

    public void setupStub() {
        String response ="Request received!";
        wireMockServer.stubFor(post(urlPathMatching("/export"))
                .willReturn(aResponse().withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBody(response)));
    }

    @Test
    public void wordsetProcessorExportFileSourceToApiTargetShouldReturnTrue() {
        WordsetProcessor processor = new WordsetProcessor();



        assertTrue(
                processor.exportFileToApi(
                        "./src/test/testdata/testdata.csv",
                        "http://localhost:8090/export",
                        "alphabetical", "json",
                        "dutch"
                )
        );



        wireMockServer.verify(postRequestedFor(urlEqualTo("/export"))
                .withRequestBody(equalToJson("{\"language\":\"dutch\",\"words\":[ \"carbon\", \"rotate\", \"rabbit\", \"whisper\", \"makeup\", \"maven\" ]}")));
    }

    @AfterEach
    public void teardown () {
        wireMockServer.stop();
    }
}
