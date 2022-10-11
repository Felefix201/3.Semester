package ProducerConsumerExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BufferAldi {


    private final int maxBufferSize;
    private boolean bufferIsFull = false;
    private BlockingQueue<String> blockingQueue;
    private String product;

    public BufferAldi(int maxBufferSize) {
        if(maxBufferSize < 1) {
            throw new IllegalArgumentException("Buffer size must be greater than 0");
        }
        this.maxBufferSize = maxBufferSize;
        blockingQueue = new ArrayBlockingQueue<>(maxBufferSize);
    }

    public synchronized void put(String product) throws InterruptedException {
        while (bufferIsFull) {
            wait();
        }
        blockingQueue.put(product);
        this.product = product;
        System.out.println("Product: " + product + " is in the buffer Aldi");
        if (blockingQueue.size() == maxBufferSize) {
            bufferIsFull = true;
        }
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        System.out.println("this happens");
        while (blockingQueue.size() == 0) {
            wait();
        }
        blockingQueue.take();
        System.out.println("Product: " + product + " is taken from the buffer Aldi");
        bufferIsFull = false;
        notifyAll();
        return product;
    }

}
