package hw4.LeserSchreiberKonzept.A3;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWAccessControl<T> {

    private T[] data;

    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public RWAccessControl(T[] initialData) {
        this.data = initialData;
    }

    public void write(Map<Integer, T> changes) {
        rwlock.writeLock().lock();
        for (int i = 0; i < data.length; i++) {
            if (changes.containsKey(i)) {
                data[i] = changes.get(i);
            }
        }
        rwlock.writeLock().unlock();
    }

    public T[] read() {
        rwlock.readLock().lock();
        try {
            return data;
        } finally {
            rwlock.readLock().unlock();
        }
    }
}
