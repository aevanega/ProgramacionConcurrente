package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class CyclicBarrierr {
    private static final int NUM_HILOS = 4;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUM_HILOS, () -> System.out.println("Todos los hilos han completado sus tareas."));

        for (int i = 0; i < NUM_HILOS; i++) {
            new Thread(new Tarea(barrier)).start();
        }
    }

    static class Tarea implements Runnable {
        private final CyclicBarrier barrier;

        Tarea(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                int tiempoTrabajo = ThreadLocalRandom.current().nextInt(1000, 3000);
                Thread.sleep(tiempoTrabajo);
                System.out.println(Thread.currentThread().getName() + " ha terminado su tarea en " + tiempoTrabajo + " ms");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo fue interrumpido");
            }
        }
    }
}
