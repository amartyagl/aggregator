package com.globallogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GloQuoraPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloQuoraPostApplication.class, args);
	}

}
