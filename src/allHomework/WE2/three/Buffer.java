package allHomework.WE2.three;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {

    private BlockingQueue<Integer> dataQueue;

    public Buffer(int maxDataQueue) {
        dataQueue = new LinkedBlockingQueue<>(maxDataQueue);
    }


    public synchronized void put(int data) throws InterruptedException {
        System.out.println("Producer wants to put " + data);
        while (dataQueue.remainingCapacity() == 0) {
            wait();
        }
        dataQueue.put(data);
        System.out.println("Produced: " + data);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (dataQueue.size() == 0) {
            wait();
        }
        int data = dataQueue.poll();
        System.out.println("Consumed: " + data);
        notifyAll();
        return data;
    }
}

