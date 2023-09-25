package com.inditex.comercioelectronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ComercioElectronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComercioElectronicoApplication.class, args);
	}

}
