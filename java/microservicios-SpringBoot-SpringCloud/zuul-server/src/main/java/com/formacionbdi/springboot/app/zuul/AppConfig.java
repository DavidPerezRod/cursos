package com.formacionbdi.springboot.app.zuul;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:services.properties")
public class AppConfig {

    @Bean("clienteRest")
    @LoadBalanced
    public RestTemplate registrarRestTemplate() {
	return new RestTemplate();
    }
}
