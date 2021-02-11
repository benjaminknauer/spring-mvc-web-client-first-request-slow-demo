package de.benjaminknauer.webclientfirstcallbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;

@SpringBootTest
class WebclientDirectCallTest {

    @Autowired
    TestClient testClient;

    @Test
    void testWebClientCall() {
        System.out.println("Starting 1st call");
        Instant start1stCall = Instant.now();
        testClient.doCallViaWebClient();
        Instant finished1stCall = Instant.now();

        Instant start2ndCall = Instant.now();
        System.out.println("Starting 2nd call");
        testClient.doCallViaWebClient();
        Instant finished2ndCall = Instant.now();

        long timeElapsed1stCall = Duration.between(start1stCall, finished1stCall).toMillis();
        long timeElapsed2ndCall = Duration.between(start2ndCall, finished2ndCall).toMillis();

        System.out.println("1st call:" + timeElapsed1stCall);
        System.out.println("2nd call:" + timeElapsed2ndCall);
    }

}
