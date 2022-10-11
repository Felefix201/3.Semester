package ErzeugerVerbraucherSystem;

import java.util.Random;

public class Consumer extends Thread{

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            int data = buffer.get();
            System.out.println("Consumer got " + data);
        }
        System.out.println("Consumer interupted");
    }


}
