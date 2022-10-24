package V2.erzeugerVerbraucherSystem;

import java.util.Random;

public class Producer extends Thread{

        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int data = random.nextInt(100);
                buffer.put(data);
                System.out.println("Producer put " + data);

            }
        }

}
