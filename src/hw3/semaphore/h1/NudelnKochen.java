package hw3.semaphore.h1;

import java.util.concurrent.Semaphore;

public class NudelnKochen extends Thread {
    private final Semaphore[] binarySemaphores;

    public NudelnKochen(Semaphore[] binarySemaphores) {
        this.binarySemaphores = binarySemaphores;
        start();
    }

    private void kochen() {
        System.out.println("Nudeln werden gekocht");
    }

    @Override
    public void run() {
        kochen();
        binarySemaphores[2].release();
    }
}
