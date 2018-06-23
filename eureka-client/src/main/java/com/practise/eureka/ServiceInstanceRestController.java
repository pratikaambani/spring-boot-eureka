package com.practise.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Pratik Ambani on 23/6/18.
 */
@RestController
class ServiceInstanceRestController {

    private Application application;

    private DiscoveryClient discoveryClient;

    @Autowired
    public ServiceInstanceRestController(Application application, DiscoveryClient discoveryClient) {
        this.application = application;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/instances")
    public List<ServiceInstance> clients() {
        return this.discoveryClient.getInstances(application.springApplicationName);
    }

    @RequestMapping("/info")
    public Application info() {
        return application;
    }
}
