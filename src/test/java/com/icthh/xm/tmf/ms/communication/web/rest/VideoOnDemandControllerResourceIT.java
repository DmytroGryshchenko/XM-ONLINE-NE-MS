package com.icthh.xm.tmf.ms.communication.web.rest;

import com.icthh.xm.tmf.ms.communication.CommunicationApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the VideoOnDemandControllerResource REST controller.
 *
 * @see VideoOnDemandControllerResource
 */
@SpringBootTest(classes = CommunicationApp.class)
public class VideoOnDemandControllerResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        VideoOnDemandControllerResource videoOnDemandControllerResource = new VideoOnDemandControllerResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(videoOnDemandControllerResource)
            .build();
    }

    /**
     * Test videoOnDemand
     */
    @Test
    public void testVideoOnDemand() throws Exception {
        restMockMvc.perform(get("/api/video-on-demand-controller/video-on-demand"))
            .andExpect(status().isOk());
    }

    /**
     * Test connect
     */
    @Test
    public void testConnect() throws Exception {
        restMockMvc.perform(post("/api/video-on-demand-controller/connect"))
            .andExpect(status().isOk());
    }

    /**
     * Test disconnect
     */
    @Test
    public void testDisconnect() throws Exception {
        restMockMvc.perform(post("/api/video-on-demand-controller/disconnect"))
            .andExpect(status().isOk());
    }
}
