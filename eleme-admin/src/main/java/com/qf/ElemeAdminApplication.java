package com.qf;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ding on 2020/1/3.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class ElemeAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElemeAdminApplication.class);
    }
}
