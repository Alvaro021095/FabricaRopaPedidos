package com.prueba.fabrica.ropa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class , se debe iniciar la aplicación aquí
 * @author alvaro
 *
 */
@SpringBootApplication
public class FabricaApp {

	/**
	 * Metodo principal premite iniciar el servidor embebido de spring.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FabricaApp.class, args);
	}
}
