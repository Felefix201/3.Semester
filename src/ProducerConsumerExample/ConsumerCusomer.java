package ProducerConsumerExample;

import java.util.ArrayList;
import java.util.Random;

public class ConsumerCusomer extends Thread{

    private final BufferRewe bufferRewe;
    private final BufferAldi bufferAldi;

    private boolean isStillConsumer = true;

    private ArrayList<String> shoppingList = new ArrayList<>(5);

    public ConsumerCusomer(BufferRewe bufferRewe, BufferAldi bufferAldi) {
        this.bufferRewe = bufferRewe;
        this.bufferAldi = bufferAldi;
    }

    @Override
    public void run() {
        Random random = new Random(10);
        int randomInt1 = random.nextInt();
        Random random2 = new Random(shoppingList.size());
        int randomInt2 = random2.nextInt();

        if (randomInt1 < 5) {
            while (isStillConsumer) {
                for (int i = 0; i < randomInt2; i++) {
                    try {
                        shoppingList.add(bufferAldi.get());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Consumer for Aldi is exploded and can not be used anymore");
        } else {
            while (isStillConsumer) {
                for (int i = 0; i < randomInt2; i++) {
                    try {
                        shoppingList.add(bufferRewe.get());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Consumer for Rewe is exploded and can not be used anymore");
        }
    }

    public void isStillConsumer(boolean isStillConsumer) {
        this.isStillConsumer = isStillConsumer;
    }


}
