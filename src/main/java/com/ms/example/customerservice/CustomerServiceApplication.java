package com.ms.example.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CustomerServiceApplication {

	/*@Bean
	public WebClient.Builder clientBuilder(){

		return WebClient.builder().baseUrl("http://localhost:8081/domainLayer");
	}*/

	@Bean
	public WebClient getWebClientBuilder() {
		return WebClient.builder()
				.baseUrl("http://localhost:8081/domainLayer")
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
