package hw5.exchanger;


import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Exchanger<LinkedBlockingQueue> exchanger = new Exchanger();
        LinkedBlockingQueue<Integer> initialEmptyBuffer = new LinkedBlockingQueue(3);
        LinkedBlockingQueue<Integer> initialFullBuffer = new LinkedBlockingQueue(3);

        new Thread(new FillingLoop(initialEmptyBuffer, initialFullBuffer, exchanger)).start();
        new Thread(new EmptyingLoop(initialEmptyBuffer, initialFullBuffer, exchanger)).start();

    }
}
