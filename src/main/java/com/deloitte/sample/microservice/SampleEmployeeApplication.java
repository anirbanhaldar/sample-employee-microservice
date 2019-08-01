package com.deloitte.sample.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;





@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@EnableZuulProxy
public class SampleEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleEmployeeApplication.class, args);
	}
}
