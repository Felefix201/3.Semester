package homework_three.h1.h1;

import java.util.concurrent.Semaphore;

public class SemaphoreZwiebelnSchneiden extends Thread {
    private final Semaphore[] binarySemaphores;

    public SemaphoreZwiebelnSchneiden(Semaphore[] binarySemaphores) {
        this.binarySemaphores = binarySemaphores;
        start();
    }

    @Override
    public void run() {
        System.out.println("Zwiebeln werden geschnitten");
        binarySemaphores[0].release();
    }
}
