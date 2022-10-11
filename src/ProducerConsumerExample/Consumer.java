package ProducerConsumerExample;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread {
    private String marketFranchiseName;
    private ArrayBlockingQueue<String> availablaProducts;
    private LagerBuffer lagerBuffer;
    private int productCapacity;
    private boolean terminate = false;

    public Consumer(LagerBuffer lagerBuffer, int productCapacity, String marketFranchiseName) {
        this.availablaProducts = new ArrayBlockingQueue<>(productCapacity);
        this.productCapacity = productCapacity;
        this.lagerBuffer = lagerBuffer;
        this.marketFranchiseName = marketFranchiseName;
    }

    void terminate() {
        terminate = true;
        System.out.println("Consumer terminated");
    }

    private boolean isFull() {
        return availablaProducts.size() == productCapacity;
    }

    @Override
    public void run() {
        while (true) {
            String value = null;
            value = lagerBuffer.get();
            while(!isFull()) {
                availablaProducts.add(value);
            }
            System.out.println("Consumed: " + value);
        }
    }
}

