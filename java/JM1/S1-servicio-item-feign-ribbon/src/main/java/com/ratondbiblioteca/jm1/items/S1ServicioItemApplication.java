package com.ratondbiblioteca.jm1.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "${spring.application.servicio.producto.name}")
@EnableFeignClients
@SpringBootApplication
public class S1ServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(S1ServicioItemApplication.class, args);
	}

}
