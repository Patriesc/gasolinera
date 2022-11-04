package com.gasolinera.gasolinera;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Gasolinera implements Runnable {
    private List<Surtidor> surtidores;
    private List<Coche> coches;
    private Iterator<Long> times;

    public Gasolinera(int numCoches) throws Exception {
        if (numCoches < 2) {
            throw new IllegalArgumentException("Introduce más de un coche");
        }

        this.surtidores = new ArrayList<>(4);
        this.coches = new ArrayList<>();
        this.times = new Random().longs(5000, 10000).iterator();


        for (int i = 0; i < 5; ++i) {
            Surtidor f = new Surtidor();
            surtidores.add(f);
        }
        for (int i = 0; i < numCoches; ++i) {


            Coche p = new Coche(this);
            coches.add(p);

        }
    }

    public Surtidor buscarSurtidorLibre() {
        for (Surtidor surtidor : surtidores) {
            if (!surtidor.isHeld()) {
                return surtidor;
            }
        }
        return null;
    }



    public synchronized long getTime() {
        return times.next();
    }

    public void run() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(coches.size());

        executorService.scheduleAtFixedRate(() -> {
            for (Coche coche : coches) {
                executorService.submit(coche);

                if(coche.getHaRepostado()){
                    coches.remove(coche);

                }

                if(coches.size()==0){
                    executorService.shutdownNow();

                }


            }
        }, 0, 1, java.util.concurrent.TimeUnit.SECONDS);


    }
}
