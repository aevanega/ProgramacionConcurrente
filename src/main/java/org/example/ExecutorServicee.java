package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicee {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            int tarea = i;
            executor.submit(() -> {
                String nombreHilo = Thread.currentThread().getName();
                System.out.println("Tarea " + tarea + " ejecutada por " + nombreHilo);
            });
        }
        executor.shutdown();
    }
}

