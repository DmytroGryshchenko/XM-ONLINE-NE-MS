package com.icthh.xm.tmf.ms.communication.web.rest;

import com.icthh.xm.tmf.ms.communication.domain.Client;
import com.icthh.xm.tmf.ms.communication.domain.VodData;
import com.icthh.xm.tmf.ms.communication.service.VideoOnDemandService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/services/vod")
public class VideoOnDemandControllerResource {

    @Autowired
    private VideoOnDemandService videoOnDemandService;


    @GetMapping
    public ResponseEntity<VodData> readVod(@RequestParam int uid, @RequestParam String login, @RequestParam String password  ) {
      return  ResponseEntity.ok(videoOnDemandService.read(new Client(uid, login, password)));

    }

    @GetMapping("/c")
    public ResponseEntity<String> get() {
        return  ResponseEntity.ok("OK");

    }
}
