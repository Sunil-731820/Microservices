package com.java.spr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerUsingApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerUsingApiGateWayApplication.class, args);
	}

}
