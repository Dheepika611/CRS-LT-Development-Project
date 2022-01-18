package com.lt.crs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * 
 * @author G1
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.lt.crs.repository")
@ComponentScan({"com.lt.crs.*"})
@EnableWebMvc
@EnableAutoConfiguration
@EntityScan("com.lt.crs.entity")
public class CrsJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsJpaApplication.class, args);
		System.out.println("OK");
	}

}
