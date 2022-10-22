package LeserSchreiberKonzept;

import java.util.Map;

public class RWAccessControl<T> {

    private T[] data;
    private int activeReaders = 0;
    private int waitingReaders = 0;
    private boolean writerWriting = false;

    public RWAccessControl(T[] initialData) {
        data = initialData;
    }

    public void write(Map<Integer, T> changes) throws InterruptedException {

        synchronized (this) {
            while (activeReaders > 0 || writerWriting && waitingReaders > 0) {
                wait();
            }
            writerWriting = true;
        }
        for (int i = 0; i < data.length; i++) {
            if (changes.containsKey(i)) {
                data[i] = changes.get(i);
            }
        }
        synchronized (this) {
            writerWriting = false;
            notifyAll();
        }
    }


    public T[] read() throws InterruptedException {

        //block read if any writer is writing
        synchronized (this) {
            while (writerWriting) {
                waitingReaders++;
                this.wait();
                waitingReaders--;
            }
            activeReaders++;
        }
        try {
            return data;
        } finally {
            synchronized (this) {
                activeReaders--;
                if (activeReaders == 0) {
                    this.notifyAll();
                }
            }
        }
    }
}
