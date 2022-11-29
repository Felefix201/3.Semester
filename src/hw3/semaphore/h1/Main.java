package hw3.semaphore.h1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] binarySemaphores = new Semaphore[4];
        for (int i = 0; i < binarySemaphores.length; i++) {
            binarySemaphores[i] = new Semaphore(0);
        }
        new SemaphoreSauceKochen(binarySemaphores);
        new Thread(() -> {
            try {
                binarySemaphores[0].acquire();
                binarySemaphores[1].acquire();
                System.out.println("Sauce wird gekocht");
                binarySemaphores[3].release();
            } catch (InterruptedException e) {
                new InterruptedException("SauceKochen was called at the wrong time");
            }
        }).start();

        new SemaphoreZwiebelnSchneiden(binarySemaphores);
        new SemaphoreTomatenSchneiden(binarySemaphores);
        new NudelnKochen(binarySemaphores);
        new SemaphoreServieren(binarySemaphores);
    }
}
