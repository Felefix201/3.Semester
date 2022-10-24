package hw1.three;

public class Counter {

    private int counter = 0;

    public synchronized void increase() {
        int temp = counter;
        counter = temp + 1;
    }

    @Override
    public String toString() {
        return String.valueOf(counter);
    }

}

