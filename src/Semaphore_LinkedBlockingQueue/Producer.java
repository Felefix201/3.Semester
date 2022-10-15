package Semaphore_LinkedBlockingQueue;

import java.util.Random;

public class Producer extends Thread {

    private final String name;
    private final LinkedBlockingQueue<Integer> q;

    public Producer(String name, LinkedBlockingQueue<Integer> q) {
        this.name = name;
        this.q = q;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!isInterrupted()) {
            try {
                int value = random.nextInt(10);
                q.put(value);
            } catch (InterruptedException e) {
                break; // terminate thread.
            }
        }
        System.out.println("Producer " + name + " done!");
    }


    @Override
    public String toString() {
        return name;
    }
}
