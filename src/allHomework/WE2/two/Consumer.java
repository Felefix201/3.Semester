package allHomework.WE2.two;

public class Consumer extends Thread{

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                buffer.get();
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }
        System.out.println("Consumer interupted");
    }
}
