package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumaCallable implements Callable<Integer> {
    private final int a;
    private final int b;

    public SumaCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() {
        return a + b;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        SumaCallable tarea = new SumaCallable(5, 10);
        Future<Integer> future = executor.submit(tarea);

        try {
            Integer resultado = future.get();
            System.out.println("Resultado de la suma: " + resultado);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener el resultado de la suma");
        }

        executor.shutdown();
    }
}
