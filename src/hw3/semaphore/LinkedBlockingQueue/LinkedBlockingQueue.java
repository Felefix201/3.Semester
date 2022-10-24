package hw3.semaphore.LinkedBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class LinkedBlockingQueue<T> {
    private LinkedList<T> linkedList = new LinkedList();
    private CountingSemaphore itemCounter;
    private Semaphore availableItems;
    private CountingSemaphore emptySemaphore = new CountingSemaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    LinkedBlockingQueue(int capacity) {
        itemCounter = new CountingSemaphore(capacity);
    }

    public void put(T value) throws InterruptedException {
        itemCounter.acquire();
//        synchronized (this) {
        mutex.acquire();
        linkedList.add(value);

        //        }
        mutex.release();
        emptySemaphore.release();
    }


    public void put(List<T> valueList) throws InterruptedException {
        int size = valueList.size();
        itemCounter.acquire(size);

//        synchronized (this) {
        mutex.acquire();
        for (int i = 0; i < size; i++) {
            linkedList.add(valueList.get(i));
        }

        //        }
        mutex.release();
        emptySemaphore.release(size);
    }


    public T get() throws InterruptedException {
        emptySemaphore.acquire();
//        synchronized (this) {
        try {
            mutex.acquire();
            return linkedList.poll();
        } finally {
            mutex.release();
            itemCounter.release();
        }
//        }
    }
}