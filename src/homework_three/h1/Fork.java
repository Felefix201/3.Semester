package homework_three.h1;

import java.util.concurrent.Semaphore;

public class Fork {
    private final Semaphore binarySemaphore = new Semaphore(1);
    private final int id = (int) (Math.random() * 1000);

    public void take() {
        try {
            binarySemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fork " + id + " is taken");
    }

    public void put() {
        binarySemaphore.release();
    }
 /*   private Semaphore binarySemaphore;
    private boolean isTaken = false;

    public synchronized void take() throws InterruptedException {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }

    public synchronized void put() {
        isTaken = false;
        notify();
    }
  */
}
