package allHomework.WE3.one;

public class CountingSemaphore {
    private int count;

    public CountingSemaphore(int count){
        this.count = count;
    }

    public synchronized void acquire() throws InterruptedException {
        while (count == 0){
            wait();
        }
        count--;
    }
    public synchronized void release() {
        count++;
        notify();
    }
}
