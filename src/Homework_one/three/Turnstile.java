package Homework_one.three;

public class Turnstile extends Thread {

    private final Counter counter;
    private int maxValue;

    public Turnstile(Counter counter, int maxValue) {
        this.counter = counter;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.maxValue; i++) {
            counter.increase();
        }
    }
}

