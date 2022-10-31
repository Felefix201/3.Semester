package allHomework.WE2.two;

public class Buffer {

    private int data;
    private boolean full = false;

    public Buffer(int maxBufferSize) {
        if (maxBufferSize < 1) {
            throw new IllegalArgumentException("Buffer size must be greater than 0");
        }
    }


    public synchronized void put(int data) throws InterruptedException {
        System.out.println("Producer wants to put " + data);
        while (full) {
                wait();
            }
        this.data = data;
        System.out.println("Produced: " + data);
        full = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (!full) {
            wait();
        }
        System.out.println("Consumed: " + data);
        full = false;
        notifyAll();
        return data;
    }
}

