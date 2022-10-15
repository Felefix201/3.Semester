package homework_three.h1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class LinkedBlockingQueue<T> {
    private LinkedList<T> linkedList = new LinkedList();
    private CountingSemaphore fullSemaphore;
    private CountingSemaphore emptySemaphore = new CountingSemaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    LinkedBlockingQueue(int capacity) {
        fullSemaphore = new CountingSemaphore(capacity);
    }

    public void putList(List<T> valueList) throws InterruptedException {
        int size = valueList.size();
        for (int i = 0; i < size; i++) {
            fullSemaphore.acquire();
        }

//        synchronized (this) {
        mutex.acquire();
        for (int i = 0; i < size; i++) {
            linkedList.add( valueList.get(i));
        }

        //        }
        mutex.release();
        for (int i = 0; i < size; i++) {
            emptySemaphore.release();
        }
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
//        synchronized (this) {
        try {
            mutex.acquire();
            return linkedList.poll();
        } finally {
            mutex.release();
            fullSemaphore.release();
        }
//        }
    }
}