package com.gasolinera.gasolinera;

import com.gasolinera.gasolinera.views.Lanzador;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class GasolineraApp {
    public static void main(String[] args) {
        Lanzador.lanzador();
    }
}
