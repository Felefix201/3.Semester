package homework_three.h1.LinkedBlockingQueue;

public class CountingSemaphore {
    private int count;

    public CountingSemaphore(int initialCount) {
        count = initialCount;
    }

    public synchronized void acquire() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        count--;
    }

    public synchronized void acquire(int x) throws InterruptedException {
        while (count == 0) {
            wait();
        }
        for (int i = 0; i < x; i++) {
            count--;
        }
    }

    public synchronized void release() {
        count++;
        notify();
    }

    public synchronized void release(int x) {
        for (int i = 0; i < x; i++) {
            count++;
        }
        notify();
    }
}
