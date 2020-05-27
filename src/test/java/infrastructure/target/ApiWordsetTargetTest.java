package infrastructure.target;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import domain.Wordset;
import domain.WordsetTarget;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.*;

public class ApiWordsetTargetTest {

    WireMockServer wireMockServer;

    @BeforeEach
    public void setup () {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }

    @AfterEach
    public void teardown () {
        wireMockServer.stop();
    }

    public void setupStub() {
        String response ="Request received!";
        wireMockServer.stubFor(post(urlPathMatching("/export"))
                .willReturn(aResponse().withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBody(response)));
    }

    @Test
    public void apiWordsetTargetShouldExportValidWordsetToApi() {
        WordsetTarget target = new ApiWordsetTarget(
                "http://127.0.0.1:8090/export",
                "json"
        );

        Wordset wordset = new Wordset(new ArrayList<String>(), "dutch");
        wordset.add("the");
        wordset.add("quick");
        wordset.add("fox");

        try {
            String exportResponse = target.export(wordset);
            assertEquals("Request received!", exportResponse);
            wireMockServer.verify(postRequestedFor(urlEqualTo("/export"))
                    .withRequestBody(equalToJson("{\"language\":\"dutch\",\"words\":[\"the\",\"quick\",\"fox\"]}")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void apiWordsetTargetShouldThrowErrorWithInvalidEndpoint() {
        WordsetTarget target = new ApiWordsetTarget(
                "http://127.0.0.1:8091/export",
                "json"
        );

        Wordset wordset = new Wordset(new ArrayList<String>(), "dutch");
        wordset.add("the");
        wordset.add("quick");
        wordset.add("fox");

        Throwable exception = assertThrows(Exception.class, () -> target.export(wordset));
        assertEquals("Export failed, please check API endpoint", exception.getMessage());

    }
}
