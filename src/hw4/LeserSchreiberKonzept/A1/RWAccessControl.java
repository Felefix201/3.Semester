package hw4.LeserSchreiberKonzept.A1;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class RWAccessControl<T> {

    private T[] data;

    private Semaphore writePermission = new Semaphore(1);

    private Semaphore waitingWriters = new Semaphore(0);

    private Semaphore waitingReaders;

    private Semaphore activeReaders = new Semaphore(0);

    public RWAccessControl(T[] initialData, int readers) {
        data = initialData;
        this.waitingReaders = new Semaphore(readers);
    }

    public void write(Map<Integer, T> changes) throws InterruptedException {
        this.waitingWriters.release();

        if (this.activeReaders.availablePermits() == 0 && this.writePermission.availablePermits() != 0) {
            this.writePermission.acquire();
            this.waitingWriters.acquire();
        }
        for (int i = 0; i < data.length; i++) {
            if (changes.containsKey(i)) {
                data[i] = changes.get(i);
            }
        }
        this.writePermission.release();
    }


    public T[] read() throws InterruptedException {


        if (!(this.writePermission.availablePermits() == 0) && this.waitingWriters.availablePermits() == 0) {
            this.waitingReaders.acquire();
            this.activeReaders.release();
        }
        try {
            return data;
        } finally {
            this.waitingReaders.release();
            this.activeReaders.acquire();
        }
    }
}
