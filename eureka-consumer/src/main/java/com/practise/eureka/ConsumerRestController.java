package com.practise.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Pratik Ambani on 25/6/18.
 */
@RestController
class ConsumerRestController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public String index() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://eureka-client/info", String.class);
        return response.getBody();
    }
}