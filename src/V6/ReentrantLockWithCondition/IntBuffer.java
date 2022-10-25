package V6.ReentrantLockWithCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntBuffer {
    private int value;
    private boolean isFull = false;

    Lock lock = new ReentrantLock();
    Condition fullCondition = lock.newCondition();
    Condition emptyCondition = lock.newCondition();

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while (isFull) {
                fullCondition.await();
                this.value = value;
                isFull = true;
            }
        } finally {
            lock.unlock();
            emptyCondition.signal();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (!isFull) {
                emptyCondition.await();
            }
            return value;
        } finally {
            lock.unlock();
            fullCondition.signal();
        }
    }


}
