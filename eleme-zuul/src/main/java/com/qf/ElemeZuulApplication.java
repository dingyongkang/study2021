package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by ding on 2020/1/3.
 */
@SpringBootApplication
@EnableZuulProxy
public class ElemeZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElemeZuulApplication.class);
    }
}
