package homework_three.h1;

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

    public synchronized void release() {
        count++;
        notify();
    }
}
