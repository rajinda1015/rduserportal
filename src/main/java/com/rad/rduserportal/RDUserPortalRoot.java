package com.rad.rduserportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class RDUserPortalRoot {

	public static void main(String[] args) {
		SpringApplication.run(RDUserPortalRoot.class, args);
	}

}
