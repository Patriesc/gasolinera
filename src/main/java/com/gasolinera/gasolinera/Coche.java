package com.gasolinera.gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;

public class Coche implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Coche.class);

    private String nombre;
    private Gasolinera gasolinera;
    private Surtidor surtidor;
    private Queue cola;

    public Coche(String nombre, Gasolinera gasolinera) {
        this.nombre = nombre;
        this.gasolinera = gasolinera;
    }

    public void run() {
        while (true) {
            try {
                repostar();
                pagar();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private void repostar() throws InterruptedException {
        logger.info("El coche " + nombre + " está buscando un surtidor libre");
        surtidor = gasolinera.buscarSurtidorLibre();
        logger.info("El coche " + nombre + " ha encontrado un surtidor libre");
        surtidor.take();
        logger.info("El coche " + nombre + " está repostando durante {} minutos", gasolinera.getTime() / 1000);
        Thread.sleep(gasolinera.getTime());
        surtidor.drop();
        logger.info("El coche " + nombre + " ha terminado de repostar");
    }


    private void pagar() throws InterruptedException {
        long time;
        logger.info("El coche {} está pagando (3minutos)", nombre);
        spendTime(3);
        logger.info("El coche {} ha pagado", nombre);
    }

/*
    private void repostar() throws InterruptedException {
        long time = gasolinera.getTime();
        logger.info("{} repostando durante {}minutos", nombre, time);
        spendTime(time);
    }

 */

    private void spendTime(long time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

}



