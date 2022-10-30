package hw5.exchanger;


import java.util.concurrent.LinkedBlockingQueue;

public class Exchanger<V> {
    private int NumberWaiting;

    private V Object1;
    private V Object2;

    public synchronized V exchange(V q) throws InterruptedException {
        NumberWaiting++;
        System.out.println("NumberWaiting " + NumberWaiting);
        if (NumberWaiting == 2) {
            Object2 = q;
            System.out.println("Exchanger exchange");
            NumberWaiting = 0;
            notifyAll();
            return Object1;
        } else {
            Object1 = q;
            wait();
            return Object2;
        }
    }

}
