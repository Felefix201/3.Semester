package hw2.consumerProducer.consumerProducerInterrupt;

import java.util.Random;

public class Producer extends Thread {
    private Buffer buffer;
    private boolean terminate = false;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!terminate) {
            buffer.put(random.nextInt());
        }
        System.out.println("Producer terminated");
    }

    public void terminate() {
        terminate = true;
    }
}
