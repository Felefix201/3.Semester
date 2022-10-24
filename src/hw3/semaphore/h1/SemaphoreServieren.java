package hw3.semaphore.h1;

import java.util.concurrent.Semaphore;

public class SemaphoreServieren extends Thread {
    private final Semaphore[] binarySemaphores;

    public SemaphoreServieren(Semaphore[] binarySemaphores) {
        this.binarySemaphores = binarySemaphores;
        start();
    }

    private void servieren() {
        System.out.println("Nudeln werden serviert");
    }

    @Override
    public void run() {
        try {
            binarySemaphores[3].acquire();
            binarySemaphores[2].acquire();
            servieren();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
