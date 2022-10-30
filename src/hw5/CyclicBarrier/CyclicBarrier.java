package hw5.CyclicBarrier;

public class CyclicBarrier {

    private int initial;

    private int counter;

    private int NumberWaiting;

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public void setCount() {
        this.counter = initial;
        this.NumberWaiting = 0;
    }

    public synchronized void await() throws InterruptedException {
        counter--;
        NumberWaiting++;
        if (counter == 0) {
            counter = initial;
            NumberWaiting = 0;
            notifyAll();
        } else {
            wait();
        }
    }

    public int getParties() {
        return initial;
    }

    public int getNumberWaiting() {
        return NumberWaiting;
    }
}