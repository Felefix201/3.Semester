package hw5.exchanger;

import java.util.concurrent.LinkedBlockingQueue;

class EmptyingLoop implements Runnable {
    private LinkedBlockingQueue<Integer> initialEmptyBuffer;
    private LinkedBlockingQueue<Integer> initialFullBuffer;
    private Exchanger<LinkedBlockingQueue> exchanger;

    public EmptyingLoop(LinkedBlockingQueue<Integer> initialEmptyBuffer, LinkedBlockingQueue<Integer> initialFullBuffer, Exchanger<LinkedBlockingQueue> exchanger) {
        this.initialEmptyBuffer = initialEmptyBuffer;
        this.initialFullBuffer = initialFullBuffer;
        this.exchanger = exchanger;
    }

    public void run() {
        LinkedBlockingQueue q = initialFullBuffer;
        try {
            while (q != null) {
                if (q.isEmpty()) {
                    System.out.println("EmptyingLoop offering " + q);
                    q = exchanger.exchange(q);
                    System.out.println("EmptyingLoop received " + q);
                    Thread.sleep(2000);
                } else {
                    System.out.println("Taking " + q.take());
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}
