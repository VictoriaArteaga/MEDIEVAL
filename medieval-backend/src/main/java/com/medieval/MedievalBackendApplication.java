package com.medieval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

// Temporalmente deshabilitado para evitar conflicto con la conexión a DB.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MedievalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedievalBackendApplication.class, args);
	}

}
