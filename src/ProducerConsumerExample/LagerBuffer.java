package ProducerConsumerExample;

public class LagerBuffer {
    private String[] data;
    private int w, r = 0;

    public LagerBuffer(int capacity) {
        data = new String[capacity];
    }

    public synchronized void put(String value) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data[w] = value;
        System.out.println("Produced: " + value);
        incW();
        notifyAll();
    }

    public synchronized String get() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String value = data[r];
        r = (r + 1) % data.length;
        incR();
        notifyAll();
        return value;
    }

    private void incW() {
        w = (w + 1) % data.length;
    }

    private int elementsStored() {
        return (w - r + data.length) % data.length;
    }

    private void incR() {
        r = (r + 1) % data.length;
    }

    private boolean isFull() {
        return (r - w) % data.length == 1;
    }

    private boolean isEmpty() {
        return r == w;
    }
}
