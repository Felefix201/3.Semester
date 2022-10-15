package homework_three.h1.h1;

import java.util.concurrent.Semaphore;

public class SemaphoreTomatenSchneiden extends Thread {
    private final Semaphore[] binarySemaphores;

    public SemaphoreTomatenSchneiden(Semaphore[] binarySemaphores) {
        this.binarySemaphores = binarySemaphores;
        start();
    }

    @Override
    public void run() {
        System.out.println("Tomaten werden geschnitten");
        binarySemaphores[1].release();
    }
}
