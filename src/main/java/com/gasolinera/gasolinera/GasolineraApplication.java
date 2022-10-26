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
		Gasolinera table = new Gasolinera(50);
		Thread dinner = new Thread(table);

		logger.info("Empezado servicio...");
		dinner.start();
		dinner.join();
	}


}
