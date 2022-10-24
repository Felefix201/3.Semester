package LM.producerConsumerExample;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread {
    private String marketFranchiseName;
    private ArrayBlockingQueue<String> availableProductsInQueue;
    private LagerBuffer lagerBuffer;
    private int productCapacity;
    private boolean terminate = false;

    public Consumer(LagerBuffer lagerBuffer, int productCapacity, String marketFranchiseName) {
        this.availableProductsInQueue = new ArrayBlockingQueue<>(productCapacity);
        this.productCapacity = productCapacity;
        this.lagerBuffer = lagerBuffer;
        this.marketFranchiseName = marketFranchiseName;
    }

    void terminate() {
        terminate = true;
    }

    private boolean isFull() {
        return availableProductsInQueue.size() == productCapacity;
    }

    @Override
    public void run() {
        while (!terminate) {
            String value = "";
            value = lagerBuffer.get();
            while(!isFull()) {
                availableProductsInQueue.add(value);
            }
            System.out.println("Consumed: " + value);
        }
        System.out.println("Consumer terminated");
    }
}

