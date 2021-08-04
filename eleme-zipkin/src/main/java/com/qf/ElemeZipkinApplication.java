package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;


/**
 * Created by ding on 2020/1/3.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ElemeZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElemeZipkinApplication.class);
    }
}
