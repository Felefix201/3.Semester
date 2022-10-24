package V5.semaphore_LinkedBlockingQueue;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class LinkedBlockingQueue<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();
    private final Semaphore fullSemaphore;
    private final Semaphore emptySemaphore = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    public LinkedBlockingQueue(int capacity) {
        fullSemaphore = new Semaphore(capacity);
    }

    public void put(T value) throws InterruptedException {
        fullSemaphore.acquire();
//        synchronized (this) {
        mutex.acquire();
        linkedList.add(value);
//        }
        mutex.release();
        emptySemaphore.release();
    }

    public T get() throws InterruptedException {
        emptySemaphore.acquire();
        try {
//            synchronized (this) {
            mutex.acquire();
            return linkedList.poll();
//            }
        } finally {
            mutex.release();
            fullSemaphore.release();
        }
    }
}
