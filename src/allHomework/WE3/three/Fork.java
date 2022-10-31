package allHomework.WE3.three;

import java.util.concurrent.Semaphore;

public class Fork {
    private final Semaphore binarySemaphore = new Semaphore(1);
    private final int id = (int) (Math.random() * 100);

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
}
