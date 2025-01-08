package dev.desafio.sysmap.ms_authuser_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsAuthuserV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthuserV1Application.class, args);
	}

}
