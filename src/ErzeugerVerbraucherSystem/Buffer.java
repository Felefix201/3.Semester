package ErzeugerVerbraucherSystem;

public class Buffer {

    private boolean isEmpty = true;
    private int data;

    public synchronized void put(int data) {
        while (!isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer interupted");
            }
        }
        notifyAll();
        this.data = data;
        isEmpty = false;
    }

    public synchronized int get() {
        while (isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer Interrupted");;
            }
        }
        notifyAll();
        isEmpty = true;
        return data;
    }


    public String peek() {
        if (isEmpty) {
            return "Buffer is empty";
        } else {
            return "Buffer contains " + data;
        }
    }
}
