package homework_three.h1.h1;

import java.util.concurrent.Semaphore;

public class SemaphoreSauceKochen extends Thread {
    private final Semaphore[] binarySemaphores;

    public SemaphoreSauceKochen(Semaphore[] binarySemaphores) {
        this.binarySemaphores = binarySemaphores;
        start();
    }

    private void kochen() {
        System.out.println("Sauce wird gekocht");
    }

    @Override
    public void run() {
        try {
            binarySemaphores[0].acquire();
            binarySemaphores[1].acquire();
            kochen();
            binarySemaphores[3].release();
        } catch (InterruptedException e) {
           new InterruptedException("SauceKochen was called at the wrong time");
        }
    }
}
