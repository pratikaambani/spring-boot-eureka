package com.practise.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Pratik Ambani on 23/6/18.
 */
@Component
public class Application {

    @Value("${spring.application.name}")
    public String springApplicationName;

    @Value("${server.port:8080}")
    public String serverPort;
}
