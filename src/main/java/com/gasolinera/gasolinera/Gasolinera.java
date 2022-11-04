package com.gasolinera.gasolinera;


import java.util.Random;

public class Gasolinera {

    private int numSurtidores;
    private Hilos[] surtidores;
    public static Semaphore semaphore;
    private Random rand;

    public Gasolinera(int numSurtidores) {
        this.numSurtidores = numSurtidores;
        semaphore = new Semaphore(numSurtidores);
        surtidores = new Hilos[numSurtidores];
        rand = new Random();
    }

    public synchronized void arrived(Hilos client) {
        System.out.println(client.clientName + " llegó");
    }

    public synchronized int ocuparSurtidor(Hilos client) {
        int i;
        for (i = 0; i < numSurtidores; i++) {
            if (surtidores[i] == null) {
                System.out.println(client.clientName + " ocupó el surtidor " + (i + 1));
                surtidores[i] = client;
                semaphore.acquire(client.clientName, surtidores[i]);
                break;
            }
        }
        return i;
    }

    public synchronized void repostar(Hilos client, int index) {
        System.out.println(client.clientName + " está repostando");
        GasolineraApplication.gui.setColorYellow(index, client.clientName + " está repostando");
        try {
            client.sleep(rand.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void paying(Hilos client, int index) {
        System.out.println(client.clientName + " está pagando");
        GasolineraApplication.gui.setColorGreen(index, client.clientName + " está pagando");
        try {
            client.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leaving(Hilos client, int index) {
        System.out.println(client.clientName + " is leaving");
        for (int i = 0; i < numSurtidores; i++) {
            if (surtidores[i] != null && surtidores[i].clientName == client.clientName) {
                surtidores[i] = null;
            }
        }
        GasolineraApplication.gui.setColorRed(index, client.clientName + " se está yendo");
        semaphore.release();
    }

}


