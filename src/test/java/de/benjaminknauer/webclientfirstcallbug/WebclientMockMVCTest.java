package de.benjaminknauer.webclientfirstcallbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class WebclientMockMVCTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testWebClientCall() throws Exception {
        mockMvc.perform(get("/web-client"));
    }

}
