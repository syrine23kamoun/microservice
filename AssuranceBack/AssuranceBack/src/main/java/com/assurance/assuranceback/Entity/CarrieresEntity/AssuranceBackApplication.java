package com.assurance.assuranceback.Entity.CarrieresEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AssuranceBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceBackApplication.class, args);
	}

}
