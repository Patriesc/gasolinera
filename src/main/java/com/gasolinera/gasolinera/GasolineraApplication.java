package com.gasolinera.gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GasolineraApplication {
	private static Logger logger = LoggerFactory.getLogger(com.gasolinera.gasolinera.GasolineraApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GasolineraApplication.class, args);
		logger.info("Abriendo gasolinera...");
		Gasolinera gasolinera = new Gasolinera(5);
		Thread servicio = new Thread(gasolinera);

		logger.info("Empezando servicio...");
		servicio.start();
		servicio.join();
	}


}
