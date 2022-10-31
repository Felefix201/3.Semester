package allHomework.WE2.three;

import java.util.Random;

public class Producer extends Thread {

    private Buffer buffer;


    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!isInterrupted()) {
            try {
                buffer.put(random.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer interupted");
    }

}
