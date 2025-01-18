package com.java.spr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCachingProjectWithExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCachingProjectWithExampleApplication.class, args);
	}

}
