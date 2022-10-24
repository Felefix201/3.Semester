package hw2.consumerProducer.consumerProducerInterrupt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Buffer {
    private int data;
    private boolean empty = true;
    private BlockingQueue<Integer> blockingQueue;

    public Buffer(int maxBufferSize) {
        if (maxBufferSize < 1) {
            throw new IllegalArgumentException("Buffer size must be greater than 0");
        }
        blockingQueue = new LinkedBlockingDeque<>(maxBufferSize);
    }


    public synchronized void put(int data) {
        System.out.println("Producer wants to put " + data);
        while (!empty && blockingQueue.size() < blockingQueue.remainingCapacity()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            blockingQueue.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println("Produced: " + data);
        empty = false;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (empty) {
            wait();
        }
        int data = blockingQueue.take();
        empty = true;
        notifyAll();
        System.out.println("Consumed: " + data);
        return data;
    }
}

