package Homework_two.consumerProducerInterrupt;

public class Consumer extends Thread{
    private final Buffer buffer;
    private boolean terminate = false;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while (!terminate) {
            try {
                buffer.get();
            } catch (InterruptedException e) {
                terminate = true;
            }
        }
        System.out.println("Consumer terminated");
    }
    public void terminate(){
        terminate = true;
    }
}
