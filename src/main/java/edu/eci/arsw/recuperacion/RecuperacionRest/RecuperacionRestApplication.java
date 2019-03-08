package edu.eci.arsw.recuperacion.RecuperacionRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.recuperacion"})
public class RecuperacionRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecuperacionRestApplication.class, args);
	}

}
