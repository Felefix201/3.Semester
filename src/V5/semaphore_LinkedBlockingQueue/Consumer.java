package V5.semaphore_LinkedBlockingQueue;

public class Consumer extends Thread {

    private final String name;
    private final LinkedBlockingQueue<Integer> q;

    public Consumer(String name, LinkedBlockingQueue<Integer> q) {
        this.name = name;
        this.q = q;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                int value = q.get();
            } catch (InterruptedException e) {
                break; // terminate Thread.
            }
        }
        System.out.println("Consumer terminated");
    }

    @Override
    public String toString() {
        return name;
    }
}