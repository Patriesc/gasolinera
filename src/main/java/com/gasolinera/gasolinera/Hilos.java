package com.gasolinera.gasolinera;

public class Hilos extends Thread {

    String clientName = "";
    Gasolinera gasolinera;
    private int index;

    public Hilos(String name, Gasolinera gasolinera) {
        clientName = name;
        this.gasolinera = gasolinera;
    }

    @Override
    public void run() {

        gasolinera.arrived(this);
        index = gasolinera.ocuparSurtidor(this);
        gasolinera.repostar(this, index);
        gasolinera.paying(this, index);
        gasolinera.leaving(this, index);
        gasolinera.semaphore.release();

    }


}

