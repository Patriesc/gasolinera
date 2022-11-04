package com.gasolinera.gasolinera;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class GasolineraApplication {
    private static Logger logger = LoggerFactory.getLogger(com.gasolinera.gasolinera.GasolineraApplication.class);
    public static int numSurtidores;
    public static int numClientes;
    public static ArrayList<String> clientes = new ArrayList<>();
    public static Gasolinera gasolinera;
    public static GUI gui;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de surtidores: ");

        numSurtidores = sc.nextInt();
        gasolinera = new Gasolinera(numSurtidores);

        System.out.print("Introduce el número de clientes: ");
        numClientes = sc.nextInt();

        for (int i = 0; i < numClientes; i++) {
            clientes.add("Cliente " + i);
        }
        gui = new GUI(numSurtidores);
        for (int i = 0; i < numClientes; i++) {
            Hilos client = new Hilos(clientes.get(i), gasolinera);
            client.start();
        }


    }


}
