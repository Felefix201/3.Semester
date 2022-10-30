package hw5.exchanger;


import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

class FillingLoop implements Runnable {

    private LinkedBlockingQueue<Integer> initialEmptyBuffer;
    private LinkedBlockingQueue<Integer> initialFullBuffer;
    private Exchanger<LinkedBlockingQueue> exchanger;

    public FillingLoop(LinkedBlockingQueue<Integer> initialEmptyBuffer, LinkedBlockingQueue<Integer> initialFullBuffer, Exchanger<LinkedBlockingQueue> exchanger) {
        this.initialEmptyBuffer = initialEmptyBuffer;
        this.initialFullBuffer = initialFullBuffer;
        this.exchanger = exchanger;
    }

    public void run() {
        LinkedBlockingQueue q = initialEmptyBuffer;
        Random random = new Random();
        try {
            while (q != null) {
                int value = random.nextInt(10);
                Thread.sleep(500);
                System.out.println("Filling with value " + value);
                if (q.remainingCapacity() == 0) {
                    System.out.println("FillingLoop offering " + q);
                    q = exchanger.exchange(q);
                    System.out.println("FillingLoop received " + q);
                    Thread.sleep(2000);
                } 
                    q.put(value);

            }
        } catch (InterruptedException ex) {
        }
    }
}
