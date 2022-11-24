package hw5.CyclicBarrier;

public class CyclicBarrier {

    private int initial;

    private int counter;

    private int numberWaiting;

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public void setCount() {
        this.counter = initial;
        this.numberWaiting = 0;
    }

    public synchronized void await() throws InterruptedException {  //TODO deadlock möglich ...
        counter--;
        numberWaiting++;
        if (counter == 0) {
            counter = initial;
            numberWaiting = 0;
            notifyAll();
        } else {
            while (numberWaiting != initial) {
                wait();
            }
        }
    }

    public int getParties() {
        return initial;
    }

    public int getNumberWaiting() {
        return numberWaiting;
    }
}