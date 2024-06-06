package org.example;

public class Contador implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo fue interrumpido");
            }
        }
    }

    public static void main(String[] args) {
        Thread hilo = new Thread(new Contador());
        hilo.start();
    }
}
