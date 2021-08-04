package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by ding on 2020/1/3.
 */
@SpringBootApplication
@EnableEurekaServer
public class ElemeEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElemeEurekaApplication.class);
    }
}
