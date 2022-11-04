package com.gasolinera.gasolinera.views;

import com.gasolinera.gasolinera.models.Gasolinera;
import com.gasolinera.gasolinera.models.Hilos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Lanzador {
    private static Logger logger = LoggerFactory.getLogger(Lanzador.class);
    public static int numSurtidores;
    public static int numClientes;
    public static ArrayList<String> clientes = new ArrayList<>();
    public static Gasolinera gasolinera;
    public static GUI gui;

    public static void lanzador() {
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
