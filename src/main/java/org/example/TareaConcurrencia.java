package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TareaConcurrencia implements Runnable {
    private final int id;

    public TareaConcurrencia(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Tarea " + id + " ejecutada por " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            executor.submit(new TareaConcurrencia(i));
        }

        executor.shutdown();
    }
}
