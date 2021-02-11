package de.benjaminknauer.webclientfirstcallbug;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.Instant;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    final TestClient testClient;

    @GetMapping("/web-client")
    public ResponseEntity<String> test() {
        log.info("Start 1st WebClient call");
        Instant start1stCall = Instant.now();
        testClient.doCallViaWebClient();
        Instant finished1stCall = Instant.now();
        log.info("Finished 1st WebClient call");

        log.info("Start 2nd WebClient call");
        Instant start2ndCall = Instant.now();
        testClient.doCallViaWebClient();
        Instant finished2ndCall = Instant.now();
        log.info("Finished 1st WebClient call");

        long duration1stCall = Duration.between(start1stCall, finished1stCall).toMillis();
        long duration2ndCall = Duration.between(start2ndCall, finished2ndCall).toMillis();
        log.info("Duration 1st call (ms): " + duration1stCall);
        log.info("Duration 2nd call (ms): " + duration2ndCall);

        return ResponseEntity.ok(
                "Duration 1st call (ms): " + duration1stCall + "<br />"
                        + "Duration 2nd call (ms): " + duration2ndCall
        );
    }

}
